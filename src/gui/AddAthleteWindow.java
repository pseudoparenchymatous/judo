package gui;

import main.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddAthleteWindow implements Choice {
    private final JFrame frame = new JFrame("Enter athlete details");
    private final JTextField nameField = new JTextField();
    private final String[] trainingPlans = {"Beginner", "Intermediate", "Elite"};
    private final String[] weightCategories = {
        "Flyweight",
        "Lightweight",
        "Light-Middleweight",
        "Middleweight",
        "Light-Heavyweight",
        "Heavyweight"
    };
    private final JComboBox trainingPlan = new JComboBox(trainingPlans);
    private final JComboBox weightCategory = new JComboBox(weightCategories);
    private final SpinnerNumberModel competitionsModel = new SpinnerNumberModel(0, 0,30, 1);
    private final SpinnerNumberModel privateHoursModel = new SpinnerNumberModel(0, 0,5, 1);
    private final SpinnerNumberModel weightModel = new SpinnerNumberModel(1.00, 1.00, 150.00, 0.1);
    private final JSpinner weight = new JSpinner(weightModel);
    private final ButtonGroup competitionsRadioGroup = new ButtonGroup();
    private final JPanel competitionsPanel = new JPanel();
    private final JRadioButton willCompete = new JRadioButton("1");
    private final JSpinner privateHours = new JSpinner(privateHoursModel);

    public AddAthleteWindow() {
        JPanel framePanel = new JPanel();
        framePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));

        JPanel formPanel = new JPanel();
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        framePanel.add(formPanel);

        JPanel namePanel = new JPanel();
        namePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        formPanel.add(namePanel);
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        JPanel trainingPlanPanel = new JPanel();
        trainingPlanPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        trainingPlanPanel.setLayout(new BoxLayout(trainingPlanPanel, BoxLayout.X_AXIS));
        formPanel.add(trainingPlanPanel);
        JLabel trainingPlanLabel = new JLabel("Training plan");
        trainingPlanLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        trainingPlanPanel.add(trainingPlanLabel);
        trainingPlanPanel.add(trainingPlan);

        trainingPlan.addActionListener(_ -> checkTrainingPlan());

        JPanel weightPanel = new JPanel();
        weightPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.X_AXIS));
        formPanel.add(weightPanel);
        JLabel weightLabel = new JLabel("Weight (kg)");
        weightLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        weightPanel.add(weightLabel);
        weightPanel.add(weight);

        JPanel categoryPanel = new JPanel();
        categoryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.X_AXIS));
        formPanel.add(categoryPanel);
        JLabel categoryLabel = new JLabel("Weight category");
        categoryLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        categoryPanel.add(categoryLabel);
        categoryPanel.add(weightCategory);

        willCompete.setVisible(false);
        JLabel competitionsLabel = new JLabel("Number of competitions");
        JRadioButton willNotCompete = new JRadioButton("0");
        willNotCompete.setSelected(true);
        competitionsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        competitionsPanel.setLayout(new BoxLayout(competitionsPanel, BoxLayout.X_AXIS));
        formPanel.add(competitionsPanel);
        competitionsLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        competitionsPanel.add(competitionsLabel);

        competitionsRadioGroup.add(willCompete);
        competitionsRadioGroup.add(willNotCompete);
        competitionsPanel.add(willCompete);
        competitionsPanel.add(willNotCompete);

        JPanel hoursPanel = new JPanel();
        hoursPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        hoursPanel.setLayout(new BoxLayout(hoursPanel, BoxLayout.X_AXIS));
        formPanel.add(hoursPanel);
        JLabel hoursLabel = new JLabel("Hours of private coaching");
        hoursLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        hoursPanel.add(hoursLabel);
        hoursPanel.add(privateHours);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");
        buttonsPanel.add(clearButton);
        buttonsPanel.add(submitButton);
        framePanel.add(buttonsPanel);

        submitButton.addActionListener(_ -> submitForm());
        clearButton.addActionListener(_ -> clearForm());

        frame.add(framePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @Override
    public void spawnWindow() {
        frame.setVisible(true);
    }

    private void checkTrainingPlan() {
        if (trainingPlan.getSelectedIndex() == 0) {
            competitionsRadioGroup.clearSelection();
            willCompete.setVisible(false);
        } else {
            willCompete.setVisible(true);
        }
    }

    private void submitForm() {
        String name = nameField.getText();
        TrainingPlan trainingPlan = switch (this.trainingPlan.getSelectedIndex()) {
            case 2 -> new ElitePlan();
            case 1 -> new IntermediatePlan();
            default -> new BeginnerPlan();
        };
        double weight = (double)this.weight.getValue();
        String weightCategory = this.weightCategory.getSelectedItem().toString();
        int competitions = 0;
        if (willCompete.isSelected()) {
            competitions = 1;
        }

        int coachingHours = (int)privateHours.getValue();

        Athlete athlete = new Athlete(name, trainingPlan, weight, weightCategory, competitions, coachingHours);
        new AthleteProfileWindow(athlete);
//        AthleteList.addAthlete(athlete);

        clearForm();
        frame.setVisible(false);
    }

    private void clearForm() {
        nameField.setText("");
        trainingPlan.setSelectedIndex(0);
        weight.setValue(1.00);
        privateHours.setValue(0);
    }
}
