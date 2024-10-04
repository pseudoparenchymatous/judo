package MultiThreading;

public class MultiThreadingExample {
    public static void main(String[] args) {
        Threading thread1 = new Threading(1);
        Threading thread2 = new Threading(2);

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Both threads have finished execution.");
    }
}
