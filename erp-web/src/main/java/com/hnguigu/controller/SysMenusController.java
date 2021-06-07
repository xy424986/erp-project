package com.hnguigu.controller;

import com.hnguigu.service.SysMenusService;
import com.hnguigu.vo.SysMenus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SysMenusController {

    @Autowired
    SysMenusService sysMenusService;

    //返回的菜单集合   (菜单包含了父子关系)
    @RequestMapping("queryAllMenus.action")
    public List<SysMenus> queryAllMenus(){
        return  sysMenusService.queryAllMenus();
    }
}
