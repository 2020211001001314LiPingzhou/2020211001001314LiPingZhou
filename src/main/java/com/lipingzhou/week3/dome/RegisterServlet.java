package com.lipingzhou.week3.dome;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public void init() throws ServletException {
        /*
        ServletContext application = getServletContext();
        String driver = application.getInitParameter("driver");
        String url = application.getInitParameter("url");
        String username = application.getInitParameter("Username");
        String password = application.getInitParameter("Password");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
         */
        conn = (Connection) getServletContext().getAttribute("conn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");

        //response.setContentType("text/html");
        //PrintWriter out = response.getWriter();

        try {
            String sql1 = "insert into Usertable(username, password, email, gender, birthdate) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setDate(5, Date.valueOf(birthday));
            int num = ps.executeUpdate();
            System.out.println("num-->" + num);

            /*
            String sql2 = "select * from Usertable";
            ps = conn.prepareStatement(sql2);
            rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString("id");
                String username2 = rs.getString("username");
                String password2 = rs.getString("password");
                String email2 = rs.getString("email");
                String gender2 = rs.getString("gender");
                String birthday2 = rs.getString("birthdate");

            }
             */
            response.sendRedirect(request.getContextPath() + "/login.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
