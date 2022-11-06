package com.lyc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyc.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    //不使用mybatis plus库提供的方法，自定义sql语句方法
    //根据年龄分页查询
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);

}
