package demo;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "DemoFilter", urlPatterns = { "*" }, asyncSupported = true)
public class DemoFilter extends HttpFilter {

    private static final Logger log = Logger.getLogger("DemoFilter");

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (Objects.isNull(request.getServletContext())) {
            log.info("Servlet Context was NULL");
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
