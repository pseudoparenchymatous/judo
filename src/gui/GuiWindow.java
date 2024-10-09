package gui;

import javax.swing.*;
import java.util.HashMap;

public class GuiWindow {
    private final String[] welcomeMessages = {"Welcome to North Sussex Judo", "What would you like to do?"};
    private final HashMap<String, Choice> choicesButton = new HashMap<>() {{
        put("Register athlete", new AddAthleteWindow());
        put("Print costs", new PrintCostsWindow());
        put("Exit", new ExitWindow());
    }};

    private final JPanel buttonsPanel = new JPanel();
    private final JPanel welcomePanel = new JPanel();

    public GuiWindow() {
        JFrame frame = new JFrame("North Sussex Judo");
        JPanel framePanel = new JPanel();
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
        frame.add(framePanel);

        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        framePanel.add(welcomePanel);
        framePanel.add(buttonsPanel);

        printWelcomeMessages();
        addButtons();

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void printWelcomeMessages() {
        for (String message: welcomeMessages) {
            JLabel label = new JLabel(message);
            label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            welcomePanel.add(label);
        }
    }

    private void addButtons() {
        for (String choice: choicesButton.keySet()) {
            JButton button = new JButton(choice);
            button.addActionListener(_ -> choicesButton.get(choice).spawnWindow());
            buttonsPanel.add(button);
        }
    }
}
