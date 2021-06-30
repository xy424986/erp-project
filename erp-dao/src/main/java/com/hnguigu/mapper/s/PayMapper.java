package com.hnguigu.mapper.s;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.zsxvo.pojo.s.Pay;
import org.apache.ibatis.annotations.Select;

public interface PayMapper extends BaseMapper<Pay> {

    @Select("SELECT MAX(pay_id)   FROM s_pay WHERE TO_DAYS(register_time) = TO_DAYS(NOW()) ")
    String ShowPayId();
}