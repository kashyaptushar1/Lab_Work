package TCP;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("Connected to the server.");

            // Input and Output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Communication loop
            String message;
            while (true) {
                System.out.print("You: ");
                message = userInput.readLine();
                output.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Connection closed.");
                    break;
                }

                System.out.println(input.readLine()); // Read server's response
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

