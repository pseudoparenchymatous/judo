package gui;

import main.Athlete;
import main.AthleteFeeCalculator;
import main.AthleteList;
import main.TrainingPlan;

import javax.swing.*;
import java.awt.*;

public class ViewAthletesWindow implements OptionWindow {
    private final JFrame frame;
    private final JPanel framePanel;
    private final JPanel selectionPanel;
    private final JPanel outputPanel;
    private final JComboBox<String> athleteSelection;

    private JLabel nameLabel;
    private JLabel trainingFeeBreakdown;
    private JLabel trainingFee;
    private JLabel coachingFeeBreakdown;
    private JLabel coachingFee;
    private JLabel competitionFeeBreakdown;
    private JLabel competitionFee;
    private JLabel totalCost;

    private Athlete athlete;

    public ViewAthletesWindow() {
        athleteSelection = new JComboBox<>(AthleteList.getList().getNames());

        frame = new JFrame("Cost Calculation");
        framePanel = new JPanel();
        frame.add(framePanel);

        nameLabel = new JLabel();

        selectionPanel = getSelectionPanel();
        outputPanel = getOutputPanel();
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
        computeButton.addActionListener(e -> computeCost());
        panel.add(computeButton, constraints);

        return panel;
    }

    private JPanel getOutputPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel namePanel = new JPanel();
        panel.add(namePanel, BorderLayout.NORTH);

        JLabel nameHeader = new JLabel("Name");
        namePanel.add(nameHeader, BorderLayout.WEST);

        namePanel.add(nameLabel, BorderLayout.EAST);

        JPanel costsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        panel.add(costsPanel, BorderLayout.CENTER);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = GridBagConstraints.REMAINDER; // Take entire row space
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 5, 5, 5);
        JLabel itemizedCostHeader = new JLabel("Itemized Costs");
        costsPanel.add(itemizedCostHeader, constraints);

        constraints.gridy++;
        constraints.gridwidth = 1; // Reset width to take one space
        constraints.anchor = GridBagConstraints.EAST;
        JLabel trainingFeeLabel = new JLabel("Training Fee");
        costsPanel.add(trainingFeeLabel, constraints);

        constraints.gridx++;
        constraints.anchor = GridBagConstraints.CENTER;
        trainingFeeBreakdown = new JLabel();
        costsPanel.add(trainingFeeBreakdown, constraints);

        constraints.gridx++;
        constraints.anchor = GridBagConstraints.WEST;
        trainingFee = new JLabel();
        costsPanel.add(trainingFee, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.anchor = GridBagConstraints.EAST;
        JLabel coachingFeeLabel = new JLabel("Private Coaching Fee");
        costsPanel.add(coachingFeeLabel, constraints);

        constraints.gridx++;
        constraints.anchor = GridBagConstraints.CENTER;
        coachingFeeBreakdown = new JLabel();
        costsPanel.add(coachingFeeBreakdown, constraints);

        constraints.gridx++;
        constraints.anchor = GridBagConstraints.WEST;
        coachingFee = new JLabel();
        costsPanel.add(coachingFee, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.anchor = GridBagConstraints.EAST;
        JLabel competitionFeeLabel = new JLabel("Competition Fee");
        costsPanel.add(competitionFeeLabel, constraints);

        constraints.gridx++;
        competitionFeeBreakdown = new JLabel();
        constraints.anchor = GridBagConstraints.CENTER;
        costsPanel.add(competitionFeeBreakdown, constraints);

        constraints.gridx++;
        competitionFee = new JLabel();
        constraints.anchor = GridBagConstraints.WEST;
        costsPanel.add(competitionFee, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.EAST;
        JLabel totalCostLabel = new JLabel("Total Monthly Cost");
        costsPanel.add(totalCostLabel, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        totalCost = new JLabel();
        costsPanel.add(totalCost, constraints);

        JButton backButton = new JButton("Go back");
        backButton.addActionListener(e -> {
            framePanel.remove(outputPanel);
            framePanel.add(selectionPanel);
            frame.pack();
        });
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private void computeCost() {
        Object selection = athleteSelection.getSelectedItem();
        String athleteName = selection == null? "": selection.toString();

        athlete = AthleteList.getList().getAthleteByName(athleteName);
        AthleteFeeCalculator calculator = new AthleteFeeCalculator(athlete);

        nameLabel.setText(athlete.getName());
        trainingFeeBreakdown.setText("4 weeks * $" + calculator.getWeeklyTrainingFee());
        trainingFee.setText("$" + calculator.getMonthlyTrainingFee());

        if (athlete.getTrainingPlan() == TrainingPlan.BEGINNER) {
            competitionFeeBreakdown.setText("Beginners cannot enter competitions");
        } else {
            competitionFeeBreakdown.setText(athlete.getCompetitions() + " entry * $22.00");
        }
        competitionFee.setText("$" + calculator.getCompetitionFee());

        coachingFeeBreakdown.setText("4 weeks * " + athlete.getCoachingHours() + " hours * $9.00");
        coachingFee.setText("$" + calculator.getMonthlyCoachingFee());
        totalCost.setText("$" + calculator.getTotalMonthlyFee());

        framePanel.remove(selectionPanel);
        framePanel.add(outputPanel);
        frame.pack();
    }

    private void updateList() {
        athleteSelection.removeAllItems();
        for (String name : AthleteList.getList().getNames()) {
            athleteSelection.addItem(name);
        }
    }
}
