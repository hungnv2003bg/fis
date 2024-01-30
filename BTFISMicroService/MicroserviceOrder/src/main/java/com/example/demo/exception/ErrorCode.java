package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ErrorCode {
    public static ResponseStatus CATEGORY_NOT_FOUND = new ResponseStatus("CATEGORY_NOT_FOUND", "CATEGORY NOT FOUND!", HttpStatus.NOT_FOUND);
    public static ResponseStatus CATENAME_NOT_BLANK = new ResponseStatus("CATENAME_NOT_BLANK", "CATENAME NOT BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus CATENAME_EXIST = new ResponseStatus("CATENAME_EXIST", "CATENAME_EXIST!", HttpStatus.BAD_REQUEST);

    public static ResponseStatus NAMEPRODUCT_NOT_BLANK = new ResponseStatus("NAMEPRODUCT_NOT_BLANK", "NAMEPRODUCT NOT BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus PRICE_NOT_BLANK = new ResponseStatus("PRICE_NOT_BLANK", "PRICE NOT BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus INVALID_PRICE_INPUT = new ResponseStatus("INVALID_PRICE_INPUT", "INVALID PRICE INPUT!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus PRODUCT_NOT_FOUD = new ResponseStatus("PRODUCT_NOT_FOUD", "PRODUCT NOT FOUND!", HttpStatus.NOT_FOUND);
    public static ResponseStatus INVALID_STATUS = new ResponseStatus("INVALID_STATUS", "INVALID STATUS!", HttpStatus.INTERNAL_SERVER_ERROR);
    public static ResponseStatus QUANTITY_NOT_BLANK = new ResponseStatus("QUANTITY_NOT_BLANK", "QUANTITY NOT BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus CATEGORYID_NOT_BLANK = new ResponseStatus("CATEGORYID_NOT_BLANK", "CATEGORYID NOT BLANK!", HttpStatus.INTERNAL_SERVER_ERROR);

    public static ResponseStatus USER_NOT_FOUD = new ResponseStatus("USER_NOT_FOUD", "USER_NOT_FOUD!", HttpStatus.NOT_FOUND);
    public static ResponseStatus EMAIL_AND_PASS_NOT_BLANK = new ResponseStatus("EMAIL_AND_PASS_NOT_BLANK", "EMAIL_AND_PASS_NOT_BLANK!", HttpStatus.NOT_FOUND);
    public static ResponseStatus NAME_NOT_BLANK = new ResponseStatus("NAME_NOT_BLANK", "NAME_NOT_BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus PHONE_NOT_BLANK = new ResponseStatus("PHONE_NOT_BLANK", "PHONE_NOT_BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus GENDER_NOT_BLANK = new ResponseStatus("GENDER_NOT_BLANK", "GENDER_NOT_BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus EMAIL_EXIST = new ResponseStatus("EMAIL_EXIST", "EMAIL_EXIST!", HttpStatus.BAD_REQUEST);

    public static ResponseStatus INVALID_QUANTITY_INPUT = new ResponseStatus("INVALID_QUANTITY_INPUT", "INVALID_QUANTITY_INPUT!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus CART_NOT_FOUD = new ResponseStatus("CART_NOT_FOUD", "CART_NOT_FOUD!", HttpStatus.NOT_FOUND);

    public static ResponseStatus ADDRESS_NOT_FOUD = new ResponseStatus("ADDRESS_NOT_FOUD", "ADDRESS_NOT_FOUD!", HttpStatus.NOT_FOUND);
    public static ResponseStatus RECEIVER_NOT_BLANK = new ResponseStatus("RECEIVER_NOT_BLANK", "RECEIVER_NOT_BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus WARD_NOT_BLANK = new ResponseStatus("WARD_NOT_BLANK", "WARD_NOT_BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus DISTRICT_NOT_BLANK = new ResponseStatus("DISTRICT_NOT_BLANK", "DISTRICT_NOT_BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus PROVINCE_NOT_BLANK = new ResponseStatus("PROVINCE_NOT_BLANK", "PROVINCE_NOT_BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus DETAILADDRESS_NOT_BLANK = new ResponseStatus("PROVINCE_NOT_BLANK", "PROVINCE_NOT_BLANK!", HttpStatus.BAD_REQUEST);
    public static ResponseStatus MAINDRESS_NOT_BLANK = new ResponseStatus("PROVINCE_NOT_BLANK", "PROVINCE_NOT_BLANK!", HttpStatus.BAD_REQUEST);

    public static ResponseStatus SHIP_NOT_FOUD = new ResponseStatus("SHIP_NOT_FOUD", "SHIP_NOT_FOUD!", HttpStatus.NOT_FOUND);
    public static ResponseStatus PAY_NOT_FOUD = new ResponseStatus("PAY_NOT_FOUD", "PAY_NOT_FOUD!", HttpStatus.NOT_FOUND);
    public static ResponseStatus ORDER_NOT_FOUD = new ResponseStatus("ORDER_NOT_FOUD", "ORDER_NOT_FOUD!", HttpStatus.NOT_FOUND);

}