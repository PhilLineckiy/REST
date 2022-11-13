package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Map;
import java.util.Set;

@WebServlet(name="getAll", urlPatterns = "/getAll")
public class GetAllServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Map<Integer, Person> allPersons = PersonStore.getInstance().getAll();
        //
        Set<Integer> ids = allPersons.keySet();
        for(Integer id : ids) {
            out.println(id + " " + allPersons.get(id).getName() + " " + allPersons.get(id).getAge());
            String json = "{\n";
            json += "\"name\": " + JSONObject.quote(allPersons.get(id).getName()) + ",\n";
            json += "\"age\": " + JSONObject.quote(String.valueOf(allPersons.get(id).getAge())) + ",\n";
            json += "\"id\": " + allPersons.get(id).getId() + "\n";
            json += "}";
            out.println(json);
        }
        //ConnToDB.getInstance().start();
        System.out.print("random string");
    }
}
