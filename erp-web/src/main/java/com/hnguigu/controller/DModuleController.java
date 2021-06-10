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

}
