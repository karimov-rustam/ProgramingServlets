package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by R.Karimov on 11/29/17.
 */
@WebServlet(name = "AutoPageRefresh", urlPatterns = "/AutoPageRefresh")
public class AutoPageRefresh extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setIntHeader("Refresh", 3);

        Date currentDate = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E dd-MM-yyyy 'at' hh:mm:ss a");
        String currentDateAndTime = ft.format(currentDate);

        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Auto Refresh using HTTP Refresh Header</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>Page was Last Refreshed at:" + currentDateAndTime + "</p>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
