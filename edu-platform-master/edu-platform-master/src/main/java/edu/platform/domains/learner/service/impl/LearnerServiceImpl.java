package edu.platform.domains.learner.service.impl;

import edu.platform.application.exceptions.BusinessException;
import edu.platform.application.exceptions.LearnerCode;
import edu.platform.application.model.request.SendGoogleMailRequest;
import edu.platform.application.service.MailService;
import edu.platform.application.utils.CryptoAlgorithmUtils;
import edu.platform.domains.learner.constant.LearnerMappingStatus;
import edu.platform.domains.learner.constant.LearnerStatus;
import edu.platform.domains.learner.mapper.LearnerMapper;
import edu.platform.domains.learner.model.entity.Learner;
import edu.platform.domains.learner.model.entity.LearnerMapping;
import edu.platform.domains.learner.model.request.*;
import edu.platform.domains.learner.model.response.LearnerGetListResponse;
import edu.platform.domains.learner.model.response.LearnerResponse;
import edu.platform.domains.learner.repository.LearnerMappingRepository;
import edu.platform.domains.learner.repository.LearnerRepository;
import edu.platform.domains.learner.service.LearnerService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LearnerServiceImpl implements LearnerService {

    private LearnerRepository learnerRepository;
    private LearnerMapper learnerMapper;
    private MailService mailService;
    private LearnerMappingRepository learnerMappingRepository;

    @Override
    public LearnerResponse save(LearnerSaveRequest request) {
        Optional<Learner> checkEmail = getLearnerByEmail(request.getEmail());
        if (checkEmail.isPresent()) {
            throw new BusinessException(LearnerCode.LEARNER_EMAIL_EXIST);
        }

        Learner learner = learnerMapper.to(request);
        learner.setStatus(LearnerStatus.PENDING);
        learner.setPassword(CryptoAlgorithmUtils.md5(learner.getPassword()));

        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        boolean isChildAccount = currentYear - request.getYearOfBirth() < 13;

        learner.setIsChildAccount(isChildAccount);

        String activeCode = generateActiveCode();
        learner.setActiveCode(activeCode);

        learner = learnerRepository.save(learner);

        SendGoogleMailRequest mailRequest = new SendGoogleMailRequest();
        mailRequest.setFrom("longpham162@gmail.com");
        mailRequest.setTo(request.getEmail());
        mailRequest.setSubject("Edu platform activation!");
        mailRequest.setContent(String.format("Your activation code is: %s", activeCode));

        mailService.sendGoogleMail(mailRequest);

        return learnerMapper.to(learner);
    }

    @Override
    public void active(Long learnerId, LearnerActiveRequest request) {
        Learner learner = getLearner(learnerId);

        if (learner.getStatus().toString().equals(LearnerStatus.ACTIVE.toString())) {
            throw new BusinessException(LearnerCode.LEARNER_ALREADY_ACTIVE);
        }

        if (!request.getActiveCode().equals(learner.getActiveCode())) {
            throw new BusinessException(LearnerCode.LEARNER_WRONG_ACTIVE_CODE);
        }

        learner.setStatus(LearnerStatus.ACTIVE);
        learner.setActiveCode("");

        learnerRepository.save(learner);
    }

    @Override
    public LearnerResponse auth(LearnerAuthRequest request) {
        request.setPassword(CryptoAlgorithmUtils.md5(request.getPassword()));
        Optional<Learner> learner = learnerRepository.findByEmailAndPassword(request.getAccount(), request.getPassword());
        learner.orElseThrow(() -> new BusinessException(LearnerCode.LEARNER_LOGIN_REJECT));

        return learnerMapper.to(learner.get());
    }

    @Override
    public void mappingAdultAccount(LearnerMappingRequest request) {
        Learner learner = getLearner(request.getId());
        Optional<Learner> adultOptional = getLearnerByEmail(request.getAdultAccountEmail());
        adultOptional.orElseThrow(() -> new BusinessException(LearnerCode.LEARNER_ADULT_NOT_FOUND));

        Learner adult = adultOptional.get();

        LearnerMapping learnerMapping = new LearnerMapping();
        learnerMapping.setChildAccountId(learner.getId());
        learnerMapping.setAdultAccountId(adult.getId());
        learnerMapping.setMappingStatus(LearnerMappingStatus.PENDING);

        String mappingCode = generateActiveCode();

        learnerMapping.setMappingCode(mappingCode);

        learnerMappingRepository.save(learnerMapping);

        SendGoogleMailRequest mailRequest = new SendGoogleMailRequest();
        mailRequest.setFrom("longpham162@gmail.com");
        mailRequest.setTo(adult.getEmail());
        mailRequest.setSubject("Edu platform mapping account!");
        mailRequest.setContent(String.format("Your mapping code is: %s", mappingCode));

        mailService.sendGoogleMail(mailRequest);
    }

    @Override
    public void confirmMappingAdultAccount(LearnerConfirmMappingRequest request) {
        Learner learner = getLearner(request.getId());
        Optional<Learner> adult = getLearnerByEmail(request.getAdultAccountEmail());
        adult.orElseThrow(() -> new BusinessException(LearnerCode.LEARNER_ADULT_NOT_FOUND));

        Optional<LearnerMapping> learnerMappingOptional = learnerMappingRepository.findByChildAccountIdAndAdultAccountId(learner.getId(), adult.get().getId());
        learnerMappingOptional.orElseThrow(() -> new BusinessException(LearnerCode.LEARNER_MAPPING_FOUND));

        LearnerMapping learnerMapping = learnerMappingOptional.get();

        if (learnerMapping.getMappingStatus().toString().equals(LearnerMappingStatus.SUCCESS.toString())) {
            throw new BusinessException(LearnerCode.LEARNER_ALREADY_MAPPED);
        }

        if (!request.getMappingCode().equals(learnerMapping.getMappingCode())) {
            throw new BusinessException(LearnerCode.LEARNER_MAPPING_CODE_WRONG);
        }

        learnerMapping.setMappingStatus(LearnerMappingStatus.SUCCESS);

        learnerMappingRepository.save(learnerMapping);
    }

    @Override
    public LearnerGetListResponse getList(LearnerGetListRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize(), Sort.Direction.DESC, "id");

        Page<Learner> learnerPage = learnerRepository.findAll(pageable);

        LearnerGetListResponse response = new LearnerGetListResponse();
        response.setTotal(learnerPage.getTotalElements());

        List<LearnerResponse> list = learnerPage.getContent().stream()
                .map(learner -> learnerMapper.to(learner)).collect(Collectors.toList());

        response.setList(list);

        return response;
    }

    private Learner getLearner(Long learnerId) {
        Optional<Learner> learner = learnerRepository.findById(learnerId);
        learner.orElseThrow(() -> new BusinessException(LearnerCode.LEARNER_NOT_FOUND));

        return learner.get();
    }

    private Optional<Learner> getLearnerByEmail(String email) {
        return learnerRepository.findByEmail(email);
    }

    private String generateActiveCode() {
        int length = 4;
        boolean useLetters = false;
        boolean useNumbers = true;

        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
    }
}
