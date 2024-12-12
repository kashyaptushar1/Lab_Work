class Go_Back_N {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int windowSize = 3;
        int lastAckReceived = -1;

        while (lastAckReceived < arr.length - 1) {
            System.out.println("Current window starts at packet index: " + (lastAckReceived + 1));
            for (int i = lastAckReceived + 1; i < arr.length && i <= lastAckReceived + windowSize; i++) {
                System.out.println("Sender sends packet: " + arr[i]);
                try {
                    Thread.sleep(1000); // Simulate sending delay
                } catch (InterruptedException e) {
                    System.err.println("Thread was interrupted: " + e.getMessage());
                }
            }

            boolean ackReceived = true;
            for (int i = lastAckReceived + 1; i < arr.length && i <= lastAckReceived + windowSize; i++) {
                if (Math.random() > 0.8) {
                    System.out.println("Receiver did not acknowledge packet: " + arr[i]);
                    ackReceived = false;
                    break;
                } else {
                    System.out.println("Receiver acknowledged packet: " + arr[i]);
                    lastAckReceived = i;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.err.println("Thread was interrupted: " + e.getMessage());
                    }
                }
            }
            if (!ackReceived) {
                System.out.println("Retransmitting from packet: " + (lastAckReceived + 1));
            }
        }

        System.out.println("All packets sent and acknowledged successfully.");
    }
}
