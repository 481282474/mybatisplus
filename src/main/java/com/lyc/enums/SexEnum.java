package com.lyc.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

//通用枚举
@Getter
public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");
    @EnumValue  //将注解所标识的属性的值存到数据库中
    private Integer sex;
    private String sexName;

    //设置构造器
    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
