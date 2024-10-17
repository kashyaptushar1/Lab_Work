public class CheckSum {
    public static void main(String[] args) {
        // Example 16-bit binary array
        int[] arr = {1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1};

        if (arr.length != 16) {
            System.out.println("Please provide a valid 16-bit binary array.");
            return;
        }
        String first8Bits = convertArrayToBinaryString(arr, 0, 8);
        String last8Bits = convertArrayToBinaryString(arr, 8, 16);
        String binarySum = calculateBinarySum(first8Bits, last8Bits);
        String onesComplement = calculateOnesComplement(binarySum);
        String finalResult = calculateFinalSum(binarySum, onesComplement);
        System.out.println("First 8 bits: " + first8Bits);
        System.out.println("Last 8 bits: " + last8Bits);
        System.out.println("8-bit sum (after MSB adjustment if needed): " + binarySum);
        System.out.println("1's complement: " + onesComplement);
        System.out.println("Final 8-bit sum (after adding 1's complement and adjusting if needed): " + finalResult);
    }

    public static String convertArrayToBinaryString(int[] arr, int start, int end) {
        StringBuilder binaryString = new StringBuilder();
        for (int i = start; i < end; i++) {
            binaryString.append(arr[i]);
        }
        return binaryString.toString();
    }

    public static String calculateBinarySum(String first8Bits, String last8Bits) {
        int firstNumber = Integer.parseInt(first8Bits, 2);
        int lastNumber = Integer.parseInt(last8Bits, 2);
        int sum = firstNumber + lastNumber;

        String binarySum = Integer.toBinaryString(sum);

        if (binarySum.length() > 8) {
            char msb = binarySum.charAt(0);
            String remaining8Bits = binarySum.substring(1);
            int msbValue = Character.getNumericValue(msb);
            int remainingBitsValue = Integer.parseInt(remaining8Bits, 2);
            int finalResult = msbValue + remainingBitsValue;
            binarySum = String.format("%8s", Integer.toBinaryString(finalResult)).replace(' ', '0');
        } else {
            binarySum = String.format("%8s", binarySum).replace(' ', '0');
        }

        return binarySum;
    }

    public static String calculateOnesComplement(String binarySum) {
        StringBuilder onesComplement = new StringBuilder();
        for (char bit : binarySum.toCharArray()) {
            onesComplement.append(bit == '0' ? '1' : '0');
        }
        return onesComplement.toString();
    }

    public static String calculateFinalSum(String binarySum, String onesComplement) {
        int binarySumValue = Integer.parseInt(binarySum, 2);
        int onesComplementValue = Integer.parseInt(onesComplement, 2);
        int finalSum = binarySumValue + onesComplementValue;

        String finalBinarySum = Integer.toBinaryString(finalSum);

        if (finalBinarySum.length() > 8) {
            char msb = finalBinarySum.charAt(0);
            String remaining8Bits = finalBinarySum.substring(1);
            int msbValue = Character.getNumericValue(msb);
            int remainingBitsValue = Integer.parseInt(remaining8Bits, 2);
            int finalAdjustedSum = msbValue + remainingBitsValue;
            finalBinarySum = String.format("%8s", Integer.toBinaryString(finalAdjustedSum)).replace(' ', '0');
        } else {
            finalBinarySum = String.format("%8s", finalBinarySum).replace(' ', '0');
        }

        return finalBinarySum;
}

}
