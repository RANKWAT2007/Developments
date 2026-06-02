package storage;

import java.io.*;

public class FileHandler {

    private static final String FILE_PATH =
            "data/passwords.txt";

    // Save Credential
    public static void saveCredential(String data) {

        try {

            FileWriter writer =
                    new FileWriter(FILE_PATH, true);

            writer.write(data + "\n");

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read All Credentials
    public static void readCredentials() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_PATH));

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}