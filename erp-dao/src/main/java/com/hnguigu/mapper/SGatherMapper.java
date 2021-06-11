package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SGather;
import com.hnguigu.vo.ex.SGatherEx;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SGatherMapper extends BaseMapper<SGather> {
    @Select("select * from `s_gather_details` sgd\n" +
            "left join `s_gather` sg  on sg.ID = sgd.PARENT_ID\n" +
            "left join s_cell sc on sgd.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "left join `d_file` df on df.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where df.`CHECK_TAG`='S001-1'\n" +
            "and sc.check_tag='S001-1' \n" +
            "and sg.GATHER_TAG='K002-1'\n" +
            "and sg.check_tag='S001-1'\n" +
            "and sgd.GATHER_TAG='K002-1'")
    List<DFile> querySGather();
    @Select("select * from `s_gather_details` sgd\n" +
            "left join `s_gather` sg  on sg.ID = sgd.PARENT_ID\n" +
            "left join s_cell sc on sgd.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "left join `d_file` df on df.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where df.`PRODUCT_ID`=#{productId} \n" +
            "and sc.check_tag='S001-1' \n" +
            "and sg.GATHER_TAG='K002-1'\n" +
            "and sg.check_tag='S001-1'\n" +
            "and sgd.GATHER_TAG='K002-1' ")
    SGatherEx queryByIdSGatherEx(String productId);
}
