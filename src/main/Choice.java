package main;

import java.util.Scanner;

public interface Choice {
    Scanner input = new Scanner(System.in);

    default int getUserChoice(String[] choices) {
        printChoices(choices);
        int choicesLen = choices.length;

        System.out.print("\u001B[32m");
        int userInput = 0;
        do {
            if (input.hasNextInt()) {
                userInput = input.nextInt();
                input.nextLine();
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

    default void printChoices(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            System.out.printf("%d.) %s\n", i + 1, choices[i]);
        }
    }
}
