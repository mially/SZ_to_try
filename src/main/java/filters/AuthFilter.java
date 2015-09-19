package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    private FilterConfig filterConfig;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;


        String loginURL = httpRequest.getContextPath() + "/login.jsp";
        String registerURL = httpRequest.getContextPath() + "/register.jsp";
        String registerServletURL = httpRequest.getContextPath() + "/register";
        String loginServletURL = httpRequest.getContextPath() + "/login";


        if (httpRequest.getRequestURI().equals(loginURL)
                || httpRequest.getRequestURI().equals(registerURL)
                || httpRequest.getRequestURI().equals(loginServletURL)
                || httpRequest.getRequestURI().equals(registerServletURL)
                || httpRequest.getSession().getAttribute("username") != null) {
            filterChain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(loginURL);
        }
    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {}
}
