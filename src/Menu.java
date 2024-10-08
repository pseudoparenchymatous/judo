import java.util.Scanner;

public class Menu {
    private final String[] welcomeMessages = {"Welcome to North Sussex Judo", "What would you like to do?"};
    private final String[] options = {"Register athlete", "Print costs"};


    public Menu() {
        printWelcomeMessages();
        printOptions();
    }

    private void printWelcomeMessages() {
        for (String message: welcomeMessages) {
            System.out.println(message);
        }
    }

    private void printOptions() {
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d.) %s\n", i + 1, options[i]);
        }
    }
}
