package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.service.MApplyService;
import com.hnguigu.vo.MApply;
import com.hnguigu.vo.MDesignProcedure;
import com.hnguigu.vo.extend.MDesignProcedureExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/mApply")
public class MApplyController {

    @Autowired
    MApplyService mApplyService;

    /**
     *  hhy
     * 查询状态
     * @return
     */
    @RequestMapping("queryAll.action")
    public IPage<MApply> queryAll(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                  MApply mApply){
        return mApplyService.queryAll(pageNumber, pageSize, mApply);
    }

    /**
     * hhy
     * 查询要审核的数据
     * @param mApply
     * @return
     */
    @RequestMapping("queryById.action")
    public List<MApply> queryById(MApply mApply){
        return mApplyService.queryById(mApply);
    }

    /**
     * hhy
     * 查询对应状态的所有数据
     * @param mApply
     * @return
     */
    @RequestMapping("queryByState.action")
    public List<MApply> queryByState(MApply mApply){
        return mApplyService.queryByState(mApply);
    }

    /**
     * hhy
     * 审核
     * @param mApply
     * @return
     */
    @RequestMapping(value = "audit.action", produces = {"text/json;charset=utf-8"})
    public String updateStateById(MApply mApply){
        int row = mApplyService.updateStateById(mApply);
        String message = row==0?"审核异常":"已审核";
        return message;
    }

    /**
     * hhy
     * @param mApplyList
     * @return
     */
    @RequestMapping(value = "insert.action", produces = {"text/json;charset=utf-8"})
    public String insert1(@RequestBody List<MApply> mApplyList) {

        int row = mApplyService.insert(mApplyList);
        if (row != 0) {
            return "已提交";
        }
        System.out.println(mApplyList);
        return "提交失败!";
    }
}
