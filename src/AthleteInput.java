import java.util.Scanner;

public class AthleteInput {
    private final Scanner input;

    public AthleteInput() {
        input = new Scanner(System.in);
    }

    public Athlete getAthlete() {
        Athlete athlete = new Athlete();

        athlete.setName(getName());
        athlete.setTrainingPlan(getTrainingPlan());
        athlete.setWeight(getWeight());
        athlete.setWeightCategory(getWeightCategory());
        athlete.setCompetitions(getCompetitions(athlete.getTrainingPlan()));
        athlete.setCoachingHours(getCoachingHours());

        return athlete;
    }

    public String getName() {
        System.out.print("Enter name: ");
        return input.next();
    }

    private TrainingPlan getTrainingPlan() {
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

            System.out.print("Pick training plan: ");
            if (input.hasNextInt()) {
                userInput = input.nextInt();
            } else {
                input.next();
            }

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

    private double getWeight() {
        double weight = 0.0;
        do {
            System.out.print("Enter weight in kg: ");
            if (input.hasNextDouble()) {
                weight = input.nextDouble();
            } else {
                input.next();
            }
        } while (weight < 1.0);

        return weight;
    }

    private String getWeightCategory() {
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

            System.out.print("Pick weight category: ");
            if (input.hasNextInt()) {
                userInput = input.nextInt();
            } else {
                input.next();
            }

            if (userInput < 1 || userInput > categories.length) {
                printInvalid();
            }
        } while (userInput < 1 || userInput > categories.length);

        return categories[userInput-1];
    }

   private int getCompetitions(TrainingPlan trainingPlan) {
        int userInput = -1;
        if (!(trainingPlan instanceof BeginnerPlan)) {
            do {
                System.out.print("Enter number of competition (0-1): ");
                if (input.hasNextInt()) {
                    userInput = input.nextInt();
                } else {
                    input.next();
                }

                if (userInput < 0 || userInput > 1) {
                    printInvalid();
                }
            } while (userInput < 0 || userInput > 1);
        }
        return userInput;
   }

   private int getCoachingHours() {
        int userInput = -1;
        do {
            System.out.print("Enter hours of private coaching (0-5): ");

            if (input.hasNextInt()) {
                userInput = input.nextInt();
            } else {
                input.next();
            }

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
