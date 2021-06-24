package com.hnguigu.controller;

import com.hnguigu.service.DModuleDetailsService;
import com.hnguigu.service.MDesignProcedureDetailsService;
import com.hnguigu.service.MDesignProcedureModuleService;
import com.hnguigu.vo.DModule;
import com.hnguigu.vo.DModuleDetails;
import com.hnguigu.vo.extend.MDesignProcedureDetailsExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dModuleDetails")
public class DModuleDetailsController {

    @Autowired
    DModuleDetailsService dModuleDetailsService;

    @Autowired
    MDesignProcedureDetailsService mDesignProcedureDetailsService;

    @Autowired
    MDesignProcedureModuleService mDesignProcedureModuleService;

    /**\
     * hhy
     * @param mDesignProcedureDetailsExtendList
     * @return
     */
    @RequestMapping(value = "insert.action", produces = {"text/json;charset=utf-8"})
    public String insert(@RequestBody List<MDesignProcedureDetailsExtend> mDesignProcedureDetailsExtendList) {

        int row = mDesignProcedureDetailsService.update(mDesignProcedureDetailsExtendList);
        int row1 = mDesignProcedureModuleService.insert(mDesignProcedureDetailsExtendList);
        if (row != 0 && row1 !=0) {
            return "设计完成";
        }
        System.out.println(mDesignProcedureDetailsExtendList);
        return "设计失败!";
    }

    /**
     * hhy
     * @param dModule
     * @return
     */
    @RequestMapping(value = "queryByParentId.action")
    public List<DModuleDetails> queryByDesignId(DModule dModule) {

        return dModuleDetailsService.queryByParentId(dModule);
    }

}
