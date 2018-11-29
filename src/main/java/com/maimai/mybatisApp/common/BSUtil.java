package com.maimai.mybatisApp.common;

import com.maimai.mybatisApp.exception.BusinessException;

/**
 * @author baica
 */
public class BSUtil {
    public static void isTrue(boolean expression, String error){
        if(!expression) {
            throw new BusinessException(error);
        }
    }
}
