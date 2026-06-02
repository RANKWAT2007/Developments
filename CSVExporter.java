package utils;

import java.io.FileWriter;

public class CSVExporter {

    public static void exportCSV() {

        try {

            FileWriter writer =
                    new FileWriter(
                            "attendance_report.csv");

            writer.write(
                    "Name,Roll Number\n");

            writer.write(
                    "Komal,101\n");

            writer.write(
                    "Dishu,102\n");

            writer.close();

            System.out.println(
                    "CSV Exported!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}