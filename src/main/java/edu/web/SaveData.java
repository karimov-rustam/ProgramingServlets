package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by R.Karimov on 12/3/17.
 */
@WebServlet(name = "SaveData", urlPatterns = "/SaveData")
public class SaveData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String guestName = (String) session.getAttribute("guestName");
        String email = (String) session.getAttribute("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Preview</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h3>Guest Details</h3>");
        out.println("<p>Guest Name: " + guestName + "</p>");
        out.println("<p>Email: " + email + "</p>");

        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().append("Served at: ").append(request.getContextPath());

    }
}
