package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.MManuFacture;
import com.hnguigu.vo.MProcedure;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MProcedureMapper extends BaseMapper<MProcedure> {
    /**
     * 根据父级id查询产品生产工序 -skl
     * @param id
     * @return
     */
    @Select("select * from m_procedure where PARENT_ID=#{id}")
    List<MProcedure> queryByparentID(int id);

    /**
     *生产登记复核，查询所有工序是否已经审核-skl
     * @param id
     * @return
     */
    @Select("select * from m_procedure where PARENT_ID=#{id}")
    List<MProcedure> queryByparentIDtwo(int id);
}
