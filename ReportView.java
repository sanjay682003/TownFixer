package com.townfixer.features.report;

import com.townfixer.data.dto.Complaint;
import com.townfixer.data.repository.TownFixerDB;

public class ReportView {

    public void showReport() {

        int total = TownFixerDB.getInstance().getComplaints().size();
        int resolved = 0;
        int pending = 0;

        for (Complaint complaint : TownFixerDB.getInstance().getComplaints()) {

            if (complaint.getStatus().equalsIgnoreCase("RESOLVED")) {
                resolved++;
            } else {
                pending++;
            }
        }

        System.out.println("\n===== REPORT =====");
        System.out.println("Total Complaints : " + total);
        System.out.println("Resolved Complaints : " + resolved);
        System.out.println("Pending Complaints : " + pending);
    }
}