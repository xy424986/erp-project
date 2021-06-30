package com.hnguigu.mapper.m;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.zsxvo.pojo.m.Apply;
import org.apache.ibatis.annotations.Select;

public interface ApplyMapper  extends BaseMapper<Apply> {

    @Select("SELECT MAX(`APPLY_ID`)   FROM m_apply WHERE TO_DAYS(register_time) = TO_DAYS(NOW()) ")
    String showApplyId();


  /*  @Select("SELECT * FROM m_apply GROUP BY apply_id")
    List<Apply> selectGroupApplyId();*/
}
