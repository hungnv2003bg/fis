package edu.platform.application.validators;

import edu.platform.application.exceptions.BusinessException;
import edu.platform.application.exceptions.LearnerCode;
import edu.platform.domains.learner.model.request.*;
import org.springframework.stereotype.Component;

@Component
public class LearnerValidator {

    public void validateLearnerSaveRequest(LearnerSaveRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(LearnerCode.LEARNER_SAVE_NULL))
                .requireNonBlank(LearnerSaveRequest::getFamilyName, () -> new BusinessException(LearnerCode.LEARNER_FAMILY_NAME_BLANK))
                .requireNonBlank(LearnerSaveRequest::getFirstName, () -> new BusinessException(LearnerCode.LEARNER_FIRST_NAME_BLANK))
                .requireNonBlank(LearnerSaveRequest::getEmail, () -> new BusinessException(LearnerCode.LEARNER_EMAIL_BLANK))
                .requireNonBlank(LearnerSaveRequest::getPassword, () -> new BusinessException(LearnerCode.LEARNER_PASSWORD_BLANK))
                .requireNonDefaultInteger(LearnerSaveRequest::getYearOfBirth, () -> new BusinessException(LearnerCode.LEARNER_YEAR_OF_BIRTH_BLANK))
                .requireNonDefaultLong(LearnerSaveRequest::getProvinceId, () -> new BusinessException(LearnerCode.LEARNER_PROVINCE_BLANK))
                .requireNonDefaultLong(LearnerSaveRequest::getDistrictId, () -> new BusinessException(LearnerCode.LEARNER_DISTRICT_BLANK))
                .requireNonDefaultLong(LearnerSaveRequest::getWardId, () -> new BusinessException(LearnerCode.LEARNER_WARD_BLANK))
                .validate(LearnerSaveRequest::getFamilyName, familyName -> familyName.length() > 255, () -> new BusinessException(LearnerCode.LEARNER_FAMILY_NAME_MAX_LENGTH))
                .validate(LearnerSaveRequest::getFirstName, firstName -> firstName.length() > 255, () -> new BusinessException(LearnerCode.LEARNER_FIRST_NAME_MAX_LENGTH))
                .validate(LearnerSaveRequest::getEmail, email -> email.length() > 255, () -> new BusinessException(LearnerCode.LEARNER_EMAIL_MAX_LENGTH))
                .validate(LearnerSaveRequest::getPassword, password -> password.length() > 255, () -> new BusinessException(LearnerCode.LEARNER_PASSWORD_MAX_LENGTH))
                .get();
    }

    public void validateLearnerActiveRequest(LearnerActiveRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(LearnerCode.LEARNER_ACTIVE_NULL))
                .requireNonBlank(LearnerActiveRequest::getActiveCode, () -> new BusinessException(LearnerCode.LEARNER_ACTIVE_CODE_BLANK))
                .get();
    }

    public void validateLearnerAuthRequest(LearnerAuthRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(LearnerCode.LEARNER_AUTH_NULL))
                .requireNonBlank(LearnerAuthRequest::getAccount, () -> new BusinessException(LearnerCode.LEARNER_ACCOUNT_BLANK))
                .requireNonBlank(LearnerAuthRequest::getPassword, () -> new BusinessException(LearnerCode.LEARNER_PASSWORD_BLANK))
                .get();
    }

    public void validateMappingRequest(LearnerMappingRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(LearnerCode.LEARNER_MAPPING_NULL))
                .requireNonDefaultLong(LearnerMappingRequest::getId, () -> new BusinessException(LearnerCode.LEARNER_ID_BLANK))
                .requireNonBlank(LearnerMappingRequest::getAdultAccountEmail, () -> new BusinessException(LearnerCode.LEARNER_ADULT_MAIL_BLANK));
    }

    public void validateConfirmMappingRequest(LearnerConfirmMappingRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(LearnerCode.LEARNER_CONFIRM_MAPPING_NULL))
                .requireNonDefaultLong(LearnerConfirmMappingRequest::getId, () -> new BusinessException(LearnerCode.LEARNER_ID_BLANK))
                .requireNonBlank(LearnerConfirmMappingRequest::getAdultAccountEmail, () -> new BusinessException(LearnerCode.LEARNER_ADULT_MAIL_BLANK))
                .requireNonBlank(LearnerConfirmMappingRequest::getMappingCode, () -> new BusinessException(LearnerCode.LEARNER_MAPPING_CODE_BLANK));
    }

    public void validateLearnerGetListRequest(LearnerGetListRequest request) {
        Validator.of(request)
                .requireNonNull(() -> new BusinessException(LearnerCode.LEARNER_GET_LIST_NULL))
                .requireNonDefaultLong(LearnerGetListRequest::getPage, () -> new BusinessException(LearnerCode.LEARNER_GET_LIST_PAGE_BLANK))
                .requireNonDefaultLong(LearnerGetListRequest::getSize, () -> new BusinessException(LearnerCode.LEARNER_GET_LIST_SIZE_BLANK));
    }
}
