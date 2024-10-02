public class Athlete {
    private String athleteName;
    private String trainingPlan;
    private double weight; // in kgs
    private String weightCategory;
    private int noOfCompetitions; // this month
    private int noOfPrivateHours;

    public Athlete(String name, String trainingPlan, double weight, int competitions, int coachingHours) {
        this.athleteName = name;
        this.trainingPlan = trainingPlan;
        this.weight = weight;
        this.noOfCompetitions = competitions;
        this.noOfPrivateHours = coachingHours;
        setWeightCategory();
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

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public void setWeightCategory() {
        if (weight > 100) {
            weightCategory = "Heavyweight";
        } else if (weight > 90) {
            weightCategory = "Light-Heavyweight";
        } else if (weight > 81) {
            weightCategory = "Middleweight";
        } else if (weight > 73) {
            weightCategory = "Light-Middleweight";
        } else if (weight > 66) {
            weightCategory = "Lightweight";
        } else {
            weightCategory = "Flyweight";
        }
    }

    public void setNoOfCompetitions(int noOfCompetitions) {
        this.noOfCompetitions = noOfCompetitions;
    }

    public void setNoOfPrivateHours(int noOfPrivateHours) {
        this.noOfPrivateHours = noOfPrivateHours;
    }

    public void setTrainingPlan(String trainingPlan) {
        this.trainingPlan = trainingPlan;
    }
}
