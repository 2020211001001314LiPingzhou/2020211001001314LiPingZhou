package com.lab2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

public class LiPingzhouFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LiPingzhouFilter-->before chain");
        chain.doFilter(request, response);
        System.out.println("LiPingzhouFilter-->after chain");
    }
}
