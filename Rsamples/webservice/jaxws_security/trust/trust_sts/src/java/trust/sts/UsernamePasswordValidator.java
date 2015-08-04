package trust.sts;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback;

public class UsernamePasswordValidator implements PasswordValidationCallback.PasswordValidator {

    public boolean validate(PasswordValidationCallback.Request request)
            throws PasswordValidationCallback.PasswordValidationException {
        PasswordValidationCallback.PlainTextPasswordRequest plainTextRequest = (PasswordValidationCallback.PlainTextPasswordRequest) request;
        return validateUserFromDB(plainTextRequest.getUsername(), plainTextRequest.getPassword());
    }

    private boolean validateUserFromDB(String username, String password) {
        if (username.equals("alice") && password.equals("alice")) {
            System.out.println("user " + username + " is a validate user.");
            return true;
        }
        System.out.println("user " + username + " is \"NOT\" a validate user.");
        return false;
    }
}
