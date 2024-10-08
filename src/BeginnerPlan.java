public class BeginnerPlan extends TrainingPlan {
    public static String getString() {
        return "Beginner";
    }

    @Override
    public double getFee() {
        return 25.00;
    }

    @Override
    public String toString() {
        return getString();
    }
}
