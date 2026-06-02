package export;

import java.io.FileWriter;

public class ExportService {

    public static void exportData(
            String data) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "wifi_profiles.txt");

            writer.write(data);

            writer.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}