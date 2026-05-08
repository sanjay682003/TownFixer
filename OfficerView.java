package com.townfixer.features.officer;

import com.townfixer.data.dto.Complaint;
import com.townfixer.data.dto.User;
import com.townfixer.data.repository.TownFixerDB;
import com.townfixer.utils.ConsoleInput;

import java.util.Scanner;

public class OfficerView {

    private User user;

    public OfficerView(User user) {
        this.user = user;
    }

    public void init() {

        Scanner sc = ConsoleInput.getScanner();

        while (true) {

            System.out.println("\n===== OFFICER MENU =====");
            System.out.println("1. View Complaints");
            System.out.println("2. Update Complaint Status");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    for (Complaint complaint : TownFixerDB.getInstance().getComplaints()) {
                        System.out.println(complaint);
                    }
                    break;

                case 2:

                    System.out.print("Complaint ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Status : ");
                    String status = sc.nextLine();

                    Complaint complaint = TownFixerDB.getInstance().getComplaintById(id);

                    if (complaint != null) {
                        complaint.setStatus(status);
                        System.out.println("Complaint Updated");
                    } else {
                        System.out.println("Complaint Not Found");
                    }
                    break;

                case 3:
                    return;
            }
        }
    }
}