package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by R.Karimov on 11/30/17.
 */
@WebServlet(name = "ErrorHandlerServlet", urlPatterns = "/ErrorHandlerServlet")
public class ErrorHandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
        String requestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Showing All Request Headers</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h3><font color=red>Error page: </font></h3>");
        out.println("<p>Status Code: " + statusCode + "</p>");
        out.println("<p>Error Message: " + errorMessage + "</p>");
        out.println("<p>Request URI: " + requestURI + "</p>");
        out.println("<p>Servlet Name: " + servletName + "</p>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
