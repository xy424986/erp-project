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

    @RequestMapping("queryByChangeState")
    public List<MDesignProcedureDetails> queryByChangeState(){
        return mDesignProcedureDetailsService.queryByChangeState("D003-0");
    }

}
