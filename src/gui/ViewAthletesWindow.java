package gui;

import main.Athlete;
import main.AthleteList;

import javax.swing.*;
import java.awt.*;

public class ViewAthletesWindow implements OptionWindow {
    private final JFrame frame;
    private final JPanel framePanel;
    private final JPanel selectionPanel;
    private final JComboBox<String> athleteSelection;

    public ViewAthletesWindow() {
        athleteSelection = new JComboBox<>(AthleteList.getList().getNames());

        frame = new JFrame("Cost Calculation");
        framePanel = new JPanel();
        frame.add(framePanel);

        selectionPanel = getSelectionPanel();
    }

    @Override
    public void spawnWindow() {
        updateList();

        framePanel.add(selectionPanel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel getSelectionPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 5, 10, 5);

        JLabel label = new JLabel("Name");
        panel.add(label, constraints);

        panel.add(athleteSelection, constraints);

        JButton computeButton = new JButton("Compute costs");
        computeButton.addActionListener(_ -> computeCost());
        panel.add(computeButton, constraints);

        return panel;
    }

    private void computeCost() {
        Object selection = athleteSelection.getSelectedItem();
        String athleteName = selection == null? "": selection.toString();

        Athlete athlete = AthleteList.getList().getAthleteByName(athleteName);
        new MonthlyCostsWindow(athlete);
    }

    private void updateList() {
        athleteSelection.removeAllItems();
        for (String name : AthleteList.getList().getNames()) {
            athleteSelection.addItem(name);
        }
    }
}
