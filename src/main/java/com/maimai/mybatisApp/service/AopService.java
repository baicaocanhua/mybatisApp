package com.maimai.mybatisApp.service;

import com.maimai.mybatisApp.annotation.Mai;
import org.springframework.stereotype.Component;

@Component
public class AopService {
    @Mai
    public void aop(){
        System.out.println("aop");
    }
}
