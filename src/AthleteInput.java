import java.util.Scanner;

public class AthleteInput {
    private final Scanner input;

    public AthleteInput() {
        input = new Scanner(System.in);
    }

    public Athlete inputAthlete() {
        Athlete athlete = new Athlete();

        athlete.setName(inputName());
        athlete.setTrainingPlan(inputTrainingPlan());
        athlete.setWeight(inputWeight());
        athlete.setWeightCategory(inputWeightCategory());
        athlete.setCompetitions(inputCompetitions(athlete.getTrainingPlan()));
        athlete.setCoachingHours(inputCoachingHours());

        return athlete;
    }

    public String inputName() {
        System.out.print("Enter name: \u001B[32m");
        String name = input.next();
        System.out.print("\u001B[0m");

        return name;
    }

    private TrainingPlan inputTrainingPlan() {
        String[] trainingPlans = {
            BeginnerPlan.getString(),
            IntermediatePlan.getString(),
            ElitePlan.getString()
        };

        int userInput = 0;

        do {
            System.out.println("Available plans are:");
            for (int i = 0; i < trainingPlans.length; i++) {
                System.out.printf("%d.) %s\n", i + 1, trainingPlans[i]);
            }

            System.out.print("Pick training plan: \u001B[32m");
            if (input.hasNextInt()) {
                userInput = input.nextInt();
            } else {
                input.next();
            }
            System.out.print("\u001B[0m");

            if (userInput < 1 || userInput > trainingPlans.length) {
                System.out.println("\u001B[31mInvalid input.\u001B[0m");
            }
        } while (userInput < 1 || userInput > trainingPlans.length);

        return switch (userInput) {
            case 3 -> new ElitePlan();
            case 2 -> new IntermediatePlan();
            default -> new BeginnerPlan();
        };
    }

    private double inputWeight() {
        double weight = 0.0;
        do {
            System.out.print("Enter weight in kg: \u001B[32m");
            if (input.hasNextDouble()) {
                weight = input.nextDouble();
            } else {
                input.next();
            }
            System.out.print("\u001B[0m");
        } while (weight < 1.0);

        return weight;
    }

    private String inputWeightCategory() {
        String[] categories = {
            "Flyweight",
            "Lightweight",
            "Light-Middleweight",
            "Middleweight",
            "Light-Heavyweight",
            "Heavyweight"
        };

        int userInput = 0;
        do {
            System.out.println("Available weight categories");
            for (int i = 0; i < categories.length; i++) {
                System.out.printf("%d.) %s\n", i + 1, categories[i]);
            }

            System.out.print("Pick weight category: \u001B[32m");
            if (input.hasNextInt()) {
                userInput = input.nextInt();
            } else {
                input.next();
            }
            System.out.print("\u001B[0m");

            if (userInput < 1 || userInput > categories.length) {
                printInvalid();
            }
        } while (userInput < 1 || userInput > categories.length);

        return categories[userInput-1];
    }

    private int inputCompetitions(TrainingPlan trainingPlan) {
        int userInput = -1;
        if (!(trainingPlan instanceof BeginnerPlan)) {
            do {
                System.out.print("Enter number of competition (0-1): \u001B[32m");
                if (input.hasNextInt()) {
                    userInput = input.nextInt();
                } else {
                    input.next();
                }
                System.out.print("\u001B[0m");

                if (userInput < 0 || userInput > 1) {
                    printInvalid();
                }
            } while (userInput < 0 || userInput > 1);
        }
        return userInput;
    }

    private int inputCoachingHours() {
        int userInput = -1;
        do {
            System.out.print("Enter hours of private coaching (0-5): \u001B[32m");

            if (input.hasNextInt()) {
                userInput = input.nextInt();
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
