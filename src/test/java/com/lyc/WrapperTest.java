package com.lyc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyc.domain.User;
import com.lyc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //前面为属性名，后面为条件。between区间包含前者和后者
        queryWrapper.like("name","a")
                    .between("age",20,21)
                    .isNotNull("email");

        //按照年龄升序排列,如果年龄相同则按照id降序排
        queryWrapper.orderByAsc("age").orderByDesc("id");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void deleteWrapper(){
        //删除功能本质也是修改,先存入删除条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        userMapper.delete(queryWrapper);
    }

    @Test
    public void updateWrapper01(){
        //使用QueryWrapper实现修改功能
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //默认连接条件为and，只用or()表示或，gt表示大于
        queryWrapper.gt("age",20)
                    .or()
                    .isNull("email");
        //模拟传入的值
        User user = new User();
        user.setName("zhangsan");
        userMapper.update(user,queryWrapper);
    }

    @Test
    public void updateWrapper02() {
        //使用UpdateWrapper实现修改功能
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        //gt:greater than,lt:less than
        updateWrapper.like("name","a")
                .and(i->i.gt("age",0).or().isNull("email"));
        updateWrapper.set("name","lisi").set("email","newemail@qq.com");
        userMapper.update(null,updateWrapper);
    }

    @Test
    public void byCondition(){
        //模拟用户只选择部分条件的查询
        String username="";
        Integer ageBegin=20;
        Integer ageEnd=30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //三个参数分别为：条件，属性，传入的值
        //StringUtils.isNotBlank(常量)，该方法判断传入的值是否为空字符串或null
        queryWrapper.like(StringUtils.isNotBlank(username),"name",username)
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void lambdaTest(){
        String username="";
        Integer ageBegin=20;
        Integer ageEnd=30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //使用lambda表达式，传入的第二个参数不是表名，而是实体类的字段
        queryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin!=null,User::getAge,ageBegin)
                .le(ageEnd!=null,User::getAge,ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void pageTest(){
        Page<User> page = new Page<>(1,2);
        userMapper.selectPage(page,null);
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
    }

    @Test
    public void pageVoTest(){
        Page<User> page = new Page<>(1,2);
        //自定义sql语句
        userMapper.selectPageVo(page,20);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
    }
}
