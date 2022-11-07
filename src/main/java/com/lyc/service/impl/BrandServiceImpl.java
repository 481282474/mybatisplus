package com.lyc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyc.domain.Brand;
import com.lyc.service.BrandService;
import com.lyc.mapper.BrandMapper;
import org.springframework.stereotype.Service;

/**
* @author 蜡笔
* @description 针对表【brand】的数据库操作Service实现
* @createDate 2022-11-07 13:29:14
*/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand>
    implements BrandService{

}




