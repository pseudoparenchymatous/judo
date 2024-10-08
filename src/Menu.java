import java.util.Scanner;

public class Menu implements Choice {
    private final String[] welcomeMessages = {"Welcome to North Sussex Judo", "What would you like to do?"};
    private final String[] choices = {"Register athlete", "Print costs", "Exit"};

    @Override
    public int getUserChoice(String[] choices) {
        printChoices(choices);
        int choicesLen = choices.length;

        Scanner input = new Scanner(System.in);
        System.out.print("\u001B[32m");
        int userInput = 0;
        do {
            if (input.hasNextInt()) {
                userInput = input.nextInt();
            } else {
                input.next();
            }
            System.out.print("\u001B[0m");

            if (userInput < 1 || userInput > choicesLen) {
                System.out.println("\u001b[31mInvalid input.\u001b[0m Input 1-" + choicesLen);
            }
        } while (userInput < 1 || userInput > choicesLen);
        return userInput;
    }

    public Menu() {
        AthleteInput athleteInput = new AthleteInput();
        AthleteOutput athleteOutput = new AthleteOutput();

        int userInput;
        do {
            printWelcomeMessages();

            userInput = getUserChoice(choices);
            switch (userInput) {
                case 1:
                    AthleteList.getList().addAthlete(athleteInput.inputAthlete());
                    break;
                case 2:
                    athleteOutput.printCosts(AthleteList.getList(), athleteInput.inputName());
                    break;
                default:
                    System.out.println("Exiting...");
            }
        } while (userInput != 3);
    }

    private void printWelcomeMessages() {
        for (String message: welcomeMessages) {
            System.out.println(message);
        }
    }

    private void printChoices(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            System.out.printf("%d.) %s\n", i + 1, choices[i]);
        }
    }
}
