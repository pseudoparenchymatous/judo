public interface Menu {
    void welcome(String[] messages);
    void showChoices(String[] choices);
    int getChoice();
    Athlete inputAthlete();
    void addAthlete(AthleteList list, Athlete athlete);
    void viewCost(AthleteList list);
}
