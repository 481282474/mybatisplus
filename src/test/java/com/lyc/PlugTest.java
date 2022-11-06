package com.lyc;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.lyc.domain.Product;
import com.lyc.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlugTest {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 小李和小王同时操作商品后台系统。小李操作的时候，系统先取出商品价格100元；小王
     * 也在操作，取出的商品价格也是100元。小李将价格加了50元，并将100+50=150元存入了数据
     * 库；小王将商品减了30元，并将100-30=70元存入了数据库。没有锁，小李的操作就完全被小王的覆盖了。
     */
    @Test
    public void test01(){
        //小李查询价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的价格："+productLi.getPrice());
        //小王查询价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的价格："+productWang.getPrice());

        //小李更新价格
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);
        //小王更新价格
        productWang.setPrice(productWang.getPrice()-30);
        productMapper.updateById(productWang);

        //老板查询价格
        Product productBoss = productMapper.selectById(1);
        System.out.println("laoban查询的价格："+productBoss.getPrice());
    }


}
