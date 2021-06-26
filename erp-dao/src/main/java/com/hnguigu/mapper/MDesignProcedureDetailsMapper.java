package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.MDesignProcedureDetails;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MDesignProcedureDetailsMapper extends BaseMapper<MDesignProcedureDetails> {
    /**
     * 根据产品生产工序id查询相应的工序明细
     * @param id
     * @return
     */
    @Select("select * from m_design_procedure_details where PARENT_ID=#{id}")
        public List<MDesignProcedureDetails> queryByparentId(int id);
}
