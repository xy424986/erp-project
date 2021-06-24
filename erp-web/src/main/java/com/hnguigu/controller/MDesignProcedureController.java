package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.service.MDesignProcedureDetailsService;
import com.hnguigu.service.MDesignProcedureService;

import com.hnguigu.vo.MDesignProcedure;

import com.hnguigu.vo.extend.MDesignProcedureExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/mDesignProcedure")
public class MDesignProcedureController {

    @Autowired
    MDesignProcedureService mDesignProcedureService;

    @Autowired
    MDesignProcedureDetailsService mDesignProcedureDetailsService;

    /**
     * hhy
     * 工序物料设计单
     * @param mDesignProcedureExtendList
     * @return
     */
    @RequestMapping(value = "insert1.action", produces = {"text/json;charset=utf-8"})
    public String insert1(@RequestBody List<MDesignProcedureExtend> mDesignProcedureExtendList) {

        int row = mDesignProcedureService.updateByIds(mDesignProcedureExtendList);
        if (row != 0) {
            return "已提交";
        }
        System.out.println(mDesignProcedureExtendList);
        return "提交失败!";
    }

    /**
     * hhy
     * 审核定制产品生产工序设计单
     * @param mDesignProcedure
     * @return
     */
    @RequestMapping(value = "audit.action", produces = {"text/json;charset=utf-8"})
    public String audit(MDesignProcedure mDesignProcedure) {

        int row = mDesignProcedureService.updateByMDP(mDesignProcedure);
        if (row != 0) {
            return "已通过";
        }
        return "审核异常";
    }

     /**
     *hhy
     *提交定制产品生产工序设计单
     * @param mDesignProcedureExtendList
     * @return
     */
    @Transactional
    @RequestMapping(value = "insert.action", produces = {"text/json;charset=utf-8"})
    public String insert(@RequestBody List<MDesignProcedureExtend> mDesignProcedureExtendList) {

        int row = mDesignProcedureService.insert(mDesignProcedureExtendList);
        int row1 = mDesignProcedureDetailsService.insert(mDesignProcedureExtendList);
        if (row != 0 && row1 !=0) {
            return "已提交";
        }
//        System.out.println(mDesignProcedureExtendList);
        return "提交失败";
    }

    /**
     * hhy
     *根据状态查询出所有已提交的
     * 定制产品生产工序设计单用于审核操作
     * @param pageNumber
     * @param pageSize
     * @param mDesignProcedure
     * @return
     */
    @RequestMapping("queryByState.action")
    public IPage<MDesignProcedure> queryByState(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                     @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                     MDesignProcedure mDesignProcedure){
        return mDesignProcedureService.queryAll(pageNumber, pageSize, mDesignProcedure);
    }
}
