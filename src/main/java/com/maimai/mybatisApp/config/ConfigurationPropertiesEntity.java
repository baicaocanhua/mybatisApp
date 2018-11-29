package com.maimai.mybatisApp.config;

import org.hibernate.validator.constraints.Email;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

/**
 * Created by maimai on 2018-04-09.
 */
@Component
@ConfigurationProperties(prefix = "itdragon")
@Validated
public class ConfigurationPropertiesEntity {
    /**
     * 解析成功，支持松散匹配属性
     */
    private String nickName;
    @Email
    private String email;
    //    @Email                      // 解析失败，数据校验成功：BindValidationException: Binding validation errors on itdragon
    private String iphone;
    private List<String> abilities;
    private Date createdDate;   // 解析成功，支持松散匹配属性

    //    @ConfigurationProperties("#{(1+2-3)/4*5}")
    private String operator;    // 语法报错，不支持SpEL表达式：not applicable to field

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "ConfigurationPropertiesEntity{" +
                "nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", iphone='" + iphone + '\'' +
                ", abilities=" + abilities +
                ", createdDate=" + createdDate +
                '}';
    }
}
