package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.MProcedureModule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MProcedureModuleMapper extends BaseMapper<MProcedureModule> {
    /**
     * 根据父级编号查询工序所需的物料-skl
     * @param parentid
     * @return
     */
    @Select("select * from m_procedure_module where PARENT_ID=#{parentid}")
        List<MProcedureModule> querybyparentid(int parentid);
}
