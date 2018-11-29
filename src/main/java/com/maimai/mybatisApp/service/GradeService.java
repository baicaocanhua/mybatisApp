package com.maimai.mybatisApp.service;

import com.maimai.mybatisApp.Bean.Grade;
import com.maimai.mybatisApp.dao.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maimai on 2018-02-05.
 * @author baica
 */
@Service
public class GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    public List<Grade> getByGradeNm(String name){
        return gradeMapper.getByGradeNm(name);
    }
}
