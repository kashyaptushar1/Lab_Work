

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
