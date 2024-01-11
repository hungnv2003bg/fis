package edu.platform.application.constant;

public interface RoleConstant {
    String ROLE_STAFF = "hasAuthority('STAFF')";
    String ROLE_CUSTOMER_SUPPORT = "hasAuthority('CUSTOMER_SUPPORT')";
    String ROLE_ACCOUNTING = "hasAuthority('ACCOUNTING')";
    String ROLE_ADMIN = "hasAuthority('ADMIN')";

    String OR = " or ";
}
