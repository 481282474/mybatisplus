package com.lyc.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

//@Data不包含有参构造
@Data
//@TableName("表名"),如果表名与实体类名不一致，用该注解来设置
public class User {
    @TableId(value = "id",type = IdType.ASSIGN_ID)  //value的值与数据库表中的值保持一致
    private Integer id;
    //@TableField(value = "name") 普通字段用@TableField
    private String name;
    private Integer age;
    private String email;

}
