package main;

import java.util.ArrayList;

public class AthleteList {
    private static AthleteList instance;
    private final ArrayList<Athlete> list;

    private AthleteList() {
        list = new ArrayList<>();
        list.add(new Athlete(
                "Alex",
                TrainingPlan.INTERMEDIATE,
                98.5,
                WeightCategory.LIGHT_HEAVYWEIGHT,
                1,
                5));
        list.add(new Athlete(
                "Bob",
                TrainingPlan.ELITE,
                110.6,
                WeightCategory.HEAVYWEIGHT,
                1,
                3));
        list.add(new Athlete(
                "Charlie",
                TrainingPlan.ELITE,
                96.4,
                WeightCategory.LIGHT_HEAVYWEIGHT,
                0,
                0));
        list.add(new Athlete(
                "Danny",
                TrainingPlan.BEGINNER,
                60.5,
                WeightCategory.FLYWEIGHT,
                0,
                0));
        list.add(new Athlete(
                "Edward",
                TrainingPlan.ELITE,
                105.7,
                WeightCategory.HEAVYWEIGHT,
                1,
                1));
        list.add(new Athlete(
                "Frank",
                TrainingPlan.INTERMEDIATE,
                86.2,
                WeightCategory.MIDDLEWEIGHT,
                1,
                1));
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

    public String[] getNames() {
        String[] names = new String[list.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = list.get(i).getName();
        }
        return names;
    }
}
