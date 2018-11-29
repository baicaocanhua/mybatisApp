package com.maimai.mybatisApp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.util.Map;

@EnableTransactionManagement()
@SpringBootApplication
@EnableSwagger2
//@MapperScan("com.maimai.mybatisApp.dao")
/**
 *
 */
public class MybatisAppApplication extends SpringBootServletInitializer implements CommandLineRunner {
    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(MybatisAppApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);
    }


}
