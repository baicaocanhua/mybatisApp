package com.maimai.mybatisApp.dao;

import com.maimai.mybatisApp.Bean.Grade;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by maimai on 2018-02-05.
 */


@Mapper
public interface GradeMapper {
    /**
     * getByGradeNm
     *
     * @param name
     * @return
     */
    List<Grade> getByGradeNm(String name);

    /**
     * save
     *
     * @param grade
     */
    void save(Grade grade);


}



