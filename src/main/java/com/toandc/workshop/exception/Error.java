package com.toandc.workshop.exception;

/**
 * Created by toanqri on 4/1/17.
 */
public class Error {

    public static final String USER_NOT_FOUND = "User not found";

    private String errorMessage;

    public Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
