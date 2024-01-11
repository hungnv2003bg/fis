package edu.platform.application.exceptions;

import org.springframework.http.HttpStatus;

public class StaffCode {

    public static final ResponseStatus STAFF_AUTH_NULL =
            new ResponseStatus("STAFF_AUTH_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_LOGIN_REJECT =
            new ResponseStatus("STAFF_LOGIN_REJECT", "Account or password invalid", HttpStatus.UNAUTHORIZED);
    public static final ResponseStatus STAFF_ACCOUNT_BLANK =
            new ResponseStatus("STAFF_ACCOUNT_BLANK", "Account is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_PASSWORD_BLANK =
            new ResponseStatus("STAFF_PASSWORD_BLANK", "Password is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_EMAIL_EXIST =
            new ResponseStatus("STAFF_EMAIL_EXIST", "Email is exist", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_ACCOUNT_EXIST =
            new ResponseStatus("STAFF_ACCOUNT_EXIST", "Account is exist", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_NOT_FOUND =
            new ResponseStatus("STAFF_NOT_FOUND", "Staff not found", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_CURRENT_PASSWORD_NOT_MATCH =
            new ResponseStatus("STAFF_CURRENT_PASSWORD_NOT_MATCH", "Current password not match", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_GET_LIST_NULL =
            new ResponseStatus("STAFF_GET_LIST_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_GET_LIST_PAGE_BLANK =
            new ResponseStatus("STAFF_GET_LIST_PAGE_BLANK", "Page is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_GET_LIST_SIZE_BLANK =
            new ResponseStatus("STAFF_GET_LIST_Size_BLANK", "Size is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_SAVE_NULL =
            new ResponseStatus("STAFF_SAVE_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_EMAIL_BLANK =
            new ResponseStatus("STAFF_EMAIL_BLANK", "Email is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_FULL_NAME_BLANK =
            new ResponseStatus("STAFF_FULL_NAME_BLANK", "Full name is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_ROLES_BLANK =
            new ResponseStatus("STAFF_ROLES_BLANK", "Roles is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_ACCOUNT_MAX_LENGTH =
            new ResponseStatus("STAFF_ACCOUNT_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_PASSWORD_MAX_LENGTH =
            new ResponseStatus("STAFF_PASSWORD_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_EMAIL_MAX_LENGTH =
            new ResponseStatus("STAFF_EMAIL_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_FULL_NAME_MAX_LENGTH =
            new ResponseStatus("STAFF_FULL_NAME_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_ROLES_MAX_LENGTH =
            new ResponseStatus("STAFF_ROLES_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_CHANGE_PASSWORD_NULL =
            new ResponseStatus("STAFF_CHANGE_PASSWORD_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_CURRENT_PASSWORD_BLANK =
            new ResponseStatus("STAFF_CURRENT_PASSWORD_BLANK", "Current password is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_CURRENT_PASSWORD_MAX_LENGTH =
            new ResponseStatus("STAFF_CURRENT_PASSWORD_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_NEW_PASSWORD_BLANK =
            new ResponseStatus("STAFF_NEW_PASSWORD_BLANK", "Current password is blank", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_NEW_PASSWORD_MAX_LENGTH =
            new ResponseStatus("STAFF_NEW_PASSWORD_MAX_LENGTH", "Max length is 255", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_RESET_PASSWORD_NULL =
            new ResponseStatus("STAFF_RESET_PASSWORD_NULL", "Object is null", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_LOCKED =
            new ResponseStatus("STAFF_LOCKED", "Staff locked", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_NOT_RESET_PASSWORD_YOUR_SELF =
            new ResponseStatus("STAFF_NOT_RESET_PASSWORD_YOUR_SELF", "Can not reset password your self", HttpStatus.BAD_REQUEST);
    public static final ResponseStatus STAFF_NOT_LOCK_UNLOCK_YOUR_SELF =
            new ResponseStatus("STAFF_NOT_LOCK_UNLOCK_YOUR_SELF", "Can not lock/unlock your self", HttpStatus.BAD_REQUEST);

    private StaffCode() {

    }
}
