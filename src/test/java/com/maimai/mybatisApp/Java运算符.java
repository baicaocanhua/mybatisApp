package com.maimai.mybatisApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by maimai on 2018-04-12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Java运算符 {
    @Test
    public void test() {
        int a = 5;
        int b = 5;
        int aa = a++;
        int bb = ++b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(aa);
        System.out.println(bb);

        Integer c=10;
        System.out.println(a+c);

    }
}
