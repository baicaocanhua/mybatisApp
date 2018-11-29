package com.maimai.mybatisApp.controller;

import com.maimai.mybatisApp.Bean.DemoReq;
import com.maimai.mybatisApp.common.ValidatorUtil;
import com.maimai.mybatisApp.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.CompletionException;

@RestController
@Slf4j
public class DemoController {
    @GetMapping("/demo/valid")
    public String demoValid(@Valid DemoReq req) {
        return req.getCode() + "," + req.getName();
    }

    @GetMapping("/demo/valid2")
    public String demoValid2(DemoReq req) throws CommonException {
        //手动校验
        ValidatorUtil.validate(req);
        return req.getCode() + "," + req.getName();
    }


    @GetMapping(value = "/demo/user")
    public String create(@Valid DemoReq req, BindingResult errors) throws CommonException {
        aa(errors);


        log.info("获取到的参数信息为：" + req);
        String info = "新增用户成功";
        return info;
    }

    public String getStackTraceText(Throwable t) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            return sw.toString();
        } catch (Exception e) {
        }
        return "";
    }

    public void aa(BindingResult errors) throws CommonException {
        if (errors.hasErrors()) {

            List<ObjectError> list = errors.getAllErrors();
            StringBuilder sb = new StringBuilder();
            for (ObjectError error : list) {
                FieldError fieldError = (FieldError) error;
                sb.append(fieldError.getDefaultMessage());
            }
            throw new CommonException("1",sb.toString());
        }
    }
}

