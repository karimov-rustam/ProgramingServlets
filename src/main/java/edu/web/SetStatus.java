package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by R.Karimov on 11/29/17.
 */
@WebServlet(name = "SetStatus", urlPatterns = "/SetStatus")
public class SetStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String siteName = "http://www.ya.ru";

//        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
//        response.setHeader("Location", siteName);

        response.sendRedirect(siteName);
    }
}
