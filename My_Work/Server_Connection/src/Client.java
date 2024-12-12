

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("Connected to the server.");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
