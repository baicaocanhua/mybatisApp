package com.maimai.mybatisApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by maimai on 2018-05-22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class 多线程 {
    @Test
    public void test11() {
//      不同线程干同一件事
        SaleWindow sw = new SaleWindow();
        Thread t1 = new Thread(sw);
        Thread t2 = new Thread(sw);
        t1.setName("窗口A");
        t2.setName("窗口B");
        t1.start();
        t2.start();
    }


    public class SaleWindow implements Runnable {
        private int ticketCount = 10;

        @Override
        public void run() {
            // TODO Auto-generated method stub
//      多个窗口卖票
            for (int i = 0; i < 10; i++) {
                if (ticketCount > 0) {
                    //字符串拼接信息   变量+""  就可以拼接成字符串
                    System.out.println(Thread.currentThread().getName() + "卖出" + ticketCount + "张票");
                    ticketCount--;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
//                  e.printStackTrace();
                    }
                }
            }
        }

    }
}



