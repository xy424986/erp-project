package com.hnguigu.controller;


import com.hnguigu.service.SCellService;
import com.hnguigu.vo.SCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SCllController {

    @Autowired
    SCellService sCellService;

    @RequestMapping("/addScll.May")
    public boolean addSCll(SCell sCell){
        System.out.println(sCell);
        return sCellService.save(sCell);
    }
}
