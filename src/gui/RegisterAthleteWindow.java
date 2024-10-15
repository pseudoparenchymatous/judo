package gui;

import javax.swing.*;
import java.awt.*;

public class RegisterAthleteWindow implements OptionWindow {
    private JFrame frame;
    private JPanel framePanel;

    public RegisterAthleteWindow() {
        frame = new JFrame();
        framePanel = new JPanel();
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));

        framePanel.add(getNamePanel());

        frame.add(framePanel);
    }

    @Override
    public void spawnWindow() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private JPanel getNamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel nameLabel = new JLabel("Name: ");
        JTextField field = new JTextField();
        Dimension dimension = new Dimension(120, 20);
        field.setMaximumSize(dimension);

        panel.add(nameLabel);
        panel.add(field);

        return panel;
    }
}
