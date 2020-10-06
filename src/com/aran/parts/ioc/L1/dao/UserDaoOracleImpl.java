package com.aran.parts.ioc.L1.dao;

/**
 * @Author Aran
 * @Date 2020/9/4 9:16 下午
 */
public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("获取Oracle中的数据");
    }
}
