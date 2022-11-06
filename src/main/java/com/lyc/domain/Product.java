package com.lyc.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
@Data
@TableName(value = "t_product")
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version //表示乐观锁版本字段
    private Integer version;
}
