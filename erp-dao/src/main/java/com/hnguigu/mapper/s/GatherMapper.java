package com.hnguigu.mapper.s;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.zsxvo.pojo.s.Gather;
import org.apache.ibatis.annotations.Select;

public interface GatherMapper extends BaseMapper<Gather> {

    @Select("select max(gather_id)   from s_gather where to_days(register_time) = to_days(now())")
    String showGatherid();

}