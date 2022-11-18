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
    public Connection start() {
        try {
            Class.forName("org.h2.Driver");
            //String jdbcURL = "jdbc:h2:tcp://localhost/~/test1";
            //String username = "sa";
            //String password = "";

            //Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            conn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to H2 embedded database.");


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
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void createRecord(Person per) {
        int id = per.getId();
        String name = per.getName();
        int age = per.getAge();
        String sql = "INSERT INTO PERSON(ID, NAME, AGE)  VALUES( " + id + ", " + name + ", " + age + " )";

        try {
            Statement statement = conn.createStatement();
            int resultSet = statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
