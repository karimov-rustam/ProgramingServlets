package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by R.Karimov on 12/1/17.
 */
@WebServlet(name = "Preview", urlPatterns = "/Preview")
public class Preview extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String guestName = request.getParameter("guestName");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Preview</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h3>Please confirm your information</h3>");
        out.println("<p>Guest Name: " + guestName + "</p>");
        out.println("<p>Email: " + email + "</p>");

        out.println("<form name='frm' action='SaveData' method='post'>");
        out.println("<input type='hidden' name='guestName' value='" + guestName + "'/>");
        out.println("<input type='hidden' name='email' value='" + email + "'/>");
        out.println("<p><input type='submit' value='Save Data' name='btnSave'/>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
