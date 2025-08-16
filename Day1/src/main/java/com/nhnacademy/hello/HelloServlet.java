package com.nhnacademy.hello;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


@Slf4j
@WebServlet(
        name = "helloServlet",
        urlPatterns = "/hello",
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "title", value = "Mr."),
                @WebInitParam(name = "name", value = "franky")
        }
)
public class HelloServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String title = getServletConfig().getInitParameter("title");
        String name = getServletConfig().getInitParameter("name");

        if (Objects.isNull(title)) {
            title = "Mr.";
        }
        if (Objects.isNull(name)) {
            name = "marco";
        }

        resp.setCharacterEncoding("utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset='utf-8'>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>hello servlet!</h1>");
            writer.println("<h1>안녕 서블릿!</h1>");
            writer.printf("<h1>hello %s %s</h1>\n", title, name);
            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("before init!");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("before service!");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        log.info("before destroy!");
        super.destroy();
    }
}
