package edu.platform.security.jwt.util;

public enum JwtClaimKey {
    ID("id"),
    EMAIL("email"),
    PHONE_NUMBER("phoneNumber"),
    ACCOUNT("account"),
    ROLE("role");

    private String value;

    private JwtClaimKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
