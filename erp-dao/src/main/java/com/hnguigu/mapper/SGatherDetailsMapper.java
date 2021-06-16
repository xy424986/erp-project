package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.SGatherDetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SGatherDetailsMapper extends BaseMapper<SGatherDetails> {

    @Select("select * from `s_gather_details` sgd\n" +
            "left join `s_gather` sg  on sg.ID = sgd.PARENT_ID \n" +
            "where sgd.PARENT_ID=#{parentId} and sg.GATHER_TAG='K002-1'")
    List<SGatherDetails> queryByParentIdSGatherDetails(@Param("parentId") String id);
}
