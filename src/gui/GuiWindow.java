package gui;

import javax.swing.*;
import java.awt.*;

public class GuiWindow {
    private OptionWindow[] optionWindows;

    public GuiWindow(String[] messages, String[] options) {
        optionWindows = new OptionWindow[]{
            new RegisterAthleteWindow(),
            new ViewAthletesWindow(),
            new ExitWindow()
        };

        JFrame frame = new JFrame("North Sussex Judo");
        JPanel framePanel = new JPanel();
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
        frame.add(framePanel);

        framePanel.add(welcomePanel(messages));
        framePanel.add(optionsPanel(options));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel welcomePanel(String[] messages) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (String message: messages) {
            JLabel label = new JLabel(message);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(label);
        }

        return panel;
    }

    private JPanel optionsPanel(String[] options) {
        JPanel panel = new JPanel();

        for (int i = 0; i < options.length; i++) {
            final int x = i;
            JButton button = new JButton(options[i]);
            button.addActionListener(_ -> optionWindows[x].spawnWindow());
            panel.add(button);
        }

        return panel;
    }
}
