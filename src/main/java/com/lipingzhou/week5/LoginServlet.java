package com.lipingzhou.week5;

import com.lipingzhou.dao.UserDao;
import com.lipingzhou.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public void init() throws ServletException {
        /*
        super.init();
        ServletContext application = getServletConfig().getServletContext();
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

    // doGet用于跳转到登录页面，doPost用于验证处理登录信息。
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /*
        String sql = "Select * from usertable where username = ? and password = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()){
                //out.print("Login Success!!! <br>");
                //out.print("Welcome,"+ username +" <br>");

                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("gender", rs.getString("gender"));
                request.setAttribute("birthdate", rs.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request, response);

            }else{
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        UserDao userDao = new UserDao();
        try {
             User user = userDao.findByUsernamePassword(conn, username, password);
             if (user != null){
                 String rememberMe = request.getParameter("rememberMe");
                 if (rememberMe != null && "1".equals(rememberMe)){
                     Cookie usernameCookies = new Cookie("cUsername", user.getUsername());
                     Cookie passwordCookies = new Cookie("cPassword", user.getPassword());
                     Cookie rememberMeCookies = new Cookie("cRememberMe", rememberMe);

                     usernameCookies.setMaxAge(60*60*24*10);//ten day
                     passwordCookies.setMaxAge(60*60*24*10);
                     rememberMeCookies.setMaxAge(60*60*24*10);

                     response.addCookie(usernameCookies);
                     response.addCookie(passwordCookies);
                     response.addCookie(rememberMeCookies);

                 }

                 HttpSession session = request.getSession();
                 System.out.println("session id ------>" + session.getId());
                 session.setMaxInactiveInterval(60*60);//one hour
                 session.setAttribute("user", user);

                 request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
             }else {
                 request.setAttribute("message", "Username or Password Error!!!");
                 request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
             }
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
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
