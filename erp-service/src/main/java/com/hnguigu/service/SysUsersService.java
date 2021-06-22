package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.SysUsers;

public interface SysUsersService extends IService<SysUsers> {
    /**
     * 登陆的方法
     * @param sysUsers 登录所需账号，密码
     * @return
     * user skl
     */
    public SysUsers login(SysUsers sysUsers);

}
