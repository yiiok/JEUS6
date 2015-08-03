package com.tmax;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback;

public class UsernamePasswordValidator implements PasswordValidationCallback.PasswordValidator {

    public boolean validate(PasswordValidationCallback.Request request)
            throws PasswordValidationCallback.PasswordValidationException {
        PasswordValidationCallback.PlainTextPasswordRequest plainTextRequest = (PasswordValidationCallback.PlainTextPasswordRequest) request;
        return validateUserFromDB(plainTextRequest.getUsername(), plainTextRequest.getPassword());
    }

    private boolean validateUserFromDB(String username, String password) {
        if (username.equals("user_jeus") && password.equals("password_jeus")) {
            System.out.println("user " + username + " is a validate user.");
            return true;
        } else if (username.equals("user_jeus1") && password.equals("password_jeus2")) {
            return true;
        }
        System.out.println("user " + username + " is \"NOT\" a validate user.");
        return false;
    }
}