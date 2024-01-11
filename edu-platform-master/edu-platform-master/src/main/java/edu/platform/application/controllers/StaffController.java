package edu.platform.application.controllers;

import edu.platform.application.constant.RoleConstant;
import edu.platform.application.exceptions.BusinessException;
import edu.platform.application.exceptions.StaffCode;
import edu.platform.application.validators.StaffValidator;
import edu.platform.domains.staff.model.request.*;
import edu.platform.domains.staff.model.response.StaffResponse;
import edu.platform.domains.staff.service.StaffService;
import edu.platform.security.jwt.TokenProducer;
import edu.platform.security.jwt.payload.Payload;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staffs")
@AllArgsConstructor
public class StaffController extends BaseController {

    private StaffService staffService;
    private StaffValidator staffValidator;
    private TokenProducer tokenProducer;

    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody StaffAuthRequest request) {
        staffValidator.validateStaffAuthRequest(request);

        StaffResponse auth = staffService.auth(request);
        Payload payload = buildPayload(auth);
        String jwt = tokenProducer.token(payload);

        return success(jwt);
    }

    @GetMapping
    @PreAuthorize(value = RoleConstant.ROLE_ADMIN)
    public ResponseEntity getList(StaffGetListRequest request) {
        staffValidator.validateStaffGetListRequest(request);

        return success(staffService.getList(request));
    }

    @PostMapping
    @PreAuthorize(value = RoleConstant.ROLE_ADMIN)
    public ResponseEntity save(@RequestBody StaffSaveRequest request) {
        staffValidator.validateStaffSaveRequest(request);

        return success(staffService.save(request));
    }

    @PostMapping("/{staff_id}/lock")
    @PreAuthorize(value = RoleConstant.ROLE_ADMIN)
    public ResponseEntity lock(@PathVariable("staff_id") Long staffId) {
        if (staffId == getUserDetail().getUser().getId()) {
            throw new BusinessException(StaffCode.STAFF_NOT_LOCK_UNLOCK_YOUR_SELF);
        }

        staffService.lock(staffId);

        return success();
    }

    @PostMapping("/{staff_id}/unlock")
    @PreAuthorize(value = RoleConstant.ROLE_ADMIN)
    public ResponseEntity unlock(@PathVariable(value = "staff_id") Long staffId) {
        if (staffId == getUserDetail().getUser().getId()) {
            throw new BusinessException(StaffCode.STAFF_NOT_LOCK_UNLOCK_YOUR_SELF);
        }

        staffService.unlock(staffId);

        return success();
    }

    @PostMapping("/change-password")
    @PreAuthorize(value = RoleConstant.ROLE_STAFF)
    public ResponseEntity changePassword(@RequestBody StaffChangePasswordRequest request) {
        long staffId = getUserDetail().getUser().getId();
        request.setId(staffId);

        staffValidator.validateStaffChangePasswordRequest(request);

        staffService.changePassword(request);

        return success();
    }

    @PostMapping("/{staff_id}/reset-password")
    @PreAuthorize(value = RoleConstant.ROLE_ADMIN)
    public ResponseEntity resetPassword(@PathVariable("staff_id") Long staffId,
                                        @RequestBody StaffResetPasswordRequest request) {
        if (staffId == getUserDetail().getUser().getId()) {
            throw new BusinessException(StaffCode.STAFF_NOT_RESET_PASSWORD_YOUR_SELF);
        }

        request.setId(staffId);
        staffValidator.validateStaffResetPasswordRequest(request);

        staffService.resetPassword(request);

        return success();
    }

    @GetMapping("/{staff_id}")
    @PreAuthorize(value = RoleConstant.ROLE_ADMIN)
    public ResponseEntity getStaff(@PathVariable("staff_id") Long staffId) {
        return success(staffService.getStaff(staffId));
    }

    @GetMapping("/profile")
    @PreAuthorize(value = RoleConstant.ROLE_STAFF)
    public ResponseEntity getProfile() {
        long staffId = getUserDetail().getUser().getId();

        return success(staffService.getStaff(staffId));
    }

    private Payload buildPayload(StaffResponse staffResponse) {
        Payload payload = new Payload();
        payload.setId(staffResponse.getId());
        payload.setPhoneNumber("");
        payload.setEmail(staffResponse.getEmail());
        payload.setAccount(staffResponse.getAccount());
        payload.setRole(staffResponse.getRoles());

        return payload;
    }
}
