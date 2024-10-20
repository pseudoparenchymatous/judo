package main;

public class AthleteOutput {
    private Athlete athlete;
    private final AthleteFeeCalculator calculator;

    public AthleteOutput(Athlete athlete) {
        this.athlete = athlete;
        this.calculator = new AthleteFeeCalculator(athlete);
    }

    public void printOutput() {
        if (athlete instanceof UnregisteredAthlete) {
            System.out.println("\u001B[31mAthlete not registered.\u001b[0m");
            return;
        }

        System.out.println();
        printDash(28);
        System.out.println("\tMonthly cost");
        printDash(28);

        // Print athlete name in blue + underlined
        System.out.printf("Athlete name: \u001B[34m\u001B[4m%s\u001B[0m\n", athlete.getName());

        System.out.println("Itemized costs:");
        printTrainingFee();
        printCoachingFee();
        printCompetitionFee();

        System.out.print("Total monthly cost: ");
        startGreenText();
        System.out.printf("$%.2f\n", calculator.getTotalMonthlyFee());
        endGreenText();

        printComparison();
        System.out.println();
        System.out.println();
    }

    private void printDash(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void printTrainingFee() {
        double weeklyFee = calculator.getWeeklyTrainingFee();
        double monthlyFee = calculator.getMonthlyTrainingFee();

        System.out.printf("\tTraining Fee (%s): ", athlete.getTrainingPlan());

        startGreenText();
        System.out.printf("$%.2f", monthlyFee);
        endGreenText();

        System.out.print(" (4 weeks * ");
        startGreenText();
        System.out.printf("$%.2f", weeklyFee);
        endGreenText();
        System.out.println(")");
    }

    private void printCoachingFee() {
        double hourlyFee = calculator.getHourlyCoachingFee();
        double monthlyFee = calculator.getMonthlyCoachingFee();

        System.out.print("\tPrivate Coaching: "); 
        startGreenText();
        System.out.printf("$%.2f", monthlyFee);
        endGreenText();

        System.out.printf(" (4 weeks * %d hour/s * ", athlete.getCoachingHours());

        startGreenText();
        System.out.printf("$%.2f", hourlyFee);
        endGreenText();

        System.out.println(")");

    }

    private void printCompetitionFee() {
        System.out.print("\tCompetition Entry Fees: ");

        if (athlete.getTrainingPlan() == TrainingPlan.BEGINNER) {
            System.out.println("\u001B[31m(Beginners cannot enter competitions)\u001B[0m");
            return;
        }

        double fee = calculator.getCompetitionFee();
        int competitions = athlete.getCompetitions();

        System.out.printf("\u001B[32m$%.2f\u001B[0m (%d competition * \u001B[32m$%.2f)\u001B[0m\n", fee, competitions, fee);
    }

    private void printComparison() {
        double weight = athlete.getWeight();
        WeightCategory category = athlete.getWeightCategory();
        WeightComparison comparison = new WeightComparison(category, weight);
        String limit = comparison.getLimit();

        System.out.print("Weight comparison: ");
        System.out.printf("%.2f kg (current) vs %s (%s limit)\n", weight, limit, category);
        System.out.printf("\t %s %s", comparison.getResult(), comparison.getSuggestion());
    }

    private void startGreenText() {
        System.out.print("\u001B[32m");
    }

    private void endGreenText() {
        System.out.print("\u001B[0m");
    }
}
