package com.hnguigu.controller;

import com.hnguigu.service.MDesignProcedureModuleService;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.MDesignProcedureModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/MDesignProcedureModule")
public class MDesignProcedureModuleController {

    @Autowired
    MDesignProcedureModuleService mDesignProcedureModuleService;

    /**
     * 根据MDesignProcedureDetails id 查询数据审核
     * @param mDesignProcedureModule
     * @return
     */
    @RequestMapping("queryByPId.action")
    public List<MDesignProcedureModule> queryByPId(MDesignProcedureModule mDesignProcedureModule){
        return mDesignProcedureModuleService.queryByPId(mDesignProcedureModule);
    }
}
