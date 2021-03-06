package com.dao;

import com.entity.Manager;

public interface ManagerDao {
    public Manager select(String username);
}
