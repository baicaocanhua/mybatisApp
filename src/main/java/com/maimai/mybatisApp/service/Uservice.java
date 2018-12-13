package com.maimai.mybatisApp.service;

/**
 * 测试 cglib动态代理
 * @author baica
 */
public class Uservice {
    /**
     * doFirst
     *
     * @return
     */

    public String doFirst() {
        System.out.println("执行了doFirrst()方法");
        return "iloveyou";
    }

    /**
     * doSecond
     *
     * @return
     */
    public void doSecond() {
        System.out.println("执行了doSecond()方法");
    }
}
