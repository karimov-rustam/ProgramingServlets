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
@WebServlet(name = "Step2", urlPatterns = "/Step2")
public class Step2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Greetings</title>");
        out.println("</head>");
        out.println("<body>");

        String queryString = "guestName=" + guestName + "&email=" + email;

        out.println("<a href='Preview?" + queryString + "'>Preview data</a> &nbsp;" +
                "<a href='SaveData?" + queryString + "'>Save Data</a>");

        out.println("</body>");
        out.println("</html>");
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
