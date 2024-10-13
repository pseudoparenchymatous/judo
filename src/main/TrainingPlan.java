package main;

public enum TrainingPlan {
    BEGINNER     (25.00) {
        @Override
        public String toString() {
            return "Beginner";
        }
    },
    INTERMEDIATE (30.00) {
        @Override
        public String toString() {
            return "Intermediate";
        }
    },
    ELITE        (35.00) {
        @Override
        public String toString() {
            return "Elite";
        }
    };

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
