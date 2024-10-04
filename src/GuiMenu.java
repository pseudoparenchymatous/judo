import javax.swing.*;

public class GuiMenu implements Menu {
    private final JPanel buttonsPanel = new JPanel();
    private final JPanel welcomePanel = new JPanel();

    public GuiMenu(String name) {
        JFrame frame = new JFrame(name);
        JPanel framePanel = new JPanel();
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
        frame.add(framePanel);

        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        framePanel.add(welcomePanel);
        framePanel.add(buttonsPanel);

        frame.setBounds(100, 30, 320, 120);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void welcome(String[] messages) {
        JLabel[] welcomeLabels = new JLabel[messages.length];
        for (int i = 0; i < welcomeLabels.length; i++) {
            welcomeLabels[i] = new JLabel(messages[i]);
            welcomeLabels[i].setAlignmentX(JComponent.CENTER_ALIGNMENT);
            welcomePanel.add(welcomeLabels[i]);
        }
    }

    @Override
    public void showChoices(String[] choices) {
        JButton[] choicesButton = new JButton[choices.length];
        for (int i = 0; i < choicesButton.length; i++) {
            choicesButton[i] = new JButton(choices[i]);
            buttonsPanel.add(choicesButton[i]);
            System.out.println(choices[i]);
        }

    }

    @Override
    public int getChoice() {
//        buttonsPanel.getComponent(0).addComponentListener(_ -> addAthlete(list, new Athlete()));
        return 0;
    }

    @Override
    public Athlete inputAthlete() {
        return null;
    }

    @Override
    public void addAthlete(AthleteList list, Athlete athlete) {

    }

    @Override
    public void viewCost(AthleteList list) {

    }
}
