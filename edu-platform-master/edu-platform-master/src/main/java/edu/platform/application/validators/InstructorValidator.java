package edu.platform.application.validators;

import edu.platform.application.exceptions.BusinessException;
import edu.platform.application.exceptions.InstructorCode;
import edu.platform.domains.instructor.model.request.*;
import org.springframework.stereotype.Component;

@Component
public class InstructorValidator {

    public void validateInstructorSaveRequest(InstructorSaveRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(InstructorCode.INSTRUCTOR_SAVE_NULL))
                .requireNonBlank(InstructorSaveRequest::getFamilyName, () -> new BusinessException(InstructorCode.INSTRUCTOR_FAMILY_NAME_BLANK))
                .requireNonBlank(InstructorSaveRequest::getFirstName, () -> new BusinessException(InstructorCode.INSTRUCTOR_FIRST_NAME_BLANK))
                .requireNonBlank(InstructorSaveRequest::getEmail, () -> new BusinessException(InstructorCode.INSTRUCTOR_EMAIL_BLANK))
                .requireNonBlank(InstructorSaveRequest::getPassword, () -> new BusinessException(InstructorCode.INSTRUCTOR_PASSWORD_BLANK))
                .requireNonDefaultInteger(InstructorSaveRequest::getYearOfBirth, () -> new BusinessException(InstructorCode.INSTRUCTOR_YEAR_OF_BIRTH_BLANK))
                .requireNonBlank(InstructorSaveRequest::getAddress, () -> new BusinessException(InstructorCode.INSTRUCTOR_ADDRESS_BLANK))
                .requireNonDefaultLong(InstructorSaveRequest::getProvinceId, () -> new BusinessException(InstructorCode.INSTRUCTOR_PROVINCE_BLANK))
                .requireNonDefaultLong(InstructorSaveRequest::getDistrictId, () -> new BusinessException(InstructorCode.INSTRUCTOR_DISTRICT_BLANK))
                .requireNonDefaultLong(InstructorSaveRequest::getWardId, () -> new BusinessException(InstructorCode.INSTRUCTOR_WARD_BLANK))
                .validate(InstructorSaveRequest::getFamilyName, familyName -> familyName.length() > 255, () -> new BusinessException(InstructorCode.INSTRUCTOR_FAMILY_NAME_MAX_LENGTH))
                .validate(InstructorSaveRequest::getFirstName, firstName -> firstName.length() > 255, () -> new BusinessException(InstructorCode.INSTRUCTOR_FIRST_NAME_MAX_LENGTH))
                .validate(InstructorSaveRequest::getEmail, email -> email.length() > 255, () -> new BusinessException(InstructorCode.INSTRUCTOR_EMAIL_MAX_LENGTH))
                .validate(InstructorSaveRequest::getPassword, password -> password.length() > 255, () -> new BusinessException(InstructorCode.INSTRUCTOR_PASSWORD_MAX_LENGTH))
                .validate(InstructorSaveRequest::getAddress, address -> address.length() > 255, () -> new BusinessException(InstructorCode.INSTRUCTOR_ADDRESS_MAX_LENGTH))
                .get();
    }

    public void validateInstructorAuthRequest(InstructorAuthRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(InstructorCode.INSTRUCTOR_AUTH_NULL))
                .requireNonBlank(InstructorAuthRequest::getAccount, () -> new BusinessException(InstructorCode.INSTRUCTOR_ACCOUNT_BLANK))
                .requireNonBlank(InstructorAuthRequest::getPassword, () -> new BusinessException(InstructorCode.INSTRUCTOR_PASSWORD_BLANK))
                .get();
    }

    public void validateInstructorUpdateRequest(InstructorUpdateRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(InstructorCode.INSTRUCTOR_UPDATE_NULL))
                .requireNonBlank(InstructorUpdateRequest::getFamilyName, () -> new BusinessException(InstructorCode.INSTRUCTOR_FAMILY_NAME_BLANK))
                .requireNonBlank(InstructorUpdateRequest::getFirstName, () -> new BusinessException(InstructorCode.INSTRUCTOR_FIRST_NAME_BLANK))
                .requireNonDefaultInteger(InstructorUpdateRequest::getYearOfBirth, () -> new BusinessException(InstructorCode.INSTRUCTOR_YEAR_OF_BIRTH_BLANK))
                .requireNonBlank(InstructorUpdateRequest::getAddress, () -> new BusinessException(InstructorCode.INSTRUCTOR_ADDRESS_BLANK))
                .requireNonDefaultLong(InstructorUpdateRequest::getProvinceId, () -> new BusinessException(InstructorCode.INSTRUCTOR_PROVINCE_BLANK))
                .requireNonDefaultLong(InstructorUpdateRequest::getDistrictId, () -> new BusinessException(InstructorCode.INSTRUCTOR_DISTRICT_BLANK))
                .requireNonDefaultLong(InstructorUpdateRequest::getWardId, () -> new BusinessException(InstructorCode.INSTRUCTOR_WARD_BLANK))
                .validate(InstructorUpdateRequest::getFamilyName, familyName -> familyName.length() > 255, () -> new BusinessException(InstructorCode.INSTRUCTOR_FAMILY_NAME_MAX_LENGTH))
                .validate(InstructorUpdateRequest::getFirstName, firstName -> firstName.length() > 255, () -> new BusinessException(InstructorCode.INSTRUCTOR_FIRST_NAME_MAX_LENGTH))
                .validate(InstructorUpdateRequest::getAddress, address -> address.length() > 255, () -> new BusinessException(InstructorCode.INSTRUCTOR_ADDRESS_MAX_LENGTH))
                .get();
    }

    public void validateInstructorChangePasswordRequest(InstructorChangePasswordRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(InstructorCode.INSTRUCTOR_CHANGE_PASSWORD_NULL))
                .requireNonBlank(InstructorChangePasswordRequest::getCurrentPassword, () -> new BusinessException(InstructorCode.INSTRUCTOR_CURRENT_PASSWORD_BLANK))
                .requireNonBlank(InstructorChangePasswordRequest::getNewPassword, () -> new BusinessException(InstructorCode.INSTRUCTOR_NEW_PASSWORD_BLANK))
                .validate(InstructorChangePasswordRequest::getNewPassword, newPassword -> newPassword.length() > 255, () -> new BusinessException(InstructorCode.INSTRUCTOR_NEW_PASSWORD_MAX_LENGTH))
                .get();
    }

    public void validateInstructorActiveRequest(InstructorActiveRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(InstructorCode.INSTRUCTOR_ACTIVE_NULL))
                .requireNonBlank(InstructorActiveRequest::getActiveCode, () -> new BusinessException(InstructorCode.INSTRUCTOR_ACTIVE_CODE_BLANK))
                .get();
    }

    public void validateInstructorGetListRequest(InstructorGetListRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(InstructorCode.INSTRUCTOR_GET_LIST_NULL))
                .requireNonDefaultLong(InstructorGetListRequest::getPage, () -> new BusinessException(InstructorCode.INSTRUCTOR_GET_LIST_PAGE_BLANK))
                .requireNonDefaultLong(InstructorGetListRequest::getSize, () -> new BusinessException(InstructorCode.INSTRUCTOR_GET_LIST_SIZE_BLANK));
    }
}
