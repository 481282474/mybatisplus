package com.lyc.mapper;
import org.apache.ibatis.annotations.Param;

import com.lyc.domain.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 蜡笔
* @description 针对表【brand】的数据库操作Mapper
* @createDate 2022-11-07 13:29:14
* @Entity com.lyc.domain.Brand
*/
public interface BrandMapper extends BaseMapper<Brand> {

    int insertSelective(Brand brand);

}




