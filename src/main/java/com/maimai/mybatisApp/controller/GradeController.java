package com.maimai.mybatisApp.controller;

import org.slf4j.Logger;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageHelper;
import com.maimai.mybatisApp.Bean.Grade;
import com.maimai.mybatisApp.Bean.Person;
import com.maimai.mybatisApp.service.GradeService;
import io.swagger.annotations.*;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by maimai on 2018-02-05.
 */
@RestController
@Api(value = "1111",tags = "标签",produces = "生产者",consumes = "消费者",protocols = "协议",description = "描述")
public class GradeController {

    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(GradeController.class);

    @Resource
    private GradeService gradeService;
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "name", value = "用户name", required = true, dataType = "String", paramType = "path")
    @RequestMapping("/getByGradeNm")
    public List<Grade> getByGradeNm(String name){
        return gradeService.getByGradeNm(name);
    }

    @RequestMapping("/getByGradeNm2")
    public List<Grade> getByGradeNm2(String name, int pageIndex, int pageSize){
        PageHelper.startPage(pageIndex,pageSize);  //显示第一页2条数据
        return gradeService.getByGradeNm(name);
    }
    @Value("${maimai.name}")
    private  String name;
    @RequestMapping(value ="api/getName", method = {RequestMethod.GET,RequestMethod.PATCH})
    @ResponseBody()

    public String getName(){
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        return name;
    }


    @ApiOperation(value = "网点挂靠", notes = "嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @ResponseBody
    @RequestMapping(value = "api/change_rentalshop", method = {RequestMethod.PUT,RequestMethod.PATCH})
    public ModelMap changeRentalShop(@RequestBody Person parameter)
            throws Exception {
        ModelMap map = new ModelMap();
        map.addAttribute("网点挂靠", new Date());

        return map;
    }
}
