package com.maimai.mybatisApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by maimai on 2018-05-24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HashMapTest {
    private Logger logger = LoggerFactory.getLogger(HashMapTest.class);

    @Test
    public void run() {
        ArrayList<Hero> arrayList=new ArrayList<>();
        //初始化
        for (int i=0;i<3000000;i++){
            Hero hero=new Hero();
            String str=String.valueOf(Math.random()*9000+1000).substring(0,4);
            hero.setName("hero-"+str);
            arrayList.add(hero);
        }

        test(arrayList,"hero-5555");
        testHashMap(arrayList,"hero-5555");
    }

    private  void test(ArrayList<Hero> arrayList,String key){

        long timeBegin=System.currentTimeMillis();
        int count=0;
        for (Hero hero:arrayList){
            if(hero.getName().equals(key)){
                count++;
            }
        }
        long timeEnd=System.currentTimeMillis();
        System.out.println("\n没有使用HashMap：ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]，把名字叫做 hero-5555的所有对象找出来用时："+(timeEnd-timeBegin)+"毫秒;共有"+count+"个hero-5555");
    }

    private  void testHashMap(ArrayList<Hero> arrayList,String key){

        long timeBegin=System.currentTimeMillis();
        HashMap<String,ArrayList<Hero>> resultList=new HashMap<>();
        for (Hero hero:arrayList){
            if(resultList.get(hero.getName())!=null){
                ArrayList list=resultList.get(hero.getName());
                list.add(hero);
                resultList.put(hero.getName(),list);
            }else{
                ArrayList list=new ArrayList();
                list.add(hero);
                resultList.put(hero.getName(),list);
            }
        }
        long timeEnd=System.currentTimeMillis();
        System.out.println("使用HashMap：ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]，把名字叫做 hero-5555的所有对象找出来用时："+(timeEnd-timeBegin)+"毫秒;共有"+resultList.get(key).size()+"个hero-5555");
    }
}
