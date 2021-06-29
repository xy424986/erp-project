package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.MApply;
import org.apache.ibatis.annotations.Select;

public interface MApplyMapper extends BaseMapper<MApply> {
    /**
     * 制定生产派工单：根据产品编号查询生产计划数据-skl
     * @param productId
     * @return
     */
    @Select("select * from m_apply where PRODUCT_ID=#{productId}")
    public MApply queryByproductId(String productId);
}
