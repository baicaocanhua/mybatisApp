package com.maimai.mybatisApp;

import com.maimai.mybatisApp.service.Uservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * https://www.toutiao.com/a6628866450289328644/
 */
public class CglibTest {
    @Test
    public void run(){
        Uservice target=new Uservice();
        MyCglib myCglib=new MyCglib(target);
        Uservice uservice=myCglib.MyCglibCreator();
        System.out.println(uservice.doFirst());
        uservice.doSecond();
    }
}
