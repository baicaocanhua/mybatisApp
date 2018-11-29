package com.maimai.mybatisApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by maimai on 2018-04-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class 数组 {
    @Test
    public void a() {
        System.out.println();
        int num[][] = new int[10][10];
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                num[i][j] = ++count;
                System.out.printf("%3d", count);
            }
            System.out.println();
        }
    }
}
