public class Athlete {
    private String athleteName;
    private String trainingPlan;
    private double weight; // in kgs
    private String weightCategory;
    private boolean willCompete; // this month
    private int noOfPrivateHours;

    public Athlete() {
        athleteName = "";
        trainingPlan = "";
        weight = 0.00;
        weightCategory = "";
        willCompete = false;
        noOfPrivateHours = 0;
    }

    public Athlete(String name, String trainingPlan, double weight, String weightCategory, boolean willCompete, int coachingHours) {
        this.athleteName = name;
        this.trainingPlan = trainingPlan;
        this.weight = weight;
        this.willCompete = willCompete;
        this.noOfPrivateHours = coachingHours;
        this.weightCategory = weightCategory;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public double getWeight() {
        return weight;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public double getMonthlyTrainingFee() {
        double fee = 0.00;
        double[] fees = {25.00, 30.00, 35};
        String[] trainingPlans = {"Beginner", "Intermediate", "Elite"};

        for (int i = 0; i < trainingPlans.length; i++) {
            if (trainingPlans[i].equals(trainingPlan)) {
                fee = fees[i] * 4;
            }
        }

        return fee;
    }
}
