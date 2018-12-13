package com.maimai.mybatisApp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MaiAspect {
   @Pointcut("@annotation(com.maimai.mybatisApp.annotation.Mai)")
    public void mai(){

    }
    @Before("mai()")
    public void maimaiBefore(){
        System.out.println("maimaibefoe");
    }

}
