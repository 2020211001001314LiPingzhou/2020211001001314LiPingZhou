package com.lipingzhou.lab1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myDear")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String aClass = request.getParameter("aclass");
        String id = request.getParameter("id");
        String submit = request.getParameter("submit");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>MyDearJsp</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("name:"+name+"<br>");
        out.println("submit:"+submit+"<br>");
        out.println("class:"+aClass+"<br>");
        out.println("id:"+id+"<br>");
        out.println("</body>");
        out.println("</html>");
    }
}
