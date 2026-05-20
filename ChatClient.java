package client;

import shared.Constants;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        try {

            Socket socket =
                    new Socket(Constants.SERVER_ADDRESS,
                            Constants.PORT);

            System.out.println("Connected to Chat Server!");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter writer =
                    new PrintWriter(
                            socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            // Thread for receiving messages
            Thread receiveThread = new Thread(() -> {

                try {

                    String msg;

                    while ((msg = reader.readLine()) != null) {

                        System.out.println(msg);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            receiveThread.start();

            // Send messages
            while (true) {

                String message = sc.nextLine();

                writer.println(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}