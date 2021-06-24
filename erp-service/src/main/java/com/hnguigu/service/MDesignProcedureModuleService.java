package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.MDesignProcedureModule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MDesignProcedureModuleService extends IService<MDesignProcedureModule> {
    /**
     * hhy
     * @param mDesignProcedureModule
     * @return
     */
    List<MDesignProcedureModule> queryByPId(MDesignProcedureModule mDesignProcedureModule);
    /**
     * 根据父级编号查询工序所需物料-skl
     * @param id
     * @return
     */
    List<MDesignProcedureModule> queryByparentId(int id);

}
