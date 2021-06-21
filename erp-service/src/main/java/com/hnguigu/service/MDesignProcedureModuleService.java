package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.MDesignProcedureModule;

import java.util.List;

public interface MDesignProcedureModuleService extends IService<MDesignProcedureModule> {
    /**
     * hhy
     * @param mDesignProcedureModule
     * @return
     */
    List<MDesignProcedureModule> queryByPId(MDesignProcedureModule mDesignProcedureModule);
}
