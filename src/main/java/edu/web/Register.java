package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by R.Karimov on 11/25/17.
 */
@WebServlet(name = "Register", urlPatterns = "/Register")
public class Register  extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("userName");
        String passwd = request.getParameter("passwd");
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobbies");
        String country = request.getParameter("country");
        String[] languages = request.getParameterValues("languages");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<div>");
        out.println("<p>User name: " + username + "</p>");
        out.println("<p>Password: " + passwd + "</p>");
        out.println("<p>Sex: " + gender + "</p>");
        out.println("<p>Hobbies: </p>");

        for (String hobby : hobbies) {
            out.println(hobby + "<br>");
        }

        out.println("<p>Country: " + country + "</p>");

        out.println("<p>Languages known: </p>");
        for (String lang : languages) {
            out.println(lang + "<br>");
        }

        }
    }
