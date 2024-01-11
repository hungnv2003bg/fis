package edu.platform.domains.staff.service.impl;

import edu.platform.application.exceptions.BusinessException;
import edu.platform.application.exceptions.StaffCode;
import edu.platform.application.utils.CryptoAlgorithmUtils;
import edu.platform.domains.staff.constant.StaffStatus;
import edu.platform.domains.staff.mapper.StaffMapper;
import edu.platform.domains.staff.model.entity.Staff;
import edu.platform.domains.staff.model.request.*;
import edu.platform.domains.staff.model.response.StaffGetListResponse;
import edu.platform.domains.staff.model.response.StaffResponse;
import edu.platform.domains.staff.repository.StaffRepository;
import edu.platform.domains.staff.service.StaffService;
import lombok.AllArgsConstructor;
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
public class StaffServiceImpl implements StaffService {

    private StaffRepository staffRepository;
    private StaffMapper staffMapper;

    @Override
    public StaffResponse auth(StaffAuthRequest request) {
        String password = CryptoAlgorithmUtils.md5(request.getPassword());
        Optional<Staff> staffOptional = staffRepository.findByAccountAndPassword(request.getAccount(), password);
        staffOptional.orElseThrow(() -> new BusinessException(StaffCode.STAFF_LOGIN_REJECT));

        Staff staff = staffOptional.get();
        if (staff.getStatus().toString().equals(StaffStatus.LOCK.toString())) {
            throw new BusinessException(StaffCode.STAFF_LOCKED);
        }

        return staffMapper.to(staff);
    }

    @Override
    public StaffGetListResponse getList(StaffGetListRequest request) {
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize(), Sort.Direction.DESC, "id");

        Page<Staff> staffPage = staffRepository.findAll(pageable);

        StaffGetListResponse response = new StaffGetListResponse();
        response.setTotal(staffPage.getTotalElements());

        List<StaffResponse> list = staffPage.getContent().stream()
                .map(staff -> staffMapper.to(staff)).collect(Collectors.toList());

        response.setList(list);

        return response;
    }

    @Override
    public StaffResponse save(StaffSaveRequest request) {
        Optional<Staff> checkEmail = getStaffByEmail(request.getEmail());
        if (checkEmail.isPresent()) {
            throw new BusinessException(StaffCode.STAFF_EMAIL_EXIST);
        }

        Optional<Staff> checkAccount = getStaffByAccount(request.getAccount());
        if (checkAccount.isPresent()) {
            throw new BusinessException(StaffCode.STAFF_ACCOUNT_EXIST);
        }

        Staff staff = staffMapper.to(request);
        staff.setStatus(StaffStatus.ACTIVE);
        staff.setPassword(CryptoAlgorithmUtils.md5(request.getPassword()));

        staff = staffRepository.save(staff);

        return staffMapper.to(staff);
    }

    @Override
    public void lock(Long staffId) {
        Staff staff = getStaffById(staffId);
        staff.setStatus(StaffStatus.LOCK);

        staffRepository.save(staff);
    }

    @Override
    public void unlock(Long staffId) {
        Staff staff = getStaffById(staffId);
        staff.setStatus(StaffStatus.ACTIVE);

        staffRepository.save(staff);
    }

    @Override
    public void changePassword(StaffChangePasswordRequest request) {
        Staff staff = getStaffById(request.getId());

        String currentPassword = CryptoAlgorithmUtils.md5(request.getCurrentPassword());
        String newPassword = CryptoAlgorithmUtils.md5(request.getNewPassword());

        if (!currentPassword.equals(staff.getPassword())) {
            throw new BusinessException(StaffCode.STAFF_CURRENT_PASSWORD_NOT_MATCH);
        }

        staff.setPassword(newPassword);

        staffRepository.save(staff);
    }

    @Override
    public void resetPassword(StaffResetPasswordRequest request) {
        String password = CryptoAlgorithmUtils.md5(request.getPassword());

        Staff staff = getStaffById(request.getId());
        staff.setPassword(password);

        staffRepository.save(staff);
    }

    @Override
    public StaffResponse getStaff(Long id) {
        Staff staff = getStaffById(id);

        return staffMapper.to(staff);
    }

    private Staff getStaffById(Long id) {
        Optional<Staff> staffOptional = staffRepository.findById(id);
        staffOptional.orElseThrow(() -> new BusinessException(StaffCode.STAFF_NOT_FOUND));

        return staffOptional.get();
    }

    private Optional<Staff> getStaffByEmail(String email) {
        return staffRepository.findByEmail(email);
    }

    private Optional<Staff> getStaffByAccount(String account) {
        return staffRepository.findByAccount(account);
    }
}
