package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.DModule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DModuleMapper extends BaseMapper<DModule> {

    /**
     * hhy
     * 根据复核状态查询生产工序设计单数据
     * 状态：
     * S001-0: 等待审核
     * S001-1: 审核通过
     * S001-2: 审核不通过
     * @param state
     * @return
     */
    List<DFile> queryByState(String state);

    /**
     * 物料组成设计单查询
     * @param
     * @return
     */
    @Select("select mo.*,fi.DESIGN_MODULE_TAG as designModuleTag from d_module mo left join \n" +
            "d_file fi on mo.PRODUCT_ID=fi.PRODUCT_ID where mo.CHECK_TAG='s001-1'")
    List<DModule> query_design_sheetdata();
}
