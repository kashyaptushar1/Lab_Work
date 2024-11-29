package TCP;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Input and Output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Communication loop
            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Client: " + message);
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Connection closed by client.");
                    break;
                }
                output.println("Server: " + message); // Echo back the message
            }
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

