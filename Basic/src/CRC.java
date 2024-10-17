import java.util.*;
public class CRC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the original message (binary): ");
        String message = sc.next();
        System.out.print("Enter the generator polynomial (binary): ");
        String generator = sc.next();

        String encodedMessage = generateCRCMessage(message, generator);
        System.out.println("Encoded Message: " + encodedMessage);

        System.out.print("Enter the received message (Message + CRC): ");
        String receivedMessage = sc.next();
        System.out.println(checkCRC(receivedMessage, generator) ? "No error detected." : "Error detected.");

        sc.close();
    }

    public static String generateCRCMessage(String message, String generator) {
        String paddedMessage = message + "0".repeat(generator.length() - 1);
        return message + getRemainder(paddedMessage, generator);
    }

    public static boolean checkCRC(String receivedMessage, String generator) {
        return getRemainder(receivedMessage, generator).equals("0".repeat(generator.length() - 1));
    }

    public static String getRemainder(String data, String generator) {
        StringBuilder remainder = new StringBuilder(data.substring(0, generator.length()));
        for (int i = generator.length(); i <= data.length(); i++) {
            if (remainder.charAt(0) == '1') {
                remainder = new StringBuilder(xor(remainder.toString(), generator));
            }
            if (i < data.length()) {
                remainder.append(data.charAt(i));
            }
            remainder.deleteCharAt(0);
        }
        return remainder.toString();
    }

    public static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }
}
