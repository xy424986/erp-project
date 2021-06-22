package com.hnguigu.controller;

import com.hnguigu.service.MDesignProcedureDetailsService;
import com.hnguigu.vo.MDesignProcedureDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/MDesignProcedureDetails")
public class MDesignProcedureDetailsController {

    @Autowired
    MDesignProcedureDetailsService mDesignProcedureDetailsService;

    /**
     * hhy
     * 根据MDesignProcedure id查询数据审核
     * @param pId
     * @return
     */
    @RequestMapping("queryByPId.action")
    public List<MDesignProcedureDetails> queryByPId(int pId){
        return mDesignProcedureDetailsService.queryByPId(pId);
    }

}
