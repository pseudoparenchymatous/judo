package main;

public enum TrainingPlan {
    BEGINNER     (25.00),
    INTERMEDIATE (30.00),
    ELITE        (35.00);

    private final double fee;

    TrainingPlan(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public static String[] getPlans() {
        String[] plans = new String[TrainingPlan.values().length];
        for (int i = 0; i < TrainingPlan.values().length; i++) {
            plans[i] = TrainingPlan.values()[i].name();
        }
        return plans;
    }
}
