import java.util.ArrayList;

public class AthleteList {
    private ArrayList<Athlete> list;

    public AthleteList() {
        list = new ArrayList<>();
    }

    public void addAthlete(Athlete athlete) {
        list.add(athlete);
    }

    public Athlete getAthleteByName(String name) {
        Athlete athlete = new Athlete();
        for (Athlete value : list) {
            if (value.getName().equals(name)) {
                athlete = value;
            }
        }

        return athlete;
    }
}
