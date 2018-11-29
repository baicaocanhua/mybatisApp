package com.maimai.mybatisApp.service;

import com.maimai.mybatisApp.Bean.Dog;
import com.maimai.mybatisApp.common.BSUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baica
 */
@Service
public class DogService {

    @Transactional
    public Dog update(Dog dog){

        // some database options

        // 模拟狗狗新名字与其他狗狗的名字冲突
        BSUtil.isTrue(false, "狗狗名字已经被使用了...");

        // update database dog info

        return dog;
    }

}
