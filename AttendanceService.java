package service;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AttendanceService {

    public static void markAttendance(
            String name,
            String rollNo) {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO attendance " +
                    "(student_name, roll_number) " +
                    "VALUES (?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setString(1, name);

            ps.setString(2, rollNo);

            ps.executeUpdate();

            System.out.println(
                    "Attendance Marked!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}