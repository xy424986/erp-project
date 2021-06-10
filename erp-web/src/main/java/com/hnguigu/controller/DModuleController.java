package com.hnguigu.controller;

import com.hnguigu.service.DModuleService;
import com.hnguigu.vo.DModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DModule")
public class DModuleController {

    @Autowired
    DModuleService dModuleService;

    /**
     * hhy
     * 根据复核状态查询生产工序设计单数据
     * 状态：
     * S001-0: 等待审核
     * S001-1: 审核通过
     * S001-2: 审核不通过
     * @return
     */
    @RequestMapping("queryByState.action")
    public List<DModule> queryByState(){
        return dModuleService.queryByState("S001-1");
    }
}
