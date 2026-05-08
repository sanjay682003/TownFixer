package com.townfixer.features.login;

import com.townfixer.data.dto.User;
import com.townfixer.data.repository.TownFixerDB;

public class LoginModel {

    private LoginView view;

    public LoginModel(LoginView view) {
        this.view = view;
    }

    public void login(String email, String password) {

        User user = TownFixerDB.getInstance().validateUser(email, password);

        if (user != null) {
            view.loginSuccess(user);
        } else {
            view.loginFailed();
        }
    }
}