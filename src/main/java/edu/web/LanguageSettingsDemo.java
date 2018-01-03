package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet(name = "LanguageSettingsDemo", urlPatterns = "/LanguageSettingsDemo")
public class LanguageSettingsDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Detecting Locale</title>");
        out.println("</head>");
        out.println("<body>");

        Locale locale = new Locale("fr");
        out.println("<p>Language Set using Single Parameter: " + locale + "</p>");

        Locale locale2 = new Locale("fr", "CANADA");
        out.println("<p>Language Set using two Parameters: " + locale2 + "</p>");

        Locale localeFromBuilder = new Locale.Builder().setLanguage("en").setRegion("GB").build();
        out.println("<p>Language Set using Locale Builder: " + localeFromBuilder + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}
