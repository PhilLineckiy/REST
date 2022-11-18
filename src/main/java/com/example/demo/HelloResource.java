package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import org.json.JSONObject;

import javax.ws.rs.Path;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//@Path("/hello-world")
@WebServlet(name="hello",urlPatterns={"/hello"})
public class HelloResource extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        out.println("Hello World");
        Person p = PersonStore.getInstance().getPerson(Integer.parseInt(id));
        if(p != null) {
            String json = "{\n";
            json += "\"name\": " + JSONObject.quote(p.getName()) + ",\n";
            json += "\"age\": " + JSONObject.quote(String.valueOf(p.getAge())) + ",\n";
            json += "\"id\": " + p.getId() + "\n";
            json += "}";
            out.println(json);
        }
        if (request.getParameterMap().containsKey("name")) {
            String name = request.getParameter("name");
            out.println(name);
        }
        out.println(p.getName());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter myResponse = response.getWriter();
        String message = "This is your response from a POST call. <br> The response is a Java Servlet !";
        myResponse.println(message);

        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));
        Integer id = Integer.valueOf(request.getParameter("id"));
        Person p = new Person(name, age, id);
        myResponse.println(p.getName());

        PersonStore.getInstance().putPerson(p.getId(),p);
        ConnToDB.getInstance().start();
        ConnToDB.getInstance().createRecord(p);
    }
}