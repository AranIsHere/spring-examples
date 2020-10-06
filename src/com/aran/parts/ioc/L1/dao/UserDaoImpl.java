package com.aran.parts.ioc.L1.dao;

/**
 * @Author Aran
 * @Date 2020/9/4 8:47 下午
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("默认获取用户的数据");
    }
}
