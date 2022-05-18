package com.lipingzhou.controller;

import com.lipingzhou.dao.OrderDao;
import com.lipingzhou.dao.UserDao;
import com.lipingzhou.model.Order;
import com.lipingzhou.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user")!=null){
            User user = (User) session.getAttribute("user");
            int userId = user.getId();
            request.setAttribute("user", user);
            OrderDao orderDao = new OrderDao();
            List<Order> orderList = orderDao.findByUserId(con, userId);
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("/WEB-INF/views/accountDetails.jsp").forward(request, response);
        }else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
