package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProgressServlet", urlPatterns = {"/ProgressServlet"})
public class ProgressServlet extends HttpServlet {
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
        out.println("<title>Progress Servlet</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>Entering doGet(), Thread Name: " + Thread.currentThread().getName() + "</p>");
        out.println("<progress id='progress' max='100'> </progress>");
        int i = 0;
        while (i <= 100) {
            out.println("<script>document.getElementById('progress').value= '" + i++ + "';</script>");
            out.flush();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        out.println("<p>Completed the long running task...</p>");
        out.println("<p>Exiting doGet(), Thread Name: " + Thread.currentThread().getName() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
