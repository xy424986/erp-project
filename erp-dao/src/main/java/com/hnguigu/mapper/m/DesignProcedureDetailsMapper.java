package com.hnguigu.mapper.m;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedureDetails;
import org.apache.ibatis.annotations.Select;

public interface DesignProcedureDetailsMapper  extends BaseMapper<DesignProcedureDetails> {

    @Select("SELECT MAX(procedure_id)   FROM `m_design_procedure_details` WHERE TO_DAYS(register_time) = TO_DAYS(NOW()) ")
    String showProductId();
}