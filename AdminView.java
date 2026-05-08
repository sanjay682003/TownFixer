package com.townfixer.features.admin;

import com.townfixer.data.dto.Complaint;
import com.townfixer.data.dto.User;
import com.townfixer.data.repository.TownFixerDB;
import com.townfixer.features.report.ReportView;
import com.townfixer.utils.ConsoleInput;

import java.util.Scanner;

public class AdminView {

    private User user;

    public AdminView(User user) {
        this.user = user;
    }

    public void init() {

        Scanner sc = ConsoleInput.getScanner();

        while (true) {

            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add Officer");
            System.out.println("2. View Complaints");
            System.out.println("3. Assign Complaint");
            System.out.println("4. Reports");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Officer Name : ");
                    String name = sc.nextLine();

                    System.out.print("Officer Email : ");
                    String email = sc.nextLine();

                    System.out.print("Officer Password : ");
                    String password = sc.nextLine();

                    TownFixerDB.getInstance().addOfficer(name, email, password);

                    System.out.println("Officer Added Successfully");
                    break;

                case 2:

                    for (Complaint complaint : TownFixerDB.getInstance().getComplaints()) {
                        System.out.println(complaint);
                    }
                    break;

                case 3:

                    System.out.print("Complaint ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Assign Officer Name : ");
                    String officer = sc.nextLine();

                    Complaint complaint = TownFixerDB.getInstance().getComplaintById(id);

                    if (complaint != null) {
                        complaint.setAssignedOfficer(officer);
                        complaint.setStatus("ASSIGNED");
                        System.out.println("Complaint Assigned");
                    } else {
                        System.out.println("Complaint Not Found");
                    }
                    break;

                case 4:
                    new ReportView().showReport();
                    break;

                case 5:
                    return;
            }
        }
    }
}