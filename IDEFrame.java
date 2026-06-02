package ui;

import compiler.JavaCompilerService;
import file.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class IDEFrame extends JFrame {

    private JTextArea codeArea;
    private JTextArea outputArea;

    public IDEFrame() {

        setTitle("Java Mini IDE");

        setSize(1000, 700);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Code Area
        codeArea = new JTextArea();

        codeArea.setFont(
                new Font("Consolas",
                        Font.PLAIN,
                        18));

        JScrollPane codeScroll =
                new JScrollPane(codeArea);

        // Output Area
        outputArea = new JTextArea();

        outputArea.setEditable(false);

        outputArea.setFont(
                new Font("Consolas",
                        Font.PLAIN,
                        16));

        JScrollPane outputScroll =
                new JScrollPane(outputArea);

        JSplitPane splitPane =
                new JSplitPane(
                        JSplitPane.VERTICAL_SPLIT,
                        codeScroll,
                        outputScroll);

        splitPane.setDividerLocation(450);

        add(splitPane, BorderLayout.CENTER);

        // Buttons
        JPanel topPanel = new JPanel();

        JButton openBtn =
                new JButton("Open");

        JButton saveBtn =
                new JButton("Save");

        JButton compileBtn =
                new JButton("Compile");

        JButton runBtn =
                new JButton("Run");

        topPanel.add(openBtn);
        topPanel.add(saveBtn);
        topPanel.add(compileBtn);
        topPanel.add(runBtn);

        add(topPanel, BorderLayout.NORTH);

        // Button Actions

        openBtn.addActionListener((ActionEvent e) -> {

            String content =
                    FileManager.openFile(this);

            if (content != null) {

                codeArea.setText(content);
            }
        });

        saveBtn.addActionListener((ActionEvent e) -> {

            FileManager.saveFile(
                    this,
                    codeArea.getText());
        });

        compileBtn.addActionListener((ActionEvent e) -> {

            String result =
                    JavaCompilerService.compile(
                            codeArea.getText());

            outputArea.setText(result);
        });

        runBtn.addActionListener((ActionEvent e) -> {

            String result =
                    JavaCompilerService.run();

            outputArea.setText(result);
        });

        setVisible(true);
    }
}