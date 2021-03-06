package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = {"/bs"})
public class res extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1111");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");


            String username=req.getParameter("username");
            String password=req.getParameter("password");
            resp.setContentType("text/html;charset=utf-8");

            PrintWriter printWriter=resp.getWriter();
            if(username.equals("张三")&&password.equals("123"))
            printWriter.println("登录成功");
            else printWriter.println("登录失败");



    }
}
