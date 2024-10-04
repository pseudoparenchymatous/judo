import java.util.concurrent.CompletableFuture;

public class WelcomeMenu implements AddAthlete {
    private final String judoName = "North Sussex Judo";

    private final String[] welcomeMessages = {"Welcome to " + judoName, "What would you like to do?"};
    private final String[] choices = {"Add new athlete", "Print costs"};

    private AthleteSubmission submission = new AthleteSubmission(this);
    private AthleteList list;

    private final CliMenu cli = new CliMenu();
    private final GuiMenu gui = new GuiMenu(judoName);

    public WelcomeMenu(AthleteList list) {
        this.list = list;

        gui.welcome(welcomeMessages);
        gui.showChoices(choices);

        cli.welcome(welcomeMessages);

        do {
            cli.showChoices(choices);

            int choice = cli.getChoice();

            switch (choice) {
                case 1:
                    Athlete athlete = cli.inputAthlete();
                    cli.addAthlete(list, athlete);
                    break;
                case 2:
                    cli.viewCost(list);
                    break;
            }
        } while (true);

//        JFrame frame = new JFrame();
//        JPanel framePanel = new JPanel();
//        frame.add(framePanel);
//
//        JLabel welcomeMessage = new JLabel("Welcome to North Sussex Judo", JLabel.CENTER);
//        JLabel promptMessage = new JLabel("What would you like to do?", JLabel.CENTER);
//        framePanel.add(welcomeMessage);
//        framePanel.add(promptMessage);
//
//        JPanel buttonsPanel = new JPanel();
//        JButton addAthleteButton = new JButton("Add new athlete");
//        JButton viewAthleteButton = new JButton("View athlete");
//        buttonsPanel.add(addAthleteButton);
//        buttonsPanel.add(viewAthleteButton);
//        framePanel.add(buttonsPanel);
//
//        addAthleteButton.addActionListener(_ -> addAthlete(list));
//        viewAthleteButton.addActionListener(_ -> viewAthlete(list));

    }

    private void addAthlete(AthleteList list) {
        System.out.println("Spawning add athlete window");
        new AddAthleteWindow(submission);
    }

    private void viewCosts() {}

    private void viewAthlete(AthleteList list) {
        System.out.println("Viewing athlete");
    }

    @Override
    public void onAdd(Athlete athlete) {
        list.addAthlete(athlete);
    }
}
