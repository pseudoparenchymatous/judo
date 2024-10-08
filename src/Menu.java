import java.util.Scanner;

public class Menu {
    private final String[] welcomeMessages = {"Welcome to North Sussex Judo", "What would you like to do?"};
    private final String[] choices = {"Register athlete", "Print costs", "Exit"};

    public Menu() {
        AthleteInput athleteInput = new AthleteInput();
        AthleteOutput athleteOutput = new AthleteOutput();

        int userInput;
        do {
            printWelcomeMessages();
            printChoices();
            userInput = getUserInput(choices.length);
            switch (userInput) {
                case 1:
                    AthleteList.getList().addAthlete(athleteInput.getAthlete());
                    break;
                case 2:
                    athleteOutput.printCosts(AthleteList.getList(), athleteInput.getName());
                    break;
                default:
                    System.out.println("Exiting");
            }
        } while (userInput != 3);
    }

    private void printWelcomeMessages() {
        for (String message: welcomeMessages) {
            System.out.println(message);
        }
    }

    private void printChoices() {
        for (int i = 0; i < choices.length; i++) {
            System.out.printf("%d.) %s\n", i + 1, choices[i]);
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
