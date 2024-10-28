package gui;

import main.Athlete;
import main.AthleteFeeCalculator;

import javax.swing.*;
import java.awt.*;

public class MonthlyCostsWindow {
    public MonthlyCostsWindow(Athlete athlete) {
        AthleteFeeCalculator calculator = new AthleteFeeCalculator(athlete);
        JFrame frame = new JFrame("Monthly Costs for " + athlete.getName());
        JPanel framePanel = new JPanel(new BorderLayout());
        frame.add(framePanel);

        JPanel namePanel = new JPanel(new GridBagLayout());
        framePanel.add(namePanel, BorderLayout.NORTH);

        JLabel nameMarker = new JLabel("Name");
        JLabel athleteName = new JLabel(athlete.getName());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        namePanel.add(nameMarker, gridBagConstraints);
        namePanel.add(athleteName, gridBagConstraints);

        JPanel costsPanel = new JPanel(new GridBagLayout());
        framePanel.add(costsPanel, BorderLayout.CENTER);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER; // Take entire row space
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        JLabel itemizedCostHeader = new JLabel("Itemized Costs");
        costsPanel.add(itemizedCostHeader, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridwidth = 1; // Reset width to take one space
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        JLabel trainingFeeLabel = new JLabel("Training Fee (" + athlete.getTrainingPlan() + ")");
        costsPanel.add(trainingFeeLabel, gridBagConstraints);

        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        JLabel trainingFeeBreakdown = new JLabel(String.format("4 weeks * $%.2f", calculator.getWeeklyTrainingFee()));
        costsPanel.add(trainingFeeBreakdown, gridBagConstraints);

        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        JLabel trainingFee = new JLabel(String.format("$%.2f", calculator.getMonthlyTrainingFee()));
        costsPanel.add(trainingFee, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy++;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        JLabel coachingFeeLabel = new JLabel("Private Coaching Fee");
        costsPanel.add(coachingFeeLabel, gridBagConstraints);

        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        JLabel coachingFeeBreakdown = new JLabel("4 weeks * " + athlete.getCoachingHours() + " hours * $9.00");
        costsPanel.add(coachingFeeBreakdown, gridBagConstraints);

        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        JLabel coachingFee = new JLabel(String.format("$%.2f", calculator.getMonthlyCoachingFee()));
        costsPanel.add(coachingFee, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy++;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        JLabel competitionFeeLabel = new JLabel("Competition Fee");
        costsPanel.add(competitionFeeLabel, gridBagConstraints);

        JLabel competitionFeeBreakdown = new JLabel(
            switch(athlete.getTrainingPlan()) {
                case BEGINNER -> "Beginners cannot enter competitions.";
                default -> athlete.getCompetitions() + " entry * $22.00";
            }
        );
        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        costsPanel.add(competitionFeeBreakdown, gridBagConstraints);

        gridBagConstraints.gridx++;
        JLabel competitionFee = new JLabel(String.format("$%.2f", calculator.getCompetitionFee()));
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        costsPanel.add(competitionFee, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy++;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        JLabel totalCostLabel = new JLabel("Total Monthly Cost");
        costsPanel.add(totalCostLabel, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        JLabel totalCost = new JLabel(String.format("$%.2f", calculator.getTotalMonthlyFee()));
        costsPanel.add(totalCost, gridBagConstraints);

        JButton closeButton = new JButton("Close");
        framePanel.add(closeButton, BorderLayout.SOUTH);
        closeButton.addActionListener(_ -> frame.dispose());

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
