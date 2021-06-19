package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.SGatherDetails;
import com.hnguigu.vo.SPayDetails;
import com.hnguigu.vo.extend.SPayEX;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SPayDetailsMapper extends BaseMapper<SPayDetails> {

    @Select("select *,sc.amount as scAmoupayAssnt  from `s_pay_details` spd\n" +
            "left join `s_pay` sp  on sp.ID = spd.PARENT_ID \n" +
            "left join s_cell sc on spd.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where spd.PARENT_ID=#{parentId}")
    List<SPayEX> queryByParentIdSPayDetails(@Param("parentId") String parentId);
    @Select("select * from `s_pay_details` spd\n" +
            "left join `s_pay` sp  on sp.ID = spd.PARENT_ID \n" +
            "where spd.PARENT_ID=#{parentId1} and spd.PAY_TAG='K002-1'")
    List<SPayEX> queryByParentIdSPayDetails1(@Param("parentId1") String id);
}
