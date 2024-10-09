package gui;

import main.Athlete;
import main.AthleteList;
import main.AthleteOutput;
import main.InvalidAthlete;

import javax.swing.*;
import java.awt.*;

public class PrintCostsWindow implements Choice {
    private final JFrame frame;
    private final JPanel framePanel;
    AthleteOutput athleteOutput;
    JLabel athleteNameLabel;
    JLabel athleteName;
    JLabel itemizedCost;
    JLabel trainingFeeLabel;
    JLabel trainingFeeBreakdown;
    JLabel trainingFee;
    JLabel coachingBreakdown;
    JLabel coachingFee;
    JLabel competitionFee;
    JLabel totalCost;
    JLabel comparison;

    public PrintCostsWindow() {
        frame = new JFrame("Athlete Costs");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        framePanel = new JPanel();
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
        athleteOutput = new AthleteOutput();

        athleteNameLabel = new JLabel("Athlete name");
        athleteNameLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(athleteNameLabel);

        athleteName = new JLabel();
        athleteName.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(athleteName);

        itemizedCost = new JLabel("Itemized Costs");
        itemizedCost.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(itemizedCost);

        trainingFeeLabel = new JLabel();
        trainingFeeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(trainingFeeLabel);

        trainingFeeBreakdown = new JLabel();
        trainingFeeBreakdown.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(trainingFeeBreakdown);

        trainingFee = new JLabel();
        trainingFee.setForeground(new Color(71, 82, 0));
        trainingFee.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(trainingFee);

        JLabel privateCoachingLabel = new JLabel("Private Coaching");
        privateCoachingLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(privateCoachingLabel);

        coachingBreakdown = new JLabel();
        coachingBreakdown.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(coachingBreakdown);

        coachingFee = new JLabel();
        coachingFee.setForeground(new Color(71, 82, 0));
        coachingFee.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(coachingFee);

        JLabel competitionFeeLabel = new JLabel("Competition Fee");
        competitionFeeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(competitionFeeLabel);

        competitionFee = new JLabel();
        competitionFee.setForeground(new Color(71, 82, 0));
        competitionFee.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(competitionFee);

        JLabel totalCostLabel = new JLabel("Total Monthly Cost");
        totalCostLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(totalCostLabel);

        totalCost = new JLabel();
        totalCost.setForeground(new Color(71, 82, 0));
        totalCost.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        framePanel.add(totalCost);

        JPanel comparisonPanel = new JPanel();
        framePanel.add(comparisonPanel);

        JLabel comparisonLabel = new JLabel("Weight Comparison");
        comparisonLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        comparisonPanel.add(comparisonLabel);

        comparison = new JLabel();
        comparisonPanel.add(comparison);

        frame.add(framePanel);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(false);
    }

    @Override
    public void spawnWindow() {
        String name = JOptionPane.showInputDialog(frame, "Enter name", "");

        Athlete athlete = AthleteList.getList().getAthleteByName(name);
        if (athlete instanceof InvalidAthlete) {
            JOptionPane.showMessageDialog(frame, "Athlete not registered", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        frame.setVisible(true);

        double[] costs = athleteOutput.getCosts(athlete);

        athleteName.setText(name);
        trainingFeeLabel.setText("Training Fee (" + athlete.getTrainingPlan() + ")");
        trainingFee.setText("$" + costs[0]);       trainingFeeBreakdown.setText("4 weeks * $" + athlete.getTrainingPlan().getFee());
        coachingBreakdown.setText("4 weeks * " + athlete.getCoachingHours() + " hours * $9.00");
        coachingFee.setText("$"+costs[1]);
        competitionFee.setText("$"+costs[2]);
        totalCost.setText("$"+costs[3]);
        comparison.setText(athleteOutput.getComparison(athlete.getWeight(), athlete.getWeightCategory()).toString());

    }
}
