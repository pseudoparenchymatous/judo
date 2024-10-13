package main;

import java.util.Arrays;

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
        return Arrays.stream(TrainingPlan.values())
                     .map(String::valueOf)
                     .toArray(String[]::new);
    }
}
