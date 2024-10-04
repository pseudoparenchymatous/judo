public class AthleteSubmission {
    private final AddAthlete addAthleteReceiver;

    public void setAthlete(Athlete athlete) {
        this.addAthleteReceiver.onAdd(athlete);
    }

    public AthleteSubmission(AddAthlete addAthleteReceiver) {
        this.addAthleteReceiver = addAthleteReceiver;
    }
}
