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
        Athlete athlete = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                athlete = list.get(i);
            }
        }

        return athlete;
    }
}
