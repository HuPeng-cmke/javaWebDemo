package com.service.impl;

import com.dao.AdminDao;
import com.entity.Admin;
import com.impl.AdminDaoImpl;
import com.service.AdminService;
import com.utils.DbUtils;

import java.util.List;

public class AdminServiceImpl implements AdminService {
        private AdminDao adminDao=new AdminDaoImpl();

    @Override
    public Admin login(String username, String password) {
        Admin result=null;
        try {
            DbUtils.begin();
            Admin admin = adminDao.select(username);
            if (admin != null) {
                if (admin.getPassword().equals(password)) {
                    result = admin;
                }
            }
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Admin> showAllAdmin() {
        List<Admin> admins=null;
        try {
            DbUtils.begin();
            admins=adminDao.selectAll();
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollback();
            e.printStackTrace();
        }
        return admins;
    }
}
