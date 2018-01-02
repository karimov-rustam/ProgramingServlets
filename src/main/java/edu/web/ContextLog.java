package edu.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by R.Karimov on 12/17/17.
 */
@WebServlet(urlPatterns = "/ContextLog", name = "ContextLog")
public class ContextLog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getParameter("param");
        ServletContext context = getServletContext();
        if (param == null || param.equals("")) {
            context.log("No Message Recieded", new IllegalStateException("Missing Parameter"));
        } else {
            context.log("Visitor's Message: " + param);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet debugging using message logging</title>");
        out.println("</head>");
        out.println("<body>");

        context.log("Generating the body for the response");

        out.println("<h3>Message logging demo</h3>");
        out.println("<p>Message Received: " + param + "</p>");

        context.log("Complete Generating the Response");

        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
