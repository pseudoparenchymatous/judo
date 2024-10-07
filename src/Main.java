public class Main {
    public static void main(String[] args) {
        Athlete athlete1 = new Athlete("Georey", "Beginner", 32.45, 1, 2);
        AthleteList list = new AthleteList();
        list.addAthlete(athlete1);
        Athlete athlete = list.getAthleteByName("Georey");

        System.out.println("Athlete name: " + athlete.getName());
        System.out.println("Training plan: " + athlete.getTrainingPlan());
        System.out.println("Weight: " + athlete.getWeight());
        System.out.println("Competitions: " + athlete.getCompetitions());
        System.out.println("Hours of private coaching: " + athlete.getCoachingHours());
    }
}
