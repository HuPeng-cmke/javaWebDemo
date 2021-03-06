package com.impl;

import com.dao.AdminDao;
import com.entity.Admin;
import com.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private QueryRunner queryRunner =new QueryRunner();

    @Override
    public int insert(Admin admin) {
        return 0;
    }

    @Override
    public int delete(String username) {
        return 0;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public Admin select(String username) {
        Admin admin= null;
        try {
            admin = queryRunner.query(DbUtils.getConnection(),"select * from admin where username=?;",new BeanHandler<Admin>(Admin.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    @Override
    public List<Admin> selectAll() {
        try {
            List<Admin> admins=queryRunner.query(DbUtils.getConnection(),"select * from admin",new BeanListHandler<Admin>(Admin.class));
            return admins;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
