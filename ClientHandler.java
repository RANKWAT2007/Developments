package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

    private BufferedReader reader;

    private PrintWriter writer;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {

            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(
                    socket.getOutputStream(), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String message;

        try {

            while ((message = reader.readLine()) != null) {

                System.out.println("Client: " + message);

                broadcastMessage(message);
            }

        } catch (Exception e) {

            System.out.println("Client Disconnected");

        }
    }

    // Send message to all clients
    private void broadcastMessage(String message) {

        for (ClientHandler client : ChatServer.clients) {

            client.writer.println(message);
        }
    }
}