package com.hnguigu.controller;

import com.hnguigu.service.ManufactureConfigProcedureListService;
import com.hnguigu.vo.ManufactureConfigProcedureList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ManufactureConfigProcedureList")
public class ManufactureConfigProcedureListController {

    @Autowired
    ManufactureConfigProcedureListService manufactureConfigProcedureListService;

    /**
     * hhy
     * @return
     */
    @RequestMapping("queryAll.action")
    public List<ManufactureConfigProcedureList> queryAll(){
        return manufactureConfigProcedureListService.queryAll();
    }
}
