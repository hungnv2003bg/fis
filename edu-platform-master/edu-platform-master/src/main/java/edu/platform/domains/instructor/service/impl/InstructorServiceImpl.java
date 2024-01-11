package edu.platform.domains.instructor.service.impl;

import edu.platform.application.exceptions.BusinessException;
import edu.platform.application.exceptions.InstructorCode;
import edu.platform.application.model.request.SendGoogleMailRequest;
import edu.platform.application.service.MailService;
import edu.platform.application.utils.CryptoAlgorithmUtils;
import edu.platform.domains.instructor.constant.InstructorStatus;
import edu.platform.domains.instructor.constant.InstructorVerifyStatus;
import edu.platform.domains.instructor.mapper.InstructorMapper;
import edu.platform.domains.instructor.model.entity.Instructor;
import edu.platform.domains.instructor.model.request.*;
import edu.platform.domains.instructor.model.response.InstructorGetListResponse;
import edu.platform.domains.instructor.model.response.InstructorResponse;
import edu.platform.domains.instructor.repository.InstructorRepository;
import edu.platform.domains.instructor.service.InstructorService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository instructorRepository;
    private InstructorMapper instructorMapper;
    private MailService mailService;

    @Override
    public InstructorResponse save(InstructorSaveRequest request) {
        Optional<Instructor> checkEmail = getInstructorByEmail(request.getEmail());
        if (checkEmail.isPresent()) {
            throw new BusinessException(InstructorCode.INSTRUCTOR_EMAIL_EXIST);
        }

        Instructor instructor = instructorMapper.to(request);
        instructor.setStatus(InstructorStatus.PENDING);
        instructor.setPassword(CryptoAlgorithmUtils.md5(instructor.getPassword()));

        String activeCode = generateActiveCode();

        instructor.setActiveCode(activeCode);
        instructor.setVerifyStatus(InstructorVerifyStatus.NONE);

        instructor = instructorRepository.save(instructor);

        SendGoogleMailRequest mailRequest = new SendGoogleMailRequest();
        mailRequest.setFrom("longpham162@gmail.com");
        mailRequest.setTo(request.getEmail());
        mailRequest.setSubject("Edu platform activation!");
        mailRequest.setContent(String.format("Your activation code is: %s", activeCode));

        mailService.sendGoogleMail(mailRequest);

        return instructorMapper.to(instructor);
    }

    @Override
    public InstructorResponse auth(InstructorAuthRequest request) {
        request.setPassword(CryptoAlgorithmUtils.md5(request.getPassword()));

        Optional<Instructor> instructor = instructorRepository.findByEmailAndPassword(request.getAccount(), request.getPassword());
        instructor.orElseThrow(() -> new BusinessException(InstructorCode.INSTRUCTOR_LOGIN_REJECT));

        return instructorMapper.to(instructor.get());
    }

    @Override
    public InstructorResponse update(Long id, InstructorUpdateRequest request) {

        Instructor instructor = getInstructor(id);

        instructor = instructorMapper.to(request, instructor);
        instructor = instructorRepository.save(instructor);

        return instructorMapper.to(instructor);
    }

    @Override
    public void changePassword(Long id, InstructorChangePasswordRequest request) {
        Instructor instructor = getInstructor(id);

        String currentPassword = CryptoAlgorithmUtils.md5(request.getCurrentPassword());
        String newPassword = CryptoAlgorithmUtils.md5(request.getNewPassword());

        if (!currentPassword.equals(instructor.getPassword())) {
            throw new BusinessException(InstructorCode.INSTRUCTOR_WRONG_CURRENT_PASSWORD);
        }

        instructor.setPassword(newPassword);

        instructorRepository.save(instructor);
    }

    @Override
    public void active(Long id, InstructorActiveRequest request) {
        Instructor instructor = getInstructor(id);

        if (instructor.getStatus().toString().equals(InstructorStatus.ACTIVE.toString())) {
            throw new BusinessException(InstructorCode.INSTRUCTOR_ALREADY_ACTIVE);
        }

        if (!request.getActiveCode().equals(instructor.getActiveCode())) {
            throw new BusinessException(InstructorCode.INSTRUCTOR_WRONG_ACTIVE_CODE);
        }

        instructor.setStatus(InstructorStatus.ACTIVE);
        instructor.setActiveCode("");

        instructorRepository.save(instructor);
    }

    @Override
    public InstructorGetListResponse getList(InstructorGetListRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize(), Sort.Direction.DESC, "id");

        Page<Instructor> instructorPage = instructorRepository.findAll(pageable);

        InstructorGetListResponse response = new InstructorGetListResponse();
        response.setTotal(instructorPage.getTotalElements());

        List<InstructorResponse> list = instructorPage.getContent().stream()
                .map(instructor -> instructorMapper.to(instructor)).collect(Collectors.toList());

        response.setList(list);

        return response;
    }

    private Instructor getInstructor(Long id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);

        instructor.orElseThrow(() -> new BusinessException(InstructorCode.INSTRUCTOR_NOT_FOUND));

        return instructor.get();
    }

    private Optional<Instructor> getInstructorByEmail(String email) {
        return instructorRepository.findByEmail(email);
    }

    private String generateActiveCode() {
        int length = 4;
        boolean useLetters = false;
        boolean useNumbers = true;

        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
