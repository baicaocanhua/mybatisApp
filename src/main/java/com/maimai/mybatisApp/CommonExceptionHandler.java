package com.maimai.mybatisApp;

import com.maimai.mybatisApp.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    /**
     *  拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class,RuntimeException.class})
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", "9999");
        result.put("respMsg", e.getMessage());
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return result;
    }
    /**
     * 拦截 CommonException 的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(CommonException ex){
        log.info("CommonException：{}({})",ex.getErrorMessage(), ex.getErrorCode());
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", ex.getErrorCode());
        result.put("respMsg", ex.getErrorMessage());
        return result;
    }
}
