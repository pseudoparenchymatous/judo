package gui;

import main.Athlete;
import main.AthleteList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AthleteProfileWindow {
    JFrame frame;
    public AthleteProfileWindow(Athlete athlete) {
        frame = new JFrame("Athlete");

        JPanel framePanel = new JPanel();
        framePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
        frame.add(framePanel);

        JLabel name = new JLabel("Name: " + athlete.getName());
        JLabel trainingPlan = new JLabel("Training plan: " + athlete.getTrainingPlan());
        JLabel weight = new JLabel("Weight: " + athlete.getWeight());
        JLabel category = new JLabel("Category: " + athlete.getWeightCategory());
        JLabel competitions = new JLabel("Number of competitions: " + athlete.getCompetitions());
        JLabel coachingHours = new JLabel("Hours of private coaching: " + athlete.getCoachingHours());
        JLabel confirmMessage = new JLabel("This athlete will be registered. Confirm?");
        JButton confirmButton = new JButton("Confirm");

        framePanel.add(name);
        framePanel.add(trainingPlan);
        framePanel.add(weight);
        framePanel.add(category);
        framePanel.add(competitions);
        framePanel.add(coachingHours);
        framePanel.add(confirmMessage);
        framePanel.add(confirmButton);

        confirmMessage.setForeground(Color.BLUE);
        confirmButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        confirmButton.addActionListener(_ -> AthleteList.addAthlete(athlete));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
