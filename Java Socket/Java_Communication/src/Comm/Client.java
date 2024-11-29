package Comm;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Client {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private JButton sendButton;

    private PrintWriter output;
    private BufferedReader input;
    private Socket socket;
    private volatile boolean running = true;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Client::new);
    }

    public Client() {
        setupGUI();
        startClient();
    }

    private void setupGUI() {
        frame = new JFrame("Client Chat");
        textArea = new JTextArea();
        textField = new JTextField();
        sendButton = new JButton("Send");

        textArea.setEditable(false);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        sendButton.addActionListener(e -> sendMessage());
        textField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String message = textField.getText();
        if (message.isEmpty()) return;

        textArea.append("You: " + message + "\n");
        textField.setText("");

        if (output != null) {
            output.println(message);
        }
    }

    private void startClient() {
        try {
            socket = new Socket("localhost", 1234);
            textArea.append("Connected to the server.\n");

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            new Thread(this::receiveMessages).start();
        } catch (IOException ex) {
            textArea.append("Unable to connect to the server.\n");
            ex.printStackTrace();
        }
    }

    private void receiveMessages() {
        try {
            String message;
            while (running && (message = input.readLine()) != null) {
                textArea.append("Server: " + message + "\n");
            }
        } catch (IOException ex) {
            if (running) textArea.append("Connection lost.\n");
        } finally {
            stopClient();
        }
    }

    private void stopClient() {
        running = false;
        try {
            if (socket != null) socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
