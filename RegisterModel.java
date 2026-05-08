package com.townfixer.features.register;

import com.townfixer.data.repository.TownFixerDB;

public class RegisterModel {

    private RegisterView view;

    public RegisterModel(RegisterView view) {
        this.view = view;
    }

    public void register(String name, String email, String password) {

        TownFixerDB.getInstance().addUser(name, email, password);
        view.registerSuccess();
    }
}