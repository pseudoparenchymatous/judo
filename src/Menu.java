import java.util.Scanner;

public class Menu {
    private final String[] welcomeMessages = {"Welcome to North Sussex Judo", "What would you like to do?"};
    private final String[] options = {"Register athlete", "Print costs"};

    public Menu() {
        printWelcomeMessages();
        printOptions();
        int userInput = getUserInput(options.length);
        switch (userInput) {
            case 1:
                System.out.println("Adding athlete");
                break;
            case 2:
                System.out.println("Printing costs");
                break;
            default:
                System.out.println("Unexpected input");
        }
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

    private int getUserInput(int noOfChoices) {
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        do {
            if (input.hasNextInt()) {
                userInput = input.nextInt();
            } else {
                input.next();
            }

            if (userInput < 1 || userInput > noOfChoices) {
                System.out.println("Invalid input. Input 1-" + noOfChoices);
            }
        } while (userInput < 1 || userInput > noOfChoices);
        return userInput;
    }

}
