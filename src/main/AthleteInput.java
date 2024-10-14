package main;

import java.util.Scanner;

public class AthleteInput implements Choice {
    private final Scanner input;

    public AthleteInput() {
        input = new Scanner(System.in);
    }

    public Athlete inputAthlete() {
        String name = inputName();
        TrainingPlan trainingPlan = inputTrainingPlan();
        double weight = inputWeight();
        WeightCategory weightCategory = inputWeightCategory();
        int competitions = inputCompetitions(trainingPlan);
        int coachingHours = inputCoachingHours();

        return new Athlete(name, trainingPlan, weight, weightCategory, competitions, coachingHours);
    }

    public String inputName() {
        boolean invalidName = false;
        String name = "";

        do {
            invalidName = false;

            System.out.print("Enter name: \u001B[32m");
            name = input.nextLine();
            System.out.print("\u001B[0m");

            // Name is invalid if input contains non-letter characters
            for (char c: name.toCharArray()) {
                if (!Character.isSpaceChar(c)) {
                    if (!Character.isLetter(c)) {
                        invalidName = true;
                    }
                }
            }

            // Print message in red color
            if (invalidName) {
                System.out.println("\u001B[31mName must only contain letters\u001B[0m");
            }
        } while (invalidName);

        return name;
    }

    private TrainingPlan inputTrainingPlan() {
        String[] trainingPlans = TrainingPlan.getPlans();

        System.out.println("Available plans are:");
        int userInput = getUserChoice(trainingPlans);

        return switch (userInput) {
            case 3 -> TrainingPlan.ELITE;
            case 2 -> TrainingPlan.INTERMEDIATE;
            default -> TrainingPlan.BEGINNER;
        };
    }

    private double inputWeight() {
        double weight = 0.0;
        do {
            System.out.print("Enter weight in kg: \u001B[32m");
            if (input.hasNextDouble()) {
                weight = input.nextDouble();
                input.nextLine();
            } else {
                input.next();
            }
            System.out.print("\u001B[0m");

            if (weight < 40 || weight > 200) {
                System.out.println("\u001B[31mPlease enter weight within the limit.\u001B[0m");
            }
        } while (weight < 40 || weight > 200);

        return weight;
    }

    private WeightCategory inputWeightCategory() {
        String[] categories = WeightCategory.getCategories();

        System.out.println("Available weight categories");
        int userInput = getUserChoice(categories);

        return WeightCategory.values()[userInput-1];
    }

    private int inputCompetitions(TrainingPlan trainingPlan) {
        int userInput = 0;
        if (trainingPlan != TrainingPlan.BEGINNER) {
            do {
                System.out.print("Enter number of competition (0-1): \u001B[32m");
                if (input.hasNextInt()) {
                    userInput = input.nextInt();
                    input.nextLine();
                } else {
                    input.next();
                }
                System.out.print("\u001B[0m");

                if (userInput <= -1 || userInput > 1) {
                    printInvalid();
                }
            } while (userInput <= -1 || userInput > 1);
        }
        return userInput;
    }

    private int inputCoachingHours() {
        int userInput = -1;
        do {
            System.out.print("Enter hours of private coaching (0-5): \u001B[32m");

            if (input.hasNextInt()) {
                userInput = input.nextInt();
                input.nextLine();
            } else {
                input.next();
            }
            System.out.print("\u001B[0m");

            if (userInput < 0 || userInput > 5) {
                printInvalid();
            }
        } while (userInput < 0 || userInput > 5);
        return userInput;
    }

    private void printInvalid() {
        System.out.println("\u001B[31mInvalid input.\u001B[0m");
    }

}
