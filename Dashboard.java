package ui;

import export.ExportService;
import service.WifiService;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    JTextArea outputArea;

    public Dashboard() {

        setTitle(
                "WiFi Password Saver");

        setSize(700, 500);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JButton showBtn =
                new JButton(
                        "Show Saved WiFi");

        JButton exportBtn =
                new JButton(
                        "Export List");

        JPanel topPanel =
                new JPanel();

        topPanel.add(showBtn);

        topPanel.add(exportBtn);

        outputArea =
                new JTextArea();

        outputArea.setFont(
                new Font("Arial",
                        Font.PLAIN,
                        14));

        outputArea.setEditable(false);

        JScrollPane scroll =
                new JScrollPane(outputArea);

        add(topPanel,
                BorderLayout.NORTH);

        add(scroll,
                BorderLayout.CENTER);

        showBtn.addActionListener(e -> {

            String data =
                    WifiService
                            .getWifiProfiles();

            outputArea.setText(data);
        });

        exportBtn.addActionListener(e -> {

            ExportService.exportData(
                    outputArea.getText());

            JOptionPane.showMessageDialog(
                    null,
                    "Exported Successfully!");
        });

        setVisible(true);
    }
}