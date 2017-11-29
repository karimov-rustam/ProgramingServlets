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
@WebServlet("/LargeServletPage")
public class LargeServletPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out;
        if (GzipUtility.isGzipSupported(request) && !GzipUtility.isGsipDisabled(request)) {
            out = GzipUtility.getGzipWriter(response);
            response.setHeader("Content-Encoding", "gzip");
        } else {
            out = response.getWriter();
        }
//        out = response.getWriter();

        String dummyLine = "Simply dummy text";

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Showing All Request Headers</title>");
        out.println("</head>");
        out.println("<body>");

        for (int i = 0; i < 25000; i++) {
            out.println(dummyLine + "</br>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
