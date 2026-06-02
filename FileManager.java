package file;

import java.io.*;
import javax.swing.*;

public class FileManager {

    public static void saveFile(
            JFrame frame,
            String content) {

        JFileChooser chooser =
                new JFileChooser();

        int option =
                chooser.showSaveDialog(frame);

        if (option ==
                JFileChooser.APPROVE_OPTION) {

            File file =
                    chooser.getSelectedFile();

            try {

                FileWriter writer =
                        new FileWriter(file);

                writer.write(content);

                writer.close();

                JOptionPane.showMessageDialog(
                        frame,
                        "File Saved!");

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        frame,
                        e.getMessage());
            }
        }
    }

    public static String openFile(JFrame frame) {

        JFileChooser chooser =
                new JFileChooser();

        int option =
                chooser.showOpenDialog(frame);

        if (option ==
                JFileChooser.APPROVE_OPTION) {

            File file =
                    chooser.getSelectedFile();

            try {

                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(file));

                StringBuilder content =
                        new StringBuilder();

                String line;

                while ((line = reader.readLine())
                        != null) {

                    content.append(line)
                            .append("\n");
                }

                reader.close();

                return content.toString();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        frame,
                        e.getMessage());
            }
        }

        return null;
    }
}