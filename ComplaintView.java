package com.townfixer.features.complaint;

import com.townfixer.data.dto.Complaint;
import com.townfixer.data.dto.User;
import com.townfixer.data.repository.TownFixerDB;
import com.townfixer.utils.ConsoleInput;

import java.util.Scanner;

public class ComplaintView {

    private User user;

    public ComplaintView(User user) {
        this.user = user;
    }

    public void createComplaint() {

        Scanner sc = ConsoleInput.getScanner();

        System.out.print("Complaint Title : ");
        String title = sc.nextLine();

        System.out.print("Description : ");
        String description = sc.nextLine();

        TownFixerDB.getInstance()
                .addComplaint(title, description, user.getName());

        System.out.println("Complaint Submitted Successfully");
    }

    public void viewComplaints() {

        for (Complaint complaint : TownFixerDB.getInstance().getComplaints()) {
            System.out.println(complaint);
        }
    }
}