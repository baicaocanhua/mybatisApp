package com.maimai.mybatisApp.service.impl;

import com.maimai.mybatisApp.service.UserService;

/**
 * @author baica
 */
public class UserServiceImpl implements UserService {
    /**
     * doFirst
     *
     * @return
     */
    @Override
    public String doFirst() {
        System.out.println("执行了doFirrst()方法");
        return "iloveyou";
    }

    /**
     * doSecond
     *
     * @return
     */
    @Override
    public void doSecond() {
        System.out.println("执行了doSecond()方法");
    }
}
