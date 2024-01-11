package edu.platform.application.exceptions;

import org.springframework.http.HttpStatus;

public class LearnerCode {

    public static final ResponseStatus LEARNER_EMAIL_EXIST =
            new ResponseStatus("LEARNER_EMAIL_EXIST", "Email is exist", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_LOGIN_REJECT =
            new ResponseStatus("LEARNER_LOGIN_REJECT", "Account or password invalid", HttpStatus.UNAUTHORIZED);
    public static final ResponseStatus LEARNER_NOT_FOUND =
            new ResponseStatus("LEARNER_NOT_FOUND", "Not found learner", HttpStatus.NOT_FOUND);
    public static final ResponseStatus LEARNER_WRONG_ACTIVE_CODE =
            new ResponseStatus("LEARNER_WRONG_ACTIVE_CODE", "Wrong active code", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_ALREADY_ACTIVE =
            new ResponseStatus("LEARNER_ALREADY_ACTIVE", "Account is activated", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_ACTIVE_NULL =
            new ResponseStatus("LEARNER_ACTIVE_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_ACTIVE_CODE_BLANK =
            new ResponseStatus("LEARNER_ACTIVE_CODE_BLANK", "Active code is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_AUTH_NULL =
            new ResponseStatus("LEARNER_AUTH_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_ACCOUNT_BLANK =
            new ResponseStatus("LEARNER_ACCOUNT_BLANK", "Account is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_PASSWORD_BLANK =
            new ResponseStatus("LEARNER_PASSWORD_BLANK", "Password is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_SAVE_NULL =
            new ResponseStatus("LEARNER_SAVE_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_FAMILY_NAME_BLANK =
            new ResponseStatus("LEARNER_FAMILY_NAME_BLANK", "Family name is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_FIRST_NAME_BLANK =
            new ResponseStatus("LEARNER_FIRST_NAME_BLANK", "First name is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_EMAIL_BLANK =
            new ResponseStatus("LEARNER_EMAIL_BLANK", "Email is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_YEAR_OF_BIRTH_BLANK =
            new ResponseStatus("LEARNER_YEAR_OF_BIRTH_BLANK", "Year of birth is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_PROVINCE_BLANK =
            new ResponseStatus("LEARNER_PROVINCE_BLANK", "Province is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_DISTRICT_BLANK =
            new ResponseStatus("LEARNER_DISTRICT_BLANK", "District is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_WARD_BLANK =
            new ResponseStatus("LEARNER_WARD_BLANK", "Ward is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_FAMILY_NAME_MAX_LENGTH =
            new ResponseStatus("LEARNER_FAMILY_NAME_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_FIRST_NAME_MAX_LENGTH =
            new ResponseStatus("LEARNER_FIRST_NAME_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_EMAIL_MAX_LENGTH =
            new ResponseStatus("LEARNER_EMAIL_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_PASSWORD_MAX_LENGTH =
            new ResponseStatus("LEARNER_PASSWORD_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_ADULT_NOT_FOUND =
            new ResponseStatus("LEARNER_ADULT_NOT_FOUND", "Not found learner", HttpStatus.NOT_FOUND);
    public static final ResponseStatus LEARNER_MAPPING_FOUND =
            new ResponseStatus("LEARNER_MAPPING_FOUND", "Not found learner mapping", HttpStatus.NOT_FOUND);
    public static final ResponseStatus LEARNER_ALREADY_MAPPED =
            new ResponseStatus("LEARNER_ALREADY_MAPPED", "Learner already mapped", HttpStatus.NOT_FOUND);
    public static final ResponseStatus LEARNER_MAPPING_CODE_WRONG =
            new ResponseStatus("LEARNER_MAPPING_CODE_WRONG", "Wrong mapping code", HttpStatus.NOT_FOUND);
    public static final ResponseStatus LEARNER_MAPPING_NULL =
            new ResponseStatus("LEARNER_MAPPING_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_CONFIRM_MAPPING_NULL =
            new ResponseStatus("LEARNER_CONFIRM_MAPPING_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_ID_BLANK =
            new ResponseStatus("LEARNER_ID_BLANK", "Id is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_ADULT_MAIL_BLANK =
            new ResponseStatus("LEARNER_ADULT_MAIL_BLANK", "Adult learner email is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_MAPPING_CODE_BLANK =
            new ResponseStatus("LEARNER_MAPPING_CODE_BLANK", "Mapping code is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_GET_LIST_NULL =
            new ResponseStatus("LEARNER_GET_LIST_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_GET_LIST_PAGE_BLANK =
            new ResponseStatus("LEARNER_GET_LIST_PAGE_BLANK", "Page is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus LEARNER_GET_LIST_SIZE_BLANK =
            new ResponseStatus("LEARNER_GET_LIST_SIZE_BLANK", "Size is blank", HttpStatus.BAD_REQUEST);

    private LearnerCode() {

    }
}
