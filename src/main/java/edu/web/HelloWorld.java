package edu.web;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by R.Karimov on 11/22/17.
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends GenericServlet{
    private final static long serialVersionUID = 1L;

    public HelloWorld() {
        super();
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Java EE: Programming Servlets");
    }
}
