package server;

import shared.Constants;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {

    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket =
                    new ServerSocket(Constants.PORT);

            System.out.println("Server Started...");
            System.out.println("Waiting for clients...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("New Client Connected!");

                ClientHandler client =
                        new ClientHandler(socket);

                clients.add(client);

                Thread thread = new Thread(client);

                thread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}