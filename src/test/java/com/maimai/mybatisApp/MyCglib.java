package com.maimai.mybatisApp;

import com.maimai.mybatisApp.service.Uservice;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglib implements MethodInterceptor {

    private  Uservice target;
    public MyCglib(Uservice target){
        this.target=target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object invoke=method.invoke(target,objects);
        if (invoke != null) {
            return invoke.toString().toUpperCase();
        }
        return invoke;
    }

    public Uservice MyCglibCreator(){
        Enhancer enhancer=new Enhancer();
        //指定父类，即目标类 cglib原理 子类增强父类
        enhancer.setSuperclass(Uservice.class);
        enhancer.setCallback(this);
        return (Uservice)enhancer.create();
    }
}
