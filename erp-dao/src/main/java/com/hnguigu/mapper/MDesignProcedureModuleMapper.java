package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.MDesignProcedureModule;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MDesignProcedureModuleMapper extends BaseMapper<MDesignProcedureModule> {
    /**
     * 根据父级编号查询工序所需物料-skl
     * @param id
     * @return
     */
    @Select("select * from m_design_procedure_module where PARENT_ID=#{id}")
    List<MDesignProcedureModule> queryByparentId(int id);

}
