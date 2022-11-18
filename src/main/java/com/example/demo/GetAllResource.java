package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name="GetAll", urlPatterns = "/All")
public class GetAllResource extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            Connection c1 = ConnToDB.getInstance().start();
            Statement statement = c1.createStatement();
            Map<Integer, Person> allPersons = new LinkedHashMap<Integer, Person>();
            String sql="SELECT * FROM person";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                out.println(rs);
            }

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
