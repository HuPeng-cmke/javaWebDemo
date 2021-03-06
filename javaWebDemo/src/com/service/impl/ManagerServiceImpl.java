package com.service.impl;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.impl.ManagerDaoImpl;
import com.service.ManagerService;
import com.utils.DbUtils;

public class ManagerServiceImpl implements ManagerService {
        private ManagerDao managerDao=new ManagerDaoImpl();
    @Override
    public Manager login(String username, String password) {
        Manager manager=null;
       try {
           DbUtils.begin();
           Manager temp = managerDao.select(username);
           if (temp != null) {
               if (temp.getPassword().equals(password)) {
                   manager = temp;
               }

           }

       }catch (Exception e){
           DbUtils.rollback();
           e.printStackTrace();
       }

        return manager;
    }
}
