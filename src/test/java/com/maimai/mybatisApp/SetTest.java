package com.maimai.mybatisApp;

import com.maimai.mybatisApp.Bean.Person1;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SetTest {

    class User {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }

    private Logger logger = LoggerFactory.getLogger(SetTest.class);

    @Test
    public void run() {
        logger.info("setTest");

        User u1 = new User();
        u1.setName("maimai");

        User u2 = new User();
        u2.setName("maimai");

        Set<User> set = new HashSet<>();

        set.add(u1);
        set.add(u2);
        logger.info("" + set.size());
        for (User u : set
                ) {
            logger.info(u.getName());

        }
    }

    @Test
    public void describeTest() {
        logger.info("11111");
        Person1 p = new Person1();
        p.setName("Akili");
        p.setSex(1);
        p.setAge(24);
        p.setSchool(null);
        p.setHobby(new String[]{"摄影", "旅行", "家居", "做饭"});
        List list = new ArrayList();
        list.add("北京");
        list.add("深圳");
        list.add("深圳");
        list.add("广州");
        p.setPlace(list);


        Map<String, String> A = new HashMap<>();
        Map<String, Object> B = new HashMap<>();
        try {
            A = BeanUtils.describe(p);
        } catch (Exception e) {
            return;
        }
        try {
            B = PropertyUtils.describe(p);
        } catch (Exception e) {
            return;
        }


        for (Map.Entry<String, String> entry : A.entrySet()) {

            logger.info("A----key:{},value:{}", entry.getKey(), entry.getValue());

        }
        for (Map.Entry<String, Object> entry : B.entrySet()) {

            logger.info("B----key:{},value:{}", entry.getKey(), entry.getValue());

        }
    }
}


