package main;

public class AthleteFeeCalculator {
    private final Athlete athlete;

    public AthleteFeeCalculator(Athlete athlete) {
        this.athlete = athlete;
    }

    public double getWeeklyTrainingFee() {
        return athlete.getTrainingPlan().getFee();
    }

    public double getMonthlyTrainingFee() {
        return getWeeklyTrainingFee() * 4;
    }

    public double getHourlyCoachingFee() {
        return 9.00;
    }

    public double getWeeklyCoachingFee() {
        return getHourlyCoachingFee() * athlete.getCoachingHours();
    }

    public double getMonthlyCoachingFee() {
        return getWeeklyCoachingFee() * 4;
    }

    public double getCompetitionFee() {
        return athlete.getCompetitions() * 22.00;
    }

    public double getTotalMonthlyFee() {
        return getMonthlyTrainingFee() + getMonthlyCoachingFee() + getCompetitionFee();
    }

}
