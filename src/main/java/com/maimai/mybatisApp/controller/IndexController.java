package com.maimai.mybatisApp.controller;

import com.maimai.mybatisApp.Bean.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by maimai on 2018-02-05.
 */
@Controller
public class IndexController {


    @GetMapping("/")
    @RequestMapping("/")
//    @ResponseBody()
    public String index(Model model) {
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("詹凡", 17);
        Person p2 = new Person("卢星冉", 18);
        Person p3 = new Person("李英杰", 30);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("people", people);
        return "mozhua";
    }

    @RequestMapping("/index")
    public String index2(Model model) {
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("zhangsan", 11);
        Person p2 = new Person("lisi", 22);
        Person p3 = new Person("wangwu", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }

    @Value("${name}")
    private String name;

    @RequestMapping("/default")
    @ResponseBody
    public String name() {
        return name;
    }

    @RequestMapping("/learn")
    public String learn(Model model) {
        HashMap<String, String> learnList =
        new HashMap(16) {{
            put("Spring Boot 配置加载顺序详解","https://www.jianshu.com/p/cd000bbf211a");
            put("new HashMap(){{put(\"id\", \"001\");}}的解释", "https://blog.csdn.net/luman1991/article/details/53034602");
            put("正则表达式真的很骚，可惜你不会写！！！", "https://juejin.im/post/5b96a8e2e51d450e6a2de115");
            put("Spring中注解大全和应用","https://juejin.im/post/5b8ac1c76fb9a019da27d910");
            put("谈谈java中遍历Map的几种方法","https://www.cnblogs.com/zhaoguhong/p/7074597.html");
            put("java中HashMap的用法","http://www.cnblogs.com/panxuejun/p/5958875.html");
            put("你的like语句为啥没索引？","https://juejin.im/post/5bbd453ef265da0abc2b84ca");
            put("Spring MVC的RequestContextHolder使用误区","https://www.cnblogs.com/softidea/p/6125087.html");
        }};
        model.addAttribute("learnList", learnList);
        model.addAttribute("allName", "我的学习地址");
        return "learn";
    }
}
