package com.lyc;

import com.lyc.domain.User;
import com.lyc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelect() {
        //通过条件构造器查询list集合，没有条件参数为null
        List<User> users = userMapper.selectList(null);

        //通过id批量chaxun
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<User> users2 = userMapper.selectBatchIds(list);

        System.out.println(users2.toString());
    }

    @Test
    public void TestInsert(){
        User user = new User();
        user.setName("lisi");
        user.setAge(22);
        user.setEmail("654123@qq.com");
        //返回受影响行数
        userMapper.insert(user);

    }

    @Test
    public void deleteById(){
        userMapper.deleteById(0);
    }

    @Test
    public void deleteByCon(){
        //条件删除，将键值对存入map中作为条件
        HashMap<String,Object> map=new HashMap<>();
        map.put("age",22);
        map.put("name","lisi");
        userMapper.deleteByMap(map);
    }

}
