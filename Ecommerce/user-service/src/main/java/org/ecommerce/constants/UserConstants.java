package org.ecommerce.constants;

public class UserConstants {

    private UserConstants() {} // prevent instantiation

    // API paths
    public static final String BASE_PATH = "/api/users";
    public static final String GET_USER_BY_ID = "/{id}";

    // Error messages
    public static final String USER_NOT_FOUND = "User not found with id: %s";
    public static final String EMAIL_ALREADY_EXISTS = "Email already exists: %s";

}