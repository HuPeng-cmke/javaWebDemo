package com.servlet.controller;

import com.entity.Manager;
import com.service.ManagerService;
import com.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginMgrController",value = "/loginManager")
public class LoginMgrController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //收参
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String inputVcode=request.getParameter("inputVcode");
        String codes=(String)request.getSession().getAttribute("codes");
        if(!inputVcode.isEmpty()&&inputVcode.equalsIgnoreCase(codes)) {
            //调用业务方法
            ManagerService managerService = new ManagerServiceImpl();
            Manager manager = managerService.login(username, password);
            //处理结果
            if (manager != null) {
                HttpSession session = request.getSession();
                session.setAttribute("manager", manager);
                response.sendRedirect("/javaWebDemo_war_exploded/Showallcontroller");


            } else {
                response.sendRedirect("/javaWebDemo_war_exploded/loginManager.html");

            }
        }else
        {
            response.sendRedirect("/javaWebDemo_war_exploded/loginManager.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
