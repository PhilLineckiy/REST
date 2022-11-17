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
    public void start(Person p) {
        try {
            Class.forName("org.h2.Driver");
            //String jdbcURL = "jdbc:h2:tcp://localhost/~/test1";
            //String username = "sa";
            //String password = "";

            //Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            conn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to H2 embedded database.");

            String sql = "INSERT INTO PERSON VALUES (101, 'Mahnaz', 25)";;

            try {
                Statement statement = conn.createStatement();
                int resultSet = statement.executeUpdate(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //String sql = "SELECT * FROM test";

            //Statement statement = connection.createStatement();
            //ResultSet resultSet = statement.executeQuery(sql);

            //int count = 0;

            //while (resultSet.next()) {
                //count++;

                //int ID = resultSet.getInt("ID");
                //String name = resultSet.getString("name");
                //out.println("Student #" + count + ": " + ID + ", " + name);
            //}

            //conn.close();
            //out.print("success");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void createRecord(Person p) {
        String sql = "INSERT INTO PERSON VALUES " + p.getId() + " " + p.getName() + " " + p.getAge();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //ResultSet resultSet = statement.executeQuery(sql);
    }
}
