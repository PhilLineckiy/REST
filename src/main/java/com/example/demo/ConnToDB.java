package com.example.demo;

import java.io.PrintWriter;
import java.sql.*;

public class ConnToDB {
    static Connection conn;
    String jdbcURL = "jdbc:h2:tcp://localhost/~/test1";
    String username = "sa";
    String password = "";


    private static ConnToDB instance = new ConnToDB();
    public static ConnToDB getInstance() {
        return instance;
    }
    public void start() {
        try {
            Class.forName("org.h2.Driver");
            //String jdbcURL = "jdbc:h2:tcp://localhost/~/test1";
            //String username = "sa";
            //String password = "";

            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            //out.println("Connected to H2 embedded database.");
            String sql = "SELECT * FROM test";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            int count = 0;

            while (resultSet.next()) {
                count++;

                int ID = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                //out.println("Student #" + count + ": " + ID + ", " + name);
            }

            connection.close();
            //out.print("success");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
