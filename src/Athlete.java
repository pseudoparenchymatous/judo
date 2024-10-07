public class Athlete {
    private String name;
    private String trainingPlan;
    private double weight;
    private int competitions;
    private int coachingHours;

    public Athlete() {
        name = "";
        trainingPlan = "";
        weight = 0.0;
        competitions = 0;
        coachingHours = 0;
    }

    public Athlete(String name, String trainingPlan, double weight, int competitions, int coachingHours) {
        this.name = name;
        this.trainingPlan = trainingPlan;
        this.weight = weight;
        this.competitions = competitions;
        this.coachingHours = coachingHours;
    }

    public String getName() {
        return name;
    }

    public String getTrainingPlan() {
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

    public void setTrainingPlan(String trainingPlan) {
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
}
