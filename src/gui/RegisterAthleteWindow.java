package gui;

import database.Database;
import main.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class RegisterAthleteWindow implements OptionWindow {
    private final JFrame frame;
    private JPanel framePanel;

    private final GridBagConstraints constraints;

    private JTextField nameField;
    private JComboBox<TrainingPlan> trainingPlanJComboBox;
    private JSpinner weightSpinner;
    private JComboBox<WeightCategory> weightCategoryJComboBox;
    private JSpinner privateCoachingSpinner;

    private JRadioButton oneCompetitionRadioButton;
    private JRadioButton zeroCompetitionRadioButton;
    private ButtonGroup competitionsButtonGroup;

    private JButton submitButton;

    public RegisterAthleteWindow() {
        frame = new JFrame("Enter athlete details");
        framePanel = new JPanel(new GridBagLayout());

        constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 20, 5, 20);
        framePanel.add(getNamePanel(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        framePanel.add(getTrainingPlanPanel(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        framePanel.add(getWeightPanel(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        framePanel.add(getCategoryPanel(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        framePanel.add(getCompetitionsPanel(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        framePanel.add(getPrivateCoachingPanel(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        framePanel.add(getButtonsPanel(), constraints);

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
        JPanel panel = new JPanel(new BorderLayout());

        JLabel nameLabel = new JLabel("Name");
        panel.add(nameLabel, BorderLayout.WEST);

        nameField = new JTextField(10);
        panel.add(nameField, BorderLayout.EAST);

        nameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkName(nameField);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkName(nameField);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        return panel;
    }

    private JPanel getTrainingPlanPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Training plan");
        trainingPlanJComboBox = new JComboBox<>(TrainingPlan.values());

        panel.add(label, BorderLayout.WEST);
        panel.add(trainingPlanJComboBox, BorderLayout.EAST);

        trainingPlanJComboBox.addActionListener(e -> checkTrainingPlan());

        return panel;
    }

    private JPanel getWeightPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Weight");

        SpinnerNumberModel weightModel = new SpinnerNumberModel(40.00, 40.00, 200.00, 0.1);
        weightSpinner = new JSpinner(weightModel);

        panel.add(label, BorderLayout.WEST);
        panel.add(weightSpinner, BorderLayout.EAST);

        return panel;
    }

    private JPanel getCategoryPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Weight category");
        weightCategoryJComboBox = new JComboBox<>(WeightCategory.values());

        panel.add(label, BorderLayout.WEST);
        panel.add(weightCategoryJComboBox, BorderLayout.EAST);

        return panel;
    }

    private JPanel getCompetitionsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Competitions");

        competitionsButtonGroup = new ButtonGroup();
        zeroCompetitionRadioButton = new JRadioButton("0");
        oneCompetitionRadioButton = new JRadioButton("1");
        competitionsButtonGroup.add(zeroCompetitionRadioButton);
        competitionsButtonGroup.add(oneCompetitionRadioButton);

        zeroCompetitionRadioButton.setSelected(true);
        oneCompetitionRadioButton.setEnabled(false);

        panel.add(label, BorderLayout.WEST);

        JPanel radioPanel = new JPanel();
        radioPanel.add(zeroCompetitionRadioButton);
        radioPanel.add(oneCompetitionRadioButton);
        panel.add(radioPanel, BorderLayout.EAST);

        return panel;
    }

    private JPanel getPrivateCoachingPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Private coaching hours");
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 5, 1);
        privateCoachingSpinner = new JSpinner(spinnerModel);

        panel.add(label, BorderLayout.WEST);
        panel.add(privateCoachingSpinner, BorderLayout.EAST);

        return panel;
    }

    private JPanel getButtonsPanel() {
        JPanel panel = new JPanel();

        JButton infoButton = new JButton("Info");

        JButton resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");

        submitButton.setEnabled(false);

        infoButton.addActionListener(e -> spawnInfoDialog());
        resetButton.addActionListener(e -> resetForm());
        submitButton.addActionListener(e -> submitForm());

        panel.add(infoButton);
        panel.add(resetButton);
        panel.add(submitButton);

        return panel;
    }

    private void checkName(JTextField field) {
        boolean validName = true;
        String name = field.getText();
        for (char c: name.toCharArray()) {
           if (!Character.isSpaceChar(c)) {
               if (!Character.isLetter(c)) {
                   validName = false;
               }
           }
        }

        submitButton.setEnabled(validName && !name.isEmpty());

    }

    private void checkTrainingPlan() {
        if (trainingPlanJComboBox.getSelectedItem() == TrainingPlan.BEGINNER) {
            zeroCompetitionRadioButton.setSelected(true);
            oneCompetitionRadioButton.setEnabled(false);
        } else {
            oneCompetitionRadioButton.setEnabled(true);
        }
    }

    private void spawnInfoDialog() {
        JDialog dialog = new JDialog(frame, "Info");

        JPanel panel = new JPanel();
        dialog.add(panel);

        JLabel beginnerCompetitionInfo = new JLabel("Beginners cannot enter competitions");
        panel.add(beginnerCompetitionInfo);

        dialog.setResizable(false);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void resetForm() {
        nameField.setText("");
        trainingPlanJComboBox.setSelectedIndex(0);
        weightSpinner.setValue(40.00);
        weightCategoryJComboBox.setSelectedIndex(0);
        privateCoachingSpinner.setValue(0);
    }

    private void submitForm() {
        String name = nameField.getText();
        TrainingPlan trainingPlan = (TrainingPlan) trainingPlanJComboBox.getSelectedItem();
        double weight = (double) weightSpinner.getValue();
        WeightCategory category = (WeightCategory) weightCategoryJComboBox.getSelectedItem();
        int competitions = oneCompetitionRadioButton.isSelected()? 1 : 0;
        int coachingHours = (int) privateCoachingSpinner.getValue();

        Athlete athlete = new Athlete(
            name,
            trainingPlan,
            weight,
            category,
            competitions,
            coachingHours
        );

        new MonthlyCostsWindow(athlete);

        Database.getDatabase().addAthlete(athlete);
        AthleteList.getList().addAthlete(athlete);

        frame.setVisible(false);
        resetForm();
    }

}
