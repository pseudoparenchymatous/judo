package database;

import main.Athlete;

import java.sql.*;

public class Database {
    public final String url;
    public final String username;
    public final String password;

    public Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void addAthlete(Athlete athlete) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO athletes (name, training_plan, weight, category, competitions, coaching_hours) " +
                        "VALUES (?, ?, ?, ?, ?, ?)"
            );

            statement.setString(1, athlete.getName());
            statement.setString(2, athlete.getTrainingPlan().toString());
            statement.setDouble(3, athlete.getWeight());
            statement.setString(4, athlete.getWeightCategory().toString());
            statement.setInt(5, athlete.getCompetitions());
            statement.setInt(6, athlete.getCoachingHours());
            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

    }
}
