package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "HelloAnnotations",
        urlPatterns = {"/HelloAnnotations", "/WebServletAnnotationDemo"},
        description = "Demo: @WebServlet Annotation",
        initParams = {
                @WebInitParam(name="user", value="value1 "),
                @WebInitParam(name="email", value="email@test")})
public class HelloAnnotations extends HttpServlet {
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
        out.println("<title>Providing Servlet Metadata using Annotations</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Annotations demo</h3>");

        String ename = getServletConfig().getInitParameter("user");
        String email = getServletConfig().getInitParameter("email");

        out.println("<p>Name: " + ename + "</p>");
        out.println("<p>Email: " + email + "</p>");


        out.println("</body>");
        out.println("</html>");
    }
}
