package edu.platform.application.exceptions;

import org.springframework.http.HttpStatus;

public class InstructorCode {
    public static final ResponseStatus INSTRUCTOR_LOGIN_REJECT =
            new ResponseStatus("INSTRUCTOR_LOGIN_REJECT", "Account or password invalid", HttpStatus.UNAUTHORIZED);
    public static final ResponseStatus INSTRUCTOR_NOT_OWN =
            new ResponseStatus("INSTRUCTOR_NOT_OWN", "Not your own", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_NOT_FOUND =
            new ResponseStatus("INSTRUCTOR_NOT_FOUND", "Not found instructor", HttpStatus.NOT_FOUND);
    public static final ResponseStatus INSTRUCTOR_WRONG_CURRENT_PASSWORD =
            new ResponseStatus("INSTRUCTOR_WRONG_CURRENT_PASSWORD", "Wrong current password", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_WRONG_ACTIVE_CODE =
            new ResponseStatus("INSTRUCTOR_WRONG_ACTIVE_CODE", "Wrong active code", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_SAVE_NULL =
            new ResponseStatus("INSTRUCTOR_SAVE_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_FAMILY_NAME_BLANK =
            new ResponseStatus("INSTRUCTOR_FAMILY_NAME_BLANK", "Family name is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_FIRST_NAME_BLANK =
            new ResponseStatus("INSTRUCTOR_FIRST_NAME_BLANK", "First name is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_EMAIL_BLANK =
            new ResponseStatus("INSTRUCTOR_EMAIL_BLANK", "Email is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_ADDRESS_BLANK =
            new ResponseStatus("INSTRUCTOR_ADDRESS_BLANK", "Address is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_ACCOUNT_BLANK =
            new ResponseStatus("INSTRUCTOR_ACCOUNT_BLANK", "Account is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_PASSWORD_BLANK =
            new ResponseStatus("INSTRUCTOR_PASSWORD_BLANK", "Password is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_YEAR_OF_BIRTH_BLANK =
            new ResponseStatus("INSTRUCTOR_YEAR_OF_BIRTH_BLANK", "Year of birth is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_PROVINCE_BLANK =
            new ResponseStatus("INSTRUCTOR_PROVINCE_BLANK", "Province is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_DISTRICT_BLANK =
            new ResponseStatus("INSTRUCTOR_DISTRICT_BLANK", "District is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_WARD_BLANK =
            new ResponseStatus("INSTRUCTOR_WARD_BLANK", "Ward is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_AUTH_NULL =
            new ResponseStatus("INSTRUCTOR_AUTH_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_UPDATE_NULL =
            new ResponseStatus("INSTRUCTOR_UPDATE_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_CHANGE_PASSWORD_NULL =
            new ResponseStatus("INSTRUCTOR_CHANGE_PASSWORD_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_CURRENT_PASSWORD_BLANK =
            new ResponseStatus("INSTRUCTOR_CURRENT_PASSWORD_BLANK", "Current password is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_NEW_PASSWORD_BLANK =
            new ResponseStatus("INSTRUCTOR_NEW_PASSWORD_BLANK", "New password is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_ACTIVE_NULL =
            new ResponseStatus("INSTRUCTOR_ACTIVE_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_ACTIVE_CODE_BLANK =
            new ResponseStatus("INSTRUCTOR_ACTIVE_CODE_BLANK", "Active code is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_EMAIL_EXIST =
            new ResponseStatus("INSTRUCTOR_EMAIL_EXIST", "Email is exist", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_FAMILY_NAME_MAX_LENGTH =
            new ResponseStatus("INSTRUCTOR_FAMILY_NAME_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_FIRST_NAME_MAX_LENGTH =
            new ResponseStatus("INSTRUCTOR_FIRST_NAME_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_EMAIL_MAX_LENGTH =
            new ResponseStatus("INSTRUCTOR_EMAIL_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_ADDRESS_MAX_LENGTH =
            new ResponseStatus("INSTRUCTOR_ADDRESS_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_PASSWORD_MAX_LENGTH =
            new ResponseStatus("INSTRUCTOR_PASSWORD_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_NEW_PASSWORD_MAX_LENGTH =
            new ResponseStatus("INSTRUCTOR_NEW_PASSWORD_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_ALREADY_ACTIVE =
            new ResponseStatus("INSTRUCTOR_ALREADY_ACTIVE", "Account is activated", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_GET_LIST_NULL =
            new ResponseStatus("INSTRUCTOR_GET_LIST_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_GET_LIST_PAGE_BLANK =
            new ResponseStatus("INSTRUCTOR_GET_LIST_PAGE_BLANK", "Page is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus INSTRUCTOR_GET_LIST_SIZE_BLANK =
            new ResponseStatus("INSTRUCTOR_GET_LIST_SIZE_BLANK", "Size is blank", HttpStatus.BAD_REQUEST);

    private InstructorCode() {

    }
}
