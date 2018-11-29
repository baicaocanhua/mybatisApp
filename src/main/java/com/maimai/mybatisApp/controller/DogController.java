package com.maimai.mybatisApp.controller;

import com.maimai.mybatisApp.Bean.Dog;
import com.maimai.mybatisApp.service.DogService;
import net.sf.jsqlparser.statement.update.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baica
 */
@RestController
@RequestMapping(value = "/dogs", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class DogController {

    @Autowired
    private DogService dogService;

    @PatchMapping(value = "")
    Dog update(@Validated(Update.class) @RequestBody Dog dog){
        return dogService.update(dog);
    }
}
