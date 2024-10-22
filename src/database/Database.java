package database;

import main.Athlete;
import main.TrainingPlan;
import main.UnregisteredAthlete;
import main.WeightCategory;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static Database instance;

    private final String url = "jdbc:h2:tcp://localhost/D:/Saliente/judo/test";
    private final String username = "geo";
    private final String password = "123";

    private Database() {}

    public static Database getDatabase() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public void addAthlete(Athlete athlete) {
        try (
            Connection connection = DriverManager.getConnection(url, username, password)
        ) {
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
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public String[] getNames() {
        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement sqlStatement = connection.createStatement();
            ResultSet namesResult = sqlStatement.executeQuery("SELECT name FROM athletes");
        ) {
            ArrayList<String> namesList = new ArrayList<>();

            while (namesResult.next()) {
                String name = namesResult.getString("name");
                namesList.add(name);
            }

            return namesList.toArray(new String[0]);
        } catch (SQLException e) {
            System.out.println("Database operation failed:  " + e.getMessage());
        }
        return new String[0];
    }

    public Athlete getAthleteByName(String athleteName) {
        String query = String.format("SELECT * FROM athletes WHERE name='%s'", athleteName);
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement sqlStatement = connection.createStatement();
                ResultSet athleteResult = sqlStatement.executeQuery(query);
        ) {
            if (athleteResult.next()) {
                String name = athleteResult.getString("name");
                TrainingPlan trainingPlan = switch (athleteResult.getString("training_plan")) {
                    case "Elite" -> TrainingPlan.ELITE;
                    case "Intermediate" -> TrainingPlan.INTERMEDIATE;
                    default -> TrainingPlan.BEGINNER;
                };
                double weight  = athleteResult.getDouble("weight");
                WeightCategory category = switch(athleteResult.getString("category")) {
                    case "Heavyweight" -> WeightCategory.HEAVYWEIGHT;
                    case "Light-Heavyweight" -> WeightCategory.LIGHT_HEAVYWEIGHT;
                    case "Middleweight" -> WeightCategory.MIDDLEWEIGHT;
                    case "Light-Middleweight" -> WeightCategory.LIGHT_MIDDLEWEIGHT;
                    case "Flyweight" -> WeightCategory.FLYWEIGHT;
                    default -> WeightCategory.LIGHTWEIGHT;
                };
                int competitions = athleteResult.getInt("competitions");
                int coachingHours = athleteResult.getInt("coaching_hours");

                return new Athlete(name, trainingPlan, weight, category, competitions, coachingHours);
            }
        } catch (SQLException e) {
            System.out.println("Database operation failed:  " + e.getMessage());
        }

        return new UnregisteredAthlete();
    }
}
