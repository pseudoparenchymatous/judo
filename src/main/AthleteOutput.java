package main;

public class AthleteOutput {
    private Athlete athlete;
    public void printCosts(AthleteList list, String name) {
        athlete = list.getAthleteByName(name);
        if (athlete instanceof InvalidAthlete) {
            System.out.println("\u001B[31mAthlete not registered.\u001b[0m");
            return;
        }

        printDash(28);
        System.out.println("\tMonthly cost");
        printDash(28);

        System.out.printf("Athlete name: \u001B[34m\u001B[4m%s\u001B[0m\n", athlete.getName());

        System.out.println("Itemized costs:");
        double totalMonthlyCost = getTrainingFee();
        printTrainingFee();
        totalMonthlyCost += getCoachingFee();
        totalMonthlyCost += getCompetitionFee();

        System.out.printf("Total Monthly Cost: \u001B[32m$%.2f\u001B[0m\n", totalMonthlyCost);

        printComparison(athlete.getWeight(), athlete.getWeightCategory());
        System.out.println();
    }

    private void printDash(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private double getTrainingFee() {
        double weeklyFee = athlete.getTrainingPlan().getFee();
        double monthlyFee = weeklyFee * 4;
        return monthlyFee;
    }

    private void printTrainingFee() {
        double weeklyFee = athlete.getTrainingPlan().getFee();
        double monthlyFee = weeklyFee * 4;

        System.out.printf("\tTraining Fee (%s): ", athlete.getTrainingPlan());

        startGreenText();
        System.out.printf("$%.2f", monthlyFee);
        endGreenText();

        System.out.print(" (4weeks * ");
        startGreenText();
        System.out.printf("$%.2f", weeklyFee);
        endGreenText();
        System.out.println(")");
    }

    private double getCoachingFee() {
        double hourlyFee = 9.0;
        double monthlyFee = hourlyFee * athlete.getCoachingHours() * 4;

        System.out.print("\tPrivate Coaching: ");

        startGreenText();
        System.out.printf("$%.2f", monthlyFee);
        endGreenText();

        System.out.printf(" (4 weeks * %d hours * ", athlete.getCoachingHours());
        startGreenText();
        System.out.printf("$%.2f", hourlyFee);
        endGreenText();

        System.out.println(")");

        return monthlyFee;
    }

    private double getCompetitionFee() {
        System.out.print("\tCompetition Entry Fees: ");
        if (athlete.getTrainingPlan() == TrainingPlan.BEGINNER) {
            System.out.println("\u001B[31m(Beginners cannot enter competitions)\u001B[0m");
            return 0.0;
        }

        double fee = 22.00;
        System.out.printf("\u001B[32m$%.2f\u001B[0m (1 competition * \u001B[32m$%.2f)\u001B[0m\n", fee, fee);
        return fee;
    }

    private void printComparison(double weight, String category) {
        System.out.printf("Weight Comparison: %.2fkg (current) vs. ", weight);
        switch (category) {
            case "Flyweight":
                System.out.print("66kg (category limit) -- ");
                if (weight <= 66) {
                    System.out.println("within limit.");
                } else {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-66);
                }
                break;
            case "Lightweight":
                System.out.print("73kg (category limit) -- ");
                if (weight > 66 && weight <= 73) {
                    System.out.println("within limit.");
                } else if (weight > 73) {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-73);
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 67-weight);
                }
                break;
            case "Light-Middleweight":
                System.out.print("81 (category limit) -- ");
                if (weight > 73 && weight <= 81) {
                    System.out.println("within limit.");
                } else if (weight > 81) {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-81);
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 74-weight);
                }
                break;
            case "Middleweight":
                System.out.print("90 (category limit) -- ");
                if (weight > 81 && weight <= 90) {
                    System.out.println("within limit.");
                } else if (weight > 90) {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-90);
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 82-weight);
                }
                break;
            case "Light-Heavyweight":
                System.out.print("100 (category limit) -- ");
                if (weight > 90 && weight <= 100) {
                    System.out.println("within limit.");
                } else if (weight > 100) {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-100);
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 91-weight);
                }
                break;
            case "Heavyweight":
                System.out.print("Unlimited (no limit) -- ");
                if (weight > 100) {
                    System.out.println("within limit.");
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 101-weight);
                }
                break;
        }
    }

    private void startGreenText() {
        System.out.print("\u001B[32m");
    }

    private void endGreenText() {
        System.out.print("\u001B[0m");
    }
}
