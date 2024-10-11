package main;

public class Menu implements Choice {
    private final String[] welcomeMessages = {"Welcome to North Sussex Judo", "What would you like to do?"};
    private final String[] choices = {"Register athlete", "Print costs", "Exit"};

    public Menu() {
        AthleteInput athleteInput = new AthleteInput();

        int userInput;
        do {
            printWelcomeMessages();

            userInput = getUserChoice(choices);
            switch (userInput) {
                case 1:
                    AthleteList.getList().addAthlete(athleteInput.inputAthlete());
                    break;
                case 2:
                    Athlete athlete = AthleteList.getList().getAthleteByName(athleteInput.inputName());
                    AthleteOutput athleteOutput = new AthleteOutput(athlete);
                    athleteOutput.printOutput();
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
}
