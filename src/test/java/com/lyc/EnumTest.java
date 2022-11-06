package com.lyc;

import com.lyc.domain.User;
import com.lyc.enums.SexEnum;
import com.lyc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //测试设置性别的枚举
        User user = new User();
        user.setName("zhangmazi");
        user.setAge(50);
        user.setSex(SexEnum.MALE);
        userMapper.insert(user);
    }
}
