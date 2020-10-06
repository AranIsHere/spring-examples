package com.aran.myTest;

import com.aran.parts.ioc.L1.dao.UserDaoImpl;
import com.aran.parts.ioc.L1.dao.UserDaoOracleImpl;
import com.aran.parts.ioc.L1.service.UserService;
import com.aran.parts.ioc.L1.service.UserServiceImpl;

/**
 * @Author Aran
 * @Date 2020/9/4 8:53 下午
 */
public class UserTest {
    public static void main(String[] args) {
        //用户实际直接调用的是业务层，而不是dao层
        UserService userService = new UserServiceImpl();
       ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
