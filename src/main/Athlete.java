package main;

public class Athlete {
    private String name;
    private TrainingPlan trainingPlan;
    private double weight;
    private WeightCategory weightCategory;
    private int competitions;
    private int coachingHours;

    public Athlete() {}

    public Athlete(String name, TrainingPlan trainingPlan, double weight, WeightCategory weightCategory, int competitions, int coachingHours) {
        this.name = name;
        this.trainingPlan = trainingPlan;
        this.weight = weight;
        this.weightCategory = weightCategory;
        this.competitions = competitions;
        this.coachingHours = coachingHours;
    }

    public String getName() {
        return name;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public double getWeight() {
        return weight;
    }

    public int getCompetitions() {
        return competitions;
    }

    public int getCoachingHours() {
        return coachingHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCompetitions(int competitions) {
        this.competitions = competitions;
    }

    public void setCoachingHours(int coachingHours) {
        this.coachingHours = coachingHours;
    }

    public WeightCategory getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(WeightCategory weightCategory) {
        this.weightCategory = weightCategory;
    }
}
