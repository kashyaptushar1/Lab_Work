class Stop_And_Wait {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}; // Packets to be sent
        int currentPacket = 0; // Track the current packet being sent

        while (currentPacket < arr.length) {
            // Sender sends the current packet
            System.out.println("Sender sends packet: " + arr[currentPacket]);
            try {
                Thread.sleep(1000); // Simulate sending delay
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted: " + e.getMessage());
            }

            // Simulate acknowledgment reception with possible loss
            if (Math.random() > 0.8) { // 20% chance of acknowledgment loss
                System.out.println("Receiver did not acknowledge packet: " + arr[currentPacket]);
                System.out.println("Retransmitting packet: " + arr[currentPacket]);
            } else {
                System.out.println("Receiver acknowledged packet: " + arr[currentPacket]);
                currentPacket++; // Move to the next packet only if acknowledged
            }

            try {
                Thread.sleep(500); // Simulate acknowledgment delay
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        }

        System.out.println("All packets sent and acknowledged successfully.");
    }
}
