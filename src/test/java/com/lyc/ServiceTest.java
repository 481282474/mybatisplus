package com.lyc;

import com.lyc.domain.User;
import com.lyc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGroup(){
        //组数
        long count = userService.count();
        System.out.println("查询结果"+count);
    }

    @Test
    public void insertBath(){
        //批量添加
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("user"+i);
            user.setAge(20+i);
            users.add(user);
        }

        userService.saveBatch(users);

    }
}
