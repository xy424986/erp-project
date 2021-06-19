package com.hnguigu.controller;

import com.hnguigu.service.MDesignProcedureDetailsService;
import com.hnguigu.service.MDesignProcedureService;
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

    @Transactional
    @RequestMapping(value = "insert.action", produces = {"text/json;charset=utf-8"})
    public String insert(@RequestBody List<MDesignProcedureExtend> mDesignProcedureExtend) {

        int row = mDesignProcedureService.insert(mDesignProcedureExtend);
        int row1 = mDesignProcedureDetailsService.insert(mDesignProcedureExtend);
        if (row != 0 && row1 !=0) {
            return "已提交";
        }
//        System.out.println(mDesignProcedureExtend);
        return "提交失败";
    }
}
