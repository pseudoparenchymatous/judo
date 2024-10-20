package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
    private static H2Connection instance;
    public Connection connection;

    private H2Connection() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/Lithan/judo", "geo", "geo");
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to database");
        }
    }

    public static H2Connection getInstance() {
        if (instance == null) {
            instance = new H2Connection();
        }

        return instance;
    }
}
