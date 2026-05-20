package service;

import db.DBConnection;
import model.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExpenseService {

    // Add Expense
    public void addExpense(Expense expense) {

        try {

            Connection conn = DBConnection.getConnection();

            String query =
                    "INSERT INTO expenses(title, amount, category, type) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, expense.getTitle());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setString(4, expense.getType());

            ps.executeUpdate();

            System.out.println("Expense Added Successfully!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Expenses
    public void viewExpenses() {

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM expenses";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== Expenses =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getDouble("amount") + " | " +
                        rs.getString("category") + " | " +
                        rs.getString("type")
                );
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Monthly Report
    public void monthlyReport() {

        try {

            Connection conn = DBConnection.getConnection();

            String query =
                    "SELECT type, SUM(amount) as total FROM expenses GROUP BY type";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== Monthly Report =====");

            while (rs.next()) {

                System.out.println(
                        rs.getString("type") +
                        " : ₹" +
                        rs.getDouble("total")
                );
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}