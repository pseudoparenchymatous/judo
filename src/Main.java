import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(new Athlete("Alex", "Intermediate", 98.5, 2, 5));
        athletes.add(new Athlete("Bob", "Elite", 110.6, 3, 0));
        athletes.add(new Athlete("Charlie", "Elite", 96.4, 1, 0));
        athletes.add(new Athlete("Danny", "Beginner", 60.5, 0, 0));
        athletes.add(new Athlete("Edward", "Beginner", 105.7, 1, 0));
        athletes.add(new Athlete("Frank", "Beginner", 86.2, 0, 0));

        AthletesTable athletesTable = new AthletesTable(athletes);

        input.close();
    }
}
