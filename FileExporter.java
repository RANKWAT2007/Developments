package utils;

import db.DBConnection;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileExporter {

    public void exportToCSV() {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM expenses";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            FileWriter writer = new FileWriter("expenses.csv");

            writer.append("ID,Title,Amount,Category,Type\n");

            while (rs.next()) {

                writer.append(
                        rs.getInt("id") + "," +
                        rs.getString("title") + "," +
                        rs.getDouble("amount") + "," +
                        rs.getString("category") + "," +
                        rs.getString("type") + "\n"
                );
            }

            writer.flush();
            writer.close();

            System.out.println("CSV Exported Successfully!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}