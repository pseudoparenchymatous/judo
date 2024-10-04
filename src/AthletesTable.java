import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AthletesTable implements AddAthlete {
    private final DefaultTableModel tableModel;

    public AthletesTable(ArrayList<Athlete> athletes) {
        JFrame.setDefaultLookAndFeelDecorated(false);
        JFrame frame = new JFrame("North Sussex Judo");

        JPanel framePanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(framePanel, BoxLayout.Y_AXIS);
        framePanel.setLayout(boxLayout);

        String[] column = {"Name", "Weight", "Category"};
        String[][] athleteData = new String[athletes.size()][column.length];
        for (int i = 0; i < athletes.size(); i++) {
            athleteData[i][0] = athletes.get(i).getAthleteName();
            athleteData[i][1] = Double.toString(athletes.get(i).getWeight());
            athleteData[i][2] = athletes.get(i).getWeightCategory();
        }
        tableModel = new DefaultTableModel(athleteData, column);
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        framePanel.add(tableScrollPane);

        JButton addAthleteButton = new JButton("Add new athlete");
        framePanel.add(addAthleteButton);

        addAthleteButton.addActionListener(_ -> addAthlete());

        frame.add(framePanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public void addAthlete() {
//        new AddAthleteWindow(this);
    }

    @Override
    public void onAdd(Athlete athlete) {
        String name = athlete.getAthleteName();
        String weight = String.valueOf(athlete.getWeight());
        String category = athlete.getWeightCategory();
        this.tableModel.addRow(new Object[]{name, weight, category});
    }
}
