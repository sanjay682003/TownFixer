package com.townfixer.features.menu;

import com.townfixer.data.dto.User;
import com.townfixer.features.admin.AdminView;
import com.townfixer.features.complaint.ComplaintView;
import com.townfixer.features.officer.OfficerView;
import com.townfixer.features.report.ReportView;
import com.townfixer.utils.ConsoleInput;

import java.util.Scanner;

public class MenuView {

    private User user;

    public MenuView(User user) {
        this.user = user;
    }

    public void init() {

        Scanner sc = ConsoleInput.getScanner();

        while (true) {

            if (user.getRole().equals("CITIZEN")) {

                System.out.println("\n===== CITIZEN MENU =====");
                System.out.println("1. Submit Complaint");
                System.out.println("2. View Complaints");
                System.out.println("3. Exit");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        new ComplaintView(user).createComplaint();
                        break;

                    case 2:
                        new ComplaintView(user).viewComplaints();
                        break;

                    case 3:
                        return;
                }

            } else if (user.getRole().equals("ADMIN")) {

                new AdminView(user).init();
                return;

            } else if (user.getRole().equals("OFFICER")) {

                new OfficerView(user).init();
                return;
            }
        }
    }
}