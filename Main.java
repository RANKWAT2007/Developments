import model.Expense;
import service.ExpenseService;
import utils.FileExporter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseService service = new ExpenseService();

        FileExporter exporter = new FileExporter();

        while (true) {

            System.out.println("\n===== Expense Tracker =====");

            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Monthly Report");
            System.out.println("4. Export CSV");
            System.out.println("5. Exit");

            System.out.print("Choose Option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Type (Income/Expense): ");
                    String type = sc.nextLine();

                    Expense expense =
                            new Expense(title, amount, category, type);

                    service.addExpense(expense);

                    break;

                case 2:
                    service.viewExpenses();
                    break;

                case 3:
                    service.monthlyReport();
                    break;

                case 4:
                    exporter.exportToCSV();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}