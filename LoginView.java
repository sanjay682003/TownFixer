package com.townfixer.features.login;

import com.townfixer.data.dto.User;
import com.townfixer.features.menu.MenuView;
import com.townfixer.features.register.RegisterView;
import com.townfixer.utils.ConsoleInput;

import java.util.Scanner;

public class LoginView {

    private LoginModel model;

    public LoginView() {
        model = new LoginModel(this);
    }

    public void init() {

        Scanner sc = ConsoleInput.getScanner();

        while (true) {

            System.out.println("\n1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Email : ");
                    String email = sc.nextLine();

                    System.out.print("Password : ");
                    String password = sc.nextLine();

                    model.login(email, password);
                    break;

                case 2:
                    new RegisterView().init();
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }

    public void loginSuccess(User user) {
        System.out.println("Login Success");
        new MenuView(user).init();
    }

    public void loginFailed() {
        System.out.println("Invalid Credentials");
    }
}