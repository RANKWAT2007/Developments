package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WifiService {

    public static String getWifiProfiles() {

        StringBuilder result =
                new StringBuilder();

        try {

            ProcessBuilder builder =
                    new ProcessBuilder(
                            "cmd.exe",
                            "/c",
                            "netsh wlan show profiles");

            Process process =
                    builder.start();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()));

            String line;

            while ((line =
                    reader.readLine()) != null) {

                result.append(line)
                        .append("\n");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result.toString();
    }
}