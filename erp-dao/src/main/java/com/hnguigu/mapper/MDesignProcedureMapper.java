package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.MDesignProcedure;
import com.hnguigu.vo.PageVo;
import org.apache.ibatis.annotations.Select;

public interface MDesignProcedureMapper extends BaseMapper<MDesignProcedure> {

    /**
     * hhy
     * @param mDesignProcedure
     * @return
     */
//    PageVo<MDesignProcedure> queryByState(MDesignProcedure mDesignProcedure);

    /**
     * hhy
     * @param mDesignProcedure
     * @return
     */
//    int queryTotal(MDesignProcedure mDesignProcedure);

    /**
     * 根据产品编号查询产品生产工序数据-skl
     * @param productId
     * @return
     */
    @Select("select * from m_design_procedure where PRODUCT_ID=#{productId}")
    public MDesignProcedure queryByproductID(String productId);
}
