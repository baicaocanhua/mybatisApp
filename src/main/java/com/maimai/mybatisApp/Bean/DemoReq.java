package com.maimai.mybatisApp.Bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
@Data
public class DemoReq {

    @NotBlank(message="code不能为空")
    String code;

    @Length(max=10,message="name长度不能超过10")
    String name;
}
