package MultiThreading;

public class Threading extends Thread {
    private int threadNumber;

    public Threading(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + threadNumber + ": " + i);
            try {
                // Sleep for a short time to simulate work
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadNumber + " interrupted.");
            }
        }
    }
}
