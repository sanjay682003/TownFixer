package com.townfixer.features.register;

import com.townfixer.utils.ConsoleInput;

import java.util.Scanner;

public class RegisterView {

    private RegisterModel model;

    public RegisterView() {
        model = new RegisterModel(this);
    }

    public void init() {

        Scanner sc = ConsoleInput.getScanner();

        System.out.print("Name : ");
        String name = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        model.register(name, email, password);
    }

    public void registerSuccess() {
        System.out.println("Citizen Registered Successfully");
    }
}