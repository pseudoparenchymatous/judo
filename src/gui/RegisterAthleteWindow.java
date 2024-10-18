package gui;

import main.TrainingPlan;
import main.WeightCategory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class RegisterAthleteWindow implements OptionWindow {
    private JFrame frame;
    private JPanel framePanel;

    private final GridBagConstraints constraints;

    private JLabel invalidNameLabel = new JLabel("Invalid value. Must only include letters");

    private JTextField nameField;
    private JSpinner weightSpinner;
    private JComboBox<WeightCategory> weightCategoryJComboBox;
    private JSpinner privateCoachingSpinner;

    private JComboBox<TrainingPlan> trainingPlanJComboBox;
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
        JPanel panel = createFlowPanel();

        JLabel nameLabel = new JLabel("Name");
        nameField = new JTextField();

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

        invalidNameLabel.setForeground(Color.RED);
        invalidNameLabel.setVisible(false);

        panel.add(nameLabel);
        panel.add(getInvisibleGap(5));
        panel.add(nameField);
        panel.add(invalidNameLabel);

        return panel;
    }

    private JPanel getTrainingPlanPanel() {
        JPanel panel = createFlowPanel();

        JLabel label = new JLabel("Training plan");
        trainingPlanJComboBox = new JComboBox<>(TrainingPlan.values());

        panel.add(label);
        panel.add(trainingPlanJComboBox);

        trainingPlanJComboBox.addActionListener(e -> checkTrainingPlan());

        return panel;
    }

    private JPanel getWeightPanel() {
        JPanel panel = createFlowPanel();

        JLabel label = new JLabel("Weight");

        SpinnerNumberModel weightModel = new SpinnerNumberModel(40.00, 40.00, 200.00, 0.1);
        weightSpinner = new JSpinner(weightModel);

        panel.add(label);
        panel.add(weightSpinner);

        return panel;
    }

    private JPanel getCategoryPanel() {
        JPanel panel = createFlowPanel();

        JLabel label = new JLabel("Weight category");
         weightCategoryJComboBox = new JComboBox<>(WeightCategory.values());

        panel.add(label);
        panel.add(weightCategoryJComboBox);

        return panel;
    }

    private JPanel getCompetitionsPanel() {
        JPanel panel = createFlowPanel();

        JLabel label = new JLabel("Competitions");

        competitionsButtonGroup = new ButtonGroup();
        zeroCompetitionRadioButton = new JRadioButton("0");
        oneCompetitionRadioButton = new JRadioButton("1");
        competitionsButtonGroup.add(zeroCompetitionRadioButton);
        competitionsButtonGroup.add(oneCompetitionRadioButton);

        zeroCompetitionRadioButton.setSelected(true);
        oneCompetitionRadioButton.setEnabled(false);

        panel.add(label);
        panel.add(zeroCompetitionRadioButton);
        panel.add(oneCompetitionRadioButton);

        return panel;
    }

    private JPanel getPrivateCoachingPanel() {
        JPanel panel = createFlowPanel();

        JLabel label = new JLabel("Private coaching hours");
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 5, 1);
        privateCoachingSpinner = new JSpinner(spinnerModel);

        panel.add(label);
        panel.add(privateCoachingSpinner);

        return panel;
    }

    private JPanel getButtonsPanel() {
        JPanel panel = new JPanel();

        JButton resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");

        submitButton.setEnabled(false);

        resetButton.addActionListener(e -> resetForm());

        panel.add(resetButton);
        panel.add(submitButton);

        return panel;
    }

    private JPanel createFlowPanel() {
        return new JPanel(new FlowLayout(FlowLayout.LEFT));
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

        if (validName && !name.isEmpty()) {
            invalidNameLabel.setVisible(false);
            submitButton.setEnabled(true);
        } else {
            invalidNameLabel.setVisible(true);
            submitButton.setEnabled(false);
        }

    }

    private void checkTrainingPlan() {
        if (trainingPlanJComboBox.getSelectedItem() == TrainingPlan.BEGINNER) {
            zeroCompetitionRadioButton.setSelected(true);
            oneCompetitionRadioButton.setEnabled(false);
        } else {
            oneCompetitionRadioButton.setEnabled(true);
        }
    }

    private void resetForm() {
        nameField.setText("");
        trainingPlanJComboBox.setSelectedIndex(0);
        weightSpinner.setValue(40.00);
        weightCategoryJComboBox.setSelectedIndex(0);
        privateCoachingSpinner.setValue(0);
    }
}
