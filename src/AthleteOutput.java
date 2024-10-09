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
        totalMonthlyCost += getCoachingFee();
        totalMonthlyCost += getCompetitionFee();
        System.out.printf("Total Monthly Cost: $%.2f\n", totalMonthlyCost);
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
        System.out.printf("\tTraining Fee (%s): ", athlete.getTrainingPlan());
        System.out.printf("$%.2f (4weeks * $%.2f)\n", monthlyFee, weeklyFee);

        return monthlyFee;
    }

    private double getCoachingFee() {
        double hourlyFee = 9.0;
        double monthlyFee = hourlyFee * athlete.getCoachingHours() * 4;

        System.out.printf("\tPrivate Coaching: $%.2f (4weeks * %d hours * $%.2f)\n",
                monthlyFee,
                athlete.getCoachingHours(),
                hourlyFee
        );

        return monthlyFee;
    }

    private double getCompetitionFee() {
        System.out.print("\tCompetition Entry Fees: ");
        if (athlete.getTrainingPlan() instanceof BeginnerPlan) {
            System.out.println("\u001B[31m(Beginners cannot enter competitions)\u001B[0m");
            return 0.0;
        }

        double fee = 22.00;
        System.out.printf("$%.2f (1 competition * $%.2f)\n", fee, fee);
        return  fee;
    }

    private void printComparison(double weight, String category) {
        System.out.printf("Weight Comparison: %.2fkg (current) vs. ", weight);
        switch (category) {
            case "Flyweight":
                System.out.printf("66kg (category limit) -- ");
                if (weight <= 66) {
                    System.out.println("within limit.");
                } else {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-66);
                }
                break;
            case "Lightweight":
                System.out.printf("73kg (category limit) -- ");
                if (weight > 66 && weight <= 73) {
                    System.out.println("within limit.");
                } else if (weight > 73) {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-73);
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 67-weight);
                }
                break;
            case "Light-Middleweight":
                System.out.printf("81 (category limit) -- ");
                if (weight > 73 && weight <= 81) {
                    System.out.println("within limit.");
                } else if (weight > 81) {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-81);
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 74-weight);
                }
                break;
            case "Middleweight":
                System.out.printf("90 (category limit) -- ");
                if (weight > 81 && weight <= 90) {
                    System.out.println("within limit.");
                } else if (weight > 90) {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-90);
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 82-weight);
                }
                break;
            case "Light-Heavyweight":
                System.out.printf("100 (category limit) -- ");
                if (weight > 90 && weight <= 100) {
                    System.out.println("within limit.");
                } else if (weight > 100) {
                    System.out.printf("exceeds limit by %.2f. Athlete needs to lose weight to meet requirements\n", weight-100);
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 91-weight);
                }
                break;
            case "Heavyweight":
                System.out.printf("Unlimited (no limit) -- ");
                if (weight > 100) {
                    System.out.println("within limit.");
                } else {
                    System.out.printf("below limit by %.2f. Athlete needs to gain weight to meet requirements\n", 101-weight);
                }
                break;
        }
    }
}
