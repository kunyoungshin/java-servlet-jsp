package com.nhnacademy.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet(name = "multiServlet", urlPatterns = "/multi", loadOnStartup = 1)
public class MultiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] values = req.getParameterValues("class");
        String url = getServletContext().getInitParameter("url");
        try (PrintWriter out = resp.getWriter()) {
            out.println(String.join(",", values));
            out.printf("url:%s\n", url);
        } catch (IOException ex) {
            log.info(ex.getMessage());
        }
    }
}