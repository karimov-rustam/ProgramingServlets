package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

@WebServlet(name = "GlobalizedServletSearch", urlPatterns = "/GlobalizedServletSearch")
public class GlobalizedServletSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.resourceBundle", request.getLocale());

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + resourceBundle.getString("SearchTitle") + "</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<img src='" + resourceBundle.getString("Flag") + "'></img>");
        out.println("<p>" + resourceBundle.getString("PromptLbl") + "</p>");
        out.println("<form name='SearchForm' action='SearchResults'>");
        out.println("<p> <input type='search' name='txtSearch'/>");
        out.println("<p> <input type='submit' name='btnSubmit' value='" +
                resourceBundle.getString("BtnSubmit") + "' />");

        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}
