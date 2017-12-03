package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        HttpSession session = request.getSession();
        session.setAttribute("guestName", guestName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Greetings</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>Welcome " + guestName + "</p>");

        out.println("<form name='frm' action='Preview' method='post'>");
        out.println("<p>Enter Email: </p>");
        out.println("<p><input type='email' name='email'/></p>");
        out.println("<p><input type='submit' values='Show Preview' name='btnPreview'/></p>");
        out.println("</form>");




        out.println("</body>");
        out.println("</html>");
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
