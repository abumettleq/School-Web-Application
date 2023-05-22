package com.example.demo.Filter;

import com.example.demo.Entity.UserType;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter(filterName = "SisAuthFilter", urlPatterns = { "http://localhost:8080/sis", "http://localhost:8080/sis/*" })
public class SisAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user_id") != null && session.getAttribute("userObject") != null && ((UserType)session.getAttribute("user_type")) == UserType.Student);

        if (request.getRequestURI().startsWith(request.getContextPath() + "/sis/") && !isLoggedIn) {
            session.removeAttribute("user_id");
            session.removeAttribute("user_type");
            response.sendRedirect("http://localhost:8080/login");
        } else {
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
