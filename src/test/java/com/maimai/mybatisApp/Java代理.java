package com.maimai.mybatisApp;

import com.maimai.mybatisApp.service.UserService;
import com.maimai.mybatisApp.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Java代理 {
    @Test
    public void test() {
        UserService target = new UserServiceImpl();
        UserService userService = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new Handler(target));
        System.out.println(userService.doFirst());
        userService.doSecond();
    }

    class Handler implements InvocationHandler {

        private UserService target;

        public Handler(UserService target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object invoke = method.invoke(target, args);
            if (invoke != null) {
                return invoke.toString().toUpperCase();
            }
            return null;
        }
    }

}
