package com.hnguigu.mapper.m;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedure;
import org.apache.ibatis.annotations.Select;

public interface DesignProcedureMapper extends BaseMapper<DesignProcedure> {

    @Select("SELECT MAX(m_design_procedure.`PRODUCT_ID`)   FROM m_design_procedure WHERE TO_DAYS(register_time) = TO_DAYS(NOW()) ")
    String showProductId();

    @Select("SELECT * FROM `m_design_procedure` WHERE PRODUCT_ID=#{productId}")
    DesignProcedure showbyParentId(String productId);


}