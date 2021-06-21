package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.SGatherDetails;

import com.hnguigu.vo.extend.SGatherEx;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SGatherDetailsMapper extends BaseMapper<SGatherDetails> {

    @Select("select *,sc.amount as scAmount  from `s_gather_details` sgd\n" +
            "left join `s_gather` sg  on sg.ID = sgd.PARENT_ID \n" +
            "left join s_cell sc on sgd.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where sgd.PARENT_ID=#{parentId}")
    List<SGatherEx> queryByParentIdSGatherDetails(@Param("parentId") String id);

    @Select("select * from `s_gather_details` sgd\n" +
            "left join `s_gather` sg  on sg.ID = sgd.PARENT_ID \n" +
            "where sgd.PARENT_ID=#{parentId1} and sgd.GATHER_TAG='K002-1'")
    List<SGatherDetails> queryByParentIdSGatherDetails1(@Param("parentId1") String id);

    @Select("select *,sc.amount as scAmount  from `s_gather_details` sgd\n" +
            "left join `s_gather` sg  on sg.ID = sgd.PARENT_ID\n" +
            "left join s_cell sc on sgd.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where sgd.ID=#{id}")
    SGatherEx queryByIdSGatherEx(@Param("id") int id);

    @Select("select *,sc.amount as scAmount  from `s_gather_details` sgd\n" +
            "left join `s_gather` sg  on sg.ID = sgd.PARENT_ID\n" +
            "left join s_cell sc on sgd.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where sgd.ID=#{id1}")
    List<SGatherEx> queryByIdSGatherEx2(@Param("id1") int id);
}
