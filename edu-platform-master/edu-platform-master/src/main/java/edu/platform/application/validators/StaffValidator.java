package edu.platform.application.validators;

import edu.platform.application.exceptions.BusinessException;
import edu.platform.application.exceptions.StaffCode;
import edu.platform.domains.staff.model.request.*;
import org.springframework.stereotype.Component;

@Component
public class StaffValidator {

    public void validateStaffAuthRequest(StaffAuthRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(StaffCode.STAFF_AUTH_NULL))
                .requireNonBlank(StaffAuthRequest::getAccount, () -> new BusinessException(StaffCode.STAFF_ACCOUNT_BLANK))
                .requireNonBlank(StaffAuthRequest::getPassword, () -> new BusinessException(StaffCode.STAFF_PASSWORD_BLANK))
                .get();
    }

    public void validateStaffGetListRequest(StaffGetListRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(StaffCode.STAFF_GET_LIST_NULL))
                .requireNonDefaultLong(StaffGetListRequest::getPage, () -> new BusinessException(StaffCode.STAFF_GET_LIST_PAGE_BLANK))
                .requireNonDefaultLong(StaffGetListRequest::getSize, () -> new BusinessException(StaffCode.STAFF_GET_LIST_SIZE_BLANK))
                .get();
    }

    public void validateStaffSaveRequest(StaffSaveRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(StaffCode.STAFF_SAVE_NULL))
                .requireNonBlank(StaffSaveRequest::getAccount, () -> new BusinessException(StaffCode.STAFF_ACCOUNT_BLANK))
                .requireNonBlank(StaffSaveRequest::getPassword, () -> new BusinessException(StaffCode.STAFF_PASSWORD_BLANK))
                .requireNonBlank(StaffSaveRequest::getEmail, () -> new BusinessException(StaffCode.STAFF_EMAIL_BLANK))
                .requireNonBlank(StaffSaveRequest::getFullName, () -> new BusinessException(StaffCode.STAFF_FULL_NAME_BLANK))
                .requireNonBlank(StaffSaveRequest::getRoles, () -> new BusinessException(StaffCode.STAFF_ROLES_BLANK))
                .validate(StaffSaveRequest::getAccount, account -> account.length() > 255, () -> new BusinessException(StaffCode.STAFF_ACCOUNT_MAX_LENGTH))
                .validate(StaffSaveRequest::getPassword, password -> password.length() > 255, () -> new BusinessException(StaffCode.STAFF_PASSWORD_MAX_LENGTH))
                .validate(StaffSaveRequest::getEmail, email -> email.length() > 255, () -> new BusinessException(StaffCode.STAFF_EMAIL_MAX_LENGTH))
                .validate(StaffSaveRequest::getFullName, fullName -> fullName.length() > 255, () -> new BusinessException(StaffCode.STAFF_FULL_NAME_MAX_LENGTH))
                .validate(StaffSaveRequest::getRoles, roles -> roles.length() > 255, () -> new BusinessException(StaffCode.STAFF_ROLES_MAX_LENGTH))
                .get();
    }

    public void validateStaffChangePasswordRequest(StaffChangePasswordRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(StaffCode.STAFF_CHANGE_PASSWORD_NULL))
                .requireNonBlank(StaffChangePasswordRequest::getCurrentPassword, () -> new BusinessException(StaffCode.STAFF_CURRENT_PASSWORD_BLANK))
                .requireNonBlank(StaffChangePasswordRequest::getNewPassword, () -> new BusinessException(StaffCode.STAFF_NEW_PASSWORD_BLANK))
                .validate(StaffChangePasswordRequest::getCurrentPassword, currentPassword -> currentPassword.length() > 255, () -> new BusinessException(StaffCode.STAFF_CURRENT_PASSWORD_MAX_LENGTH))
                .validate(StaffChangePasswordRequest::getNewPassword, newPassword -> newPassword.length() > 255, () -> new BusinessException(StaffCode.STAFF_NEW_PASSWORD_MAX_LENGTH))
                .get();
    }

    public void validateStaffResetPasswordRequest(StaffResetPasswordRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(StaffCode.STAFF_RESET_PASSWORD_NULL))
                .requireNonBlank(StaffResetPasswordRequest::getPassword, () -> new BusinessException(StaffCode.STAFF_PASSWORD_BLANK))
                .validate(StaffResetPasswordRequest::getPassword, password -> password.length() > 255, () -> new BusinessException(StaffCode.STAFF_PASSWORD_MAX_LENGTH))
                .get();
    }
}
