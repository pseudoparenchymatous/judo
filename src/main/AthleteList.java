package main;

import java.util.ArrayList;

public class AthleteList {
    private static AthleteList instance;
    private ArrayList<Athlete> list;

    private AthleteList() {
        list = new ArrayList<>();
    }

    public static AthleteList getList() {
        if (instance == null) {
            instance = new AthleteList();
        }

        return instance;
    }

    public void addAthlete(Athlete athlete) {
        list.add(athlete);
    }

    public Athlete getAthleteByName(String name) {
        Athlete athlete = new UnregisteredAthlete();

        for (Athlete value : list) {
            if (value.getName().equals(name)) {
                athlete = value;
            }
        }

        return athlete;
    }
}
