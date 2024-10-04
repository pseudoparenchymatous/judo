import java.util.ArrayList;

public class AthleteList {
    private final ArrayList<Athlete> list;

    public AthleteList() {
        list = new ArrayList<>();
        list.add(new Athlete("Alex", "Intermediate", 98.5, "Light-Heavyweight", false, 5));
        list.add(new Athlete("Bob", "Elite", 110.6, "Heavyweight", false, 0));
        list.add(new Athlete("Charlie", "Elite", 96.4, "Light-Heavyweight", false, 0));
        list.add(new Athlete("Danny", "Beginner", 60.5, "Lightweight", false, 0));
        list.add(new Athlete("Edward", "Beginner", 105.7, "Heavyweight", false, 0));
        list.add(new Athlete("Frank", "Beginner", 86.2, "Middleweight", false, 0));
    }

    public void addAthlete(Athlete athlete) {
        this.list.add(athlete);
    }

    public boolean doesAthleteExist(String name) {
        for (Athlete athlete: list) {
            if (athlete.getAthleteName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
