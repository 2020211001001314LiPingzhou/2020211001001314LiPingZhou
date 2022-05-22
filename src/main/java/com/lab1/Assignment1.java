package com.lab1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/assignment1")
public class Assignment1 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        int count = 0;
        getServletContext().setAttribute("count", count);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I Am from default constructor");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Integer count = (Integer) getServletContext().getAttribute("count");
        count++;
        getServletContext().setAttribute("count", count);
        out.println("<h2>Since loading, this servlet has been accessed " +  count + " time.</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
