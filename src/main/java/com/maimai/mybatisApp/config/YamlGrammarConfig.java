package com.maimai.mybatisApp.config;

import com.maimai.mybatisApp.Bean.Position;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by maimai on 2018-04-09.
 */
@Configuration
@PropertySource(value={"classpath:yamlgrammar.yml"})
@ConfigurationProperties(prefix = "userinfo")
public class YamlGrammarConfig {

    private String account;
    private Integer age;
    private Boolean active;
    private Date createdDate;
    private Map<String, Object> map;
    private List<Object> list;
    private Position position;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "account='" + account + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", createdDate=" + createdDate +
                ", map=" + map +
                ", list=" + list +
                ", position=" + position +
                '}';
    }
}
