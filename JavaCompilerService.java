package compiler;

import java.io.*;

public class JavaCompilerService {

    private static final String FILE_NAME =
            "projects/TestProgram.java";

    public static String compile(String code) {

        try {

            // Create projects folder
            File folder =
                    new File("projects");

            if (!folder.exists()) {

                folder.mkdir();
            }

            // Save code to file
            FileWriter writer =
                    new FileWriter(FILE_NAME);

            writer.write(code);

            writer.close();

            // Compile
            ProcessBuilder pb =
                    new ProcessBuilder(
                            "javac",
                            FILE_NAME);

            Process process =
                    pb.start();

            BufferedReader error =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getErrorStream()));

            StringBuilder output =
                    new StringBuilder();

            String line;

            while ((line = error.readLine()) != null) {

                output.append(line)
                        .append("\n");
            }

            process.waitFor();

            if (output.length() == 0) {

                return "Compilation Successful!";
            }

            return output.toString();

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    public static String run() {

        try {

            ProcessBuilder pb =
                    new ProcessBuilder(
                            "java",
                            "-cp",
                            "projects",
                            "TestProgram");

            Process process =
                    pb.start();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()));

            BufferedReader error =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getErrorStream()));

            StringBuilder output =
                    new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {

                output.append(line)
                        .append("\n");
            }

            while ((line = error.readLine()) != null) {

                output.append(line)
                        .append("\n");
            }

            process.waitFor();

            return output.toString();

        } catch (Exception e) {

            return e.getMessage();
        }
    }
}