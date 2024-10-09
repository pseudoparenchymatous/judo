package main;

public class ElitePlan extends TrainingPlan {
    public static String getString() {
        return "Elite";
    }

    @Override
    public double getFee() {
        return 35.00;
    }

    @Override
    public String toString() {
        return getString();
    }
}
