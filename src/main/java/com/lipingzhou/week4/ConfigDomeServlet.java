package com.lipingzhou.week4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Config", value="/config",
        initParams = {
                @WebInitParam(name="name", value="LiPingzhou"),
                @WebInitParam(name="studentId", value="2020211001001314")
} )
public class ConfigDomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取参数
        String name = getServletConfig().getInitParameter("name");
        String id = getServletConfig().getInitParameter("studentId");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("name : " + name + "<br>");
        out.print("studentid : " + id + "<br>");
    }
}
