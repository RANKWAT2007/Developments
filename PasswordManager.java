package manager;

import model.Credential;
import security.AESUtil;
import storage.FileHandler;

import java.io.BufferedReader;
import java.io.FileReader;

public class PasswordManager {

    // Add Password
    public void addCredential(Credential credential) {

        try {

            String encryptedPassword =
                    AESUtil.encrypt(
                            credential.getPassword());

            String data =
                    credential.getWebsite() + "," +
                    credential.getUsername() + "," +
                    encryptedPassword;

            FileHandler.saveCredential(data);

            System.out.println("Credential Saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Passwords
    public void viewCredentials() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "data/passwords.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                String decryptedPassword =
                        AESUtil.decrypt(parts[2]);

                System.out.println(
                        "\nWebsite: " + parts[0] +
                        "\nUsername: " + parts[1] +
                        "\nPassword: " + decryptedPassword
                );
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Website
    public void searchCredential(String website) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "data/passwords.txt"));

            String line;

            boolean found = false;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts[0].equalsIgnoreCase(website)) {

                    String decryptedPassword =
                            AESUtil.decrypt(parts[2]);

                    System.out.println(
                            "\nWebsite: " + parts[0] +
                            "\nUsername: " + parts[1] +
                            "\nPassword: " + decryptedPassword
                    );

                    found = true;
                }
            }

            if (!found) {
                System.out.println("No record found!");
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}