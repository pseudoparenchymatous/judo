import java.util.Scanner;

public class CliMenu implements Menu {
    private final Scanner cliInput = new Scanner(System.in);

    @Override
    public void welcome(String[] messages) {
        for (String msg: messages) {
            System.out.println(msg);
        }
    }

    @Override
    public void showChoices(String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i + 1 + ".) " + choices[i]);
        }
    }

    private String inputTrainingPlan() {
        int choice = 0;
        do {
            System.out.println("Available training plans are:");
            System.out.println("1.) Beginner");
            System.out.println("2.) Intermediate");
            System.out.println("3.) Elite");

            if (cliInput.hasNextInt()) {
                choice = cliInput.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Please only pick a number between 1-3");
                }
            } else {
                cliInput.next();
            }


        } while (choice < 1 || choice > 3);

        return switch (choice) {
            case 1 -> "Beginner";
            case 2 -> "Intermediate";
            case 3 -> "Elite";
            default -> "Training plan error";
        };
    }

    private double inputWeight() {
        double weight;
        do {
            System.out.println("Enter weight: ");
            weight = cliInput.nextDouble();
        } while (weight < 0);
        return weight;
    }

    private String inputCategory() {
        String[] categories = {"Heavyweight", "Light-Heavyweight", "Middleweight", "Light-Middleweight", "Lightweight", "Flyweight"};
        int choice;

        do {
            System.out.println("Available categories:");
            for (int i = 0; i < categories.length; i++) {
                System.out.println(i + 1 + ".) " + categories[i]);
            }
            choice = cliInput.nextInt();
        } while (choice < 1 || choice > 6);

        return categories[choice];
    }

    private boolean checkTrainingPlan(String trainingPlan) {
        if (trainingPlan.equals("Beginner")) {
            return false;
        } else {
            int choice;
            do {
                System.out.println("Will you be competiting?");
                System.out.println("1.) Yes");
                System.out.println("2.) No");
                choice = cliInput.nextInt();
            } while (choice < 1 || choice > 2);

            return choice == 1;
        }
    }

    private int inputHoursOfCoaching() {
        int hours;
        do {
            System.out.print("Enter number of hours of private coaching: ");
            hours = cliInput.nextInt();
        } while (hours < 0 || hours > 20);
        return hours;
    }

    @Override
    public int getChoice() {
        return cliInput.nextInt();
    }

    @Override
    public Athlete inputAthlete() {
        System.out.println("Enter athlete name");
        String name = cliInput.next();
        String trainingPlan = inputTrainingPlan();
        double weight = inputWeight();
        String category = inputCategory();
        boolean willCompete = checkTrainingPlan(trainingPlan);
        int hoursOfCoaching = inputHoursOfCoaching();

        return new Athlete(name, trainingPlan, weight, category, willCompete, hoursOfCoaching);
    }

    @Override
    public void addAthlete(AthleteList list, Athlete athlete) {
        list.addAthlete(athlete);
    }

    @Override
    public void viewCost(AthleteList list) {

        String name;
        boolean found = false;
        do {
            System.out.print("Enter athlete name to output: ");
            name = cliInput.next();

            if (list.doesAthleteExist(name)) {
                found = true;
                System.out.println("Athlete found");
            } else {
                System.out.println("Athlete not found!");
            }
        } while (!found);
    }
}
