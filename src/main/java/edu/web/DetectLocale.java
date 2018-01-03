package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet(name = "DetectLocale", urlPatterns = "/DetectLocale")
public class DetectLocale extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Locale locale = request.getLocale();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String displayLanguage = locale.getDisplayLanguage();
        String displayCountry = locale.getDisplayCountry();
        String displayName = locale.getDisplayName();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Detecting Locale</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>Language: " + language + "</p>");
        out.println("<p>Display Language: " + displayLanguage + "</p>");
        out.println("<p>Country: " + country + "</p>");
        out.println("<p>Display Country: " + displayCountry + "</p>");
        out.println("<p>Display Name: " + displayName + "</p>");

        Locale[] aviableLocale = Locale.getAvailableLocales();

        for (Locale aLocale : aviableLocale) {
            out.println("<p>Name of Locale: " + aLocale.getDisplayName() + "</p>");
            out.println("<p>Language Code: " + aLocale.getLanguage() + "</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
