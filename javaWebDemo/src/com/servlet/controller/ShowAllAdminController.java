package com.servlet.controller;

import com.entity.Admin;
import com.entity.Manager;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/Showallcontroller")
public class ShowAllAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Manager manager=(Manager)session.getAttribute("manager");
        if(manager!=null) {
            AdminService adminService = new AdminServiceImpl();
            List<Admin> adminList = adminService.showAllAdmin();
            req.setAttribute("admins", adminList);
            req.getRequestDispatcher("/showAllJSP").forward(req, resp);
        }else{
            resp.sendRedirect("/javaWebDemo_war_exploded/loginManager.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
