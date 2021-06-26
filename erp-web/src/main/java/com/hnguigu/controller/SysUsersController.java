package com.hnguigu.controller;


import com.hnguigu.service.DFileService;
import com.hnguigu.service.SysUsersService;
import com.hnguigu.vo.SysUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class SysUsersController {
    @Autowired
    SysUsersService sysUsersService;
    @Autowired
    DFileService dFileService;

    /**
     * 登陆的方法-skl
     * @param sysUsers 登录的账号，密码
     * @return
     * user skl
     */
    @RequestMapping("login.action")
    public String login(SysUsers sysUsers, HttpSession session){
        System.out.println(sysUsers);
//        QueryWrapper<SysUsers> queryWrapper = new QueryWrapper<>();
//        if(sysUsers.getLoginId()!=""&&sysUsers.getLoginId()!=null){
//            queryWrapper.eq("loginId",sysUsers.getLoginId());
//        }
//        if(sysUsers.getPassword()!=""&&sysUsers.getPassword()!=null){
//            queryWrapper.eq("password",sysUsers.getPassword());
//        }
//        SysUsers one = sysUsersService.getOne(queryWrapper);
        SysUsers login = sysUsersService.login(sysUsers);
        //提供登记人复核人
        session.setAttribute("login",login);
        System.out.println(login);
        if(login!=null){
            session.setAttribute("loginId",login.getLoginId());
            return "true";
        }
        return "false";
    }


}
