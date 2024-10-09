package main;

import gui.GuiWindow;

import java.util.concurrent.CompletableFuture;

public class Menu implements Choice {
    private final String[] welcomeMessages = {"Welcome to North Sussex Judo", "What would you like to do?"};
    private final String[] choices = {"Register athlete", "Print costs", "Exit"};
    private GuiWindow gui;

    public Menu() {
        CompletableFuture<GuiWindow> guiFuture = CompletableFuture.supplyAsync(() -> new GuiWindow());
        try {
            gui = guiFuture.get();
        } catch (Exception e) {
            System.out.println(e);
        }

        AthleteInput athleteInput = new AthleteInput();
        AthleteOutput athleteOutput = new AthleteOutput();

        int userInput;
        do {
            printWelcomeMessages();

            userInput = getUserChoice(choices);
            switch (userInput) {
                case 1:
                    AthleteList.addAthlete(athleteInput.inputAthlete());
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
}
