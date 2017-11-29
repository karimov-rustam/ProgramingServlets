package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by R.Karimov on 11/29/17.
 */
@WebServlet(name = "ContentType", urlPatterns = "/ContentType")
public class ContentType extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/vnd.ms-excel");
        PrintWriter out = response.getWriter();

        out.println("Rno\tName\tMath\tPhys\tComputer Sc\tTotal");
        out.println("101\tSekhar\t90\t90\t90\t=SUM(B2:D2)");
        out.println("102\tSrinivasan\t95\t95\t95\t=SUM(B2:D2)");
    }
}
