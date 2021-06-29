package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MProcedureModule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MProcedureModuleService extends IService<MProcedureModule> {
    /**
     * 根据父级编号查询工序所需的物料-skl
     * @param parentid
     * @return
     */
    List<MProcedureModule> querybyparentid(int parentid);
}
