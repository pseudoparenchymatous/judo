public class IntermediatePlan extends TrainingPlan {
    public static String getString() {
        return "Intermediate";
    }

    @Override
    public double getFee() {
        return 30.00;
    }

    @Override
    public String toString() {
        return getString();
    }
}
