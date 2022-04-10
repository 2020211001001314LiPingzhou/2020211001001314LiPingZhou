package com.lipingzhou.controller;

import com.lipingzhou.dao.UserDao;
import com.lipingzhou.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");

        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        // 这里的Date.valueOf()是java.sql.Date类的方法，而User中的Date类是java.util.Date
        // java.sql.Date类是继承java.util.Date类的，等于这里使用了向上转型
        user.setBirthDate(Date.valueOf(birthday));

        UserDao userDao = new UserDao();
        ServletContext application = getServletContext();
        Connection conn = (Connection) application.getAttribute("conn");
        int num = 0;
        try {
            num = userDao.updateUser(conn, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (num != 0){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
        }else {
            request.setAttribute("message", "Update fail!");
            request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
        }
    }
}
