package com.tmax;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

import java.io.*;

public class UsernamePasswordCallbackHandler implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            Callback callback = callbacks[i];
            if (callback instanceof NameCallback) {
                ((NameCallback) callback).setName("user_jeus");
            } else if (callback instanceof PasswordCallback) {
                ((PasswordCallback) callback).setPassword((new String("password_jeus")).toCharArray());
            } else {
                throw new UnsupportedCallbackException(callback, "Unknow callback for username or password");
            }
        }
    }
}