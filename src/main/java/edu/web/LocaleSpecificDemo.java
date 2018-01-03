package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "LocaleSpecificDemo", urlPatterns = "/LocaleSpecificDemo")
public class LocaleSpecificDemo extends HttpServlet {
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

        long number = 5000_000L;
        NumberFormat numberFormatDefault = NumberFormat.getInstance();
        out.println("<p>Number Format using Default Locale: " + numberFormatDefault.format(number) + "</p>");

        NumberFormat numberFormatLocale = NumberFormat.getInstance(Locale.FRENCH);
        out.println("<p>Number Format using French Locale: " + numberFormatLocale.format(number) + "</p>");

        NumberFormat numberFormatDefaultCurrency = NumberFormat.getCurrencyInstance();
        out.println("<p>Currency Format using Default Locale: " + numberFormatDefaultCurrency.format(number) + "</p>");

        NumberFormat numberFormatLocalCurrency = NumberFormat.getCurrencyInstance(Locale.UK);
        out.println("<p>Currency Format using UK Locale: " + numberFormatLocalCurrency.format(number) + "</p>");

        Date currentDate = new Date();

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
        out.println("<p>Date Format using in French Locale: " + dateFormat.format(currentDate) + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}
