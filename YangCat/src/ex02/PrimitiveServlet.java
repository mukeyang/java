package ex02;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by CS on 2018/5/18.
 */
public class PrimitiveServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("from servive");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("hello");
        writer.println("yang");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
