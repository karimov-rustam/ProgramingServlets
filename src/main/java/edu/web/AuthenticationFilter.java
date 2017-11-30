package edu.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by R.Karimov on 11/30/17.
 */
@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    public void destroy() {
        System.out.println("destroy method is called in " + this.getClass().getName());
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        System.out.println("doFilter method is called in " + this.getClass().getName());

        String userName = req.getParameter("userName");
        String passwd = req.getParameter("passwd");
        String ipAddress = req.getRemoteAddr();

        if (userName.equals("psuser") && passwd.equals("psguest")) {
            System.out.println("User logged in " + ipAddress + " at " + new Date().toString());
            chain.doFilter(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");
            out.println("<h3>You are not authorized to access</h3>");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init method is called in " + this.getClass().getName());
    }

}
