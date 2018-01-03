package edu.web;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Log4jDemos", urlPatterns = "/Log4jDemos")
public class Log4jDemos extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Logger logger = Logger.getLogger(Log4jDemos.class);
        logger.info("Log Info: Entered the doGet Method for processing the request");

        response.setContentType("text/html");
        logger.info("Content type has been set to text/html");

        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Log4j Demo</title>");
        out.println("</head>");
        out.println("<body>");
        logger.info("Start the document creation");
        out.println("<p>Logger Name: " + logger.getName() + "</p>");

        String param = request.getParameter("param");
        if (param.equals("") || param.isEmpty()) {
            out.println("<p> Please provide the value for the Parameter</p>");
            logger.error("Error: Please provide the value for the Parameter");
        } else {
            out.println("<p>Page is requested by: " + param + "</p>");
            logger.warn("Log Message: Page is requested by " + param);
        }
        out.println("</body>");
        out.println("</html>");
//        out.close();

    }
}
