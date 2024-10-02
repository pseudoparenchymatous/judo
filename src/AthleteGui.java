import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AthleteGui {
    private SubmitAthleteProfile submitted;
    private final JTextField nameField = new JTextField();
    private final String[] trainingPlans = {"Beginner", "Intermediate", "Elite"};
    private final JComboBox trainingPlan = new JComboBox(trainingPlans);
    private final SpinnerNumberModel competitionsModel = new SpinnerNumberModel(0, 0,30, 1);
    private final SpinnerNumberModel privateHoursModel = new SpinnerNumberModel(0, 0,5, 1);
    private final SpinnerNumberModel weightModel = new SpinnerNumberModel(1.00, 1.00, 150.00, 0.1);
    private final JSpinner weight = new JSpinner(weightModel);
    private final JSpinner competitions = new JSpinner(competitionsModel);
    private final JSpinner privateHours = new JSpinner(privateHoursModel);

    public AthleteGui() {
        JFrame frame = new JFrame("Enter athlete details");
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

        JPanel competitionsPanel = new JPanel();
        competitionsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        competitionsPanel.setLayout(new BoxLayout(competitionsPanel, BoxLayout.X_AXIS));
        formPanel.add(competitionsPanel);
        JLabel competitionsLabel = new JLabel("Number of competitions");
        competitionsLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        competitionsPanel.add(competitionsLabel);
        competitionsPanel.add(competitions);
        competitions.setEnabled(false);

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
        submitButton.addActionListener(_ -> submitForm());
        clearButton.addActionListener(_ -> clearForm());
        buttonsPanel.add(clearButton);
        buttonsPanel.add(submitButton);
        framePanel.add(buttonsPanel);

        frame.pack();
        frame.add(framePanel);
        frame.setVisible(true);
        frame.setSize(300, 300);
    }

    private void checkTrainingPlan() {
        int i = trainingPlan.getSelectedIndex();
        if (i == 0) {
            competitions.setValue(0);
            competitions.setEnabled(false);
        } else {
            competitions.setEnabled(true);
        }
    }

    private void clearForm() {
        nameField.setText("");
        trainingPlan.setSelectedIndex(0);
        competitions.setValue(0);
        weight.setValue(1.00);
        privateHours.setValue(0);
    }

    private void submitForm() {
        String name = nameField.getText();
        String trainingPlan = this.trainingPlan.getSelectedItem().toString();
        double weight = (double)this.weight.getValue();
        int competitions = (int)this.competitions.getValue();
        int coachingHours = (int)privateHours.getValue();

        System.out.println("Name: " + name);
        System.out.println("Training plan: " + trainingPlan);
        System.out.println("Weight: " + weight);
        System.out.println("Competitions: " + competitions);
        System.out.println("Hours of private coaching: " + coachingHours);

        Athlete athlete = new Athlete(name, trainingPlan, weight, competitions, coachingHours);
        if (submitted != null) {
            submitted.onSubmit(athlete);
        }
    }

    public void setSubmittedListener(SubmitAthleteProfile submitted) {
        this.submitted = submitted;
    }
}