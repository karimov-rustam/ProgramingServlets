package edu.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by R.Karimov on 12/4/17.
 */
@WebServlet(name = "UploadServlet", urlPatterns = "/UploadServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class UploadServlet extends HttpServlet {

    private static final String SAVE_DIR = "UploadFiles";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>File Upload Results</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h3>File Upload Successfully...</h3>");

        out.println("</body>");
        out.println("</html>");
        out.close();

    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 1, s.length() - 1);
            }
        }
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("GET method can't handle this request");

    }
}
