package edu.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * Created by R.Karimov on 11/29/17.
 */
class GzipUtility {

    static boolean isGzipSupported(HttpServletRequest request) {
        String encodings = request.getHeader("Accept-Encoding");
        return (encodings != null) && (encodings.contains("gzip"));
    }

    static boolean isGsipDisabled(HttpServletRequest request) {
        String flag = request.getParameter("disableGzip");
        return ((flag != null) && (!flag.equalsIgnoreCase("false")));
    }

    static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException {
        return (new PrintWriter(new GZIPOutputStream(response.getOutputStream())));
    }
}
