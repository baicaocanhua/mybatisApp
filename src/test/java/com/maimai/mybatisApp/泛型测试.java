package com.maimai.mybatisApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by maimai on 2018-04-11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class 泛型测试 {
    @Test
    public void run() {
        MaiMai<String> mai=new MaiMai<>();
        mai.setObj(new String("钟福成"));
        String s = mai.getObj();
        System.out.println(s);
        System.out.println(123);
        mai.show(222);
    }
    public class MaiMai<T> {
        private T obj;

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        //定义泛型方法..
        public <H> void show(H t) {
            System.out.println(t);

        }
    }
}


