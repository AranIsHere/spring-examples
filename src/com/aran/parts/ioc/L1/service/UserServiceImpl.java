package com.aran.parts.ioc.L1.service;

import com.aran.parts.ioc.L1.dao.UserDao;
import com.aran.parts.ioc.L1.dao.UserDaoImpl;
import com.aran.parts.ioc.L1.dao.UserDaoOracleImpl;

/**
 * @Author Aran
 * @Date 2020/9/4 8:50 下午
 */
public class UserServiceImpl implements UserService {

    /**
     * 通过new的方式，每次改变都要修改
     */
    // private UserDao userDao = new UserDaoOracleImpl();
    private UserDao userDao;



    //通过set方法实现注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
