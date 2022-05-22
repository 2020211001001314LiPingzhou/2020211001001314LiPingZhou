package com.lab2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/lab2/welcome.jsp")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginFilter--init()");
    }

    public void destroy() {
        System.out.println("LoginFilter--destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LoginFilter--doFilter()-- request before chain");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getSession(false) != null && req.getSession(false).getAttribute("user") != null){
            //req.getRequestDispatcher("/lab2/welcome.jsp").forward(req, res);
            chain.doFilter(request, response);
        }else {
            res.sendRedirect(req.getContextPath()+"/lab2/login.jsp");
        }
        System.out.println("LoginFilter--doFilter()-- response after chain");
    }
}
