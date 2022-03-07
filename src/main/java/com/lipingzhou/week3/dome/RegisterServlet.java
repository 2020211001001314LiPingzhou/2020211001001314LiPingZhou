package com.lipingzhou.week3.dome;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<br> username :" + username);
        out.print("<br> password :" + password);
        out.print("<br> email :" + email);
        out.print("<br> gender :" + gender);
        out.print("<br> birth Date :" + birthday);
        out.close();
    }
}
