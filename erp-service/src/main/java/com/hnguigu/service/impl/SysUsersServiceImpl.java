package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.SysUsersMapper;
import com.hnguigu.service.SysUsersService;
import com.hnguigu.vo.SysUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUsersServiceImpl extends ServiceImpl<SysUsersMapper, SysUsers> implements SysUsersService {
    @Autowired
    SysUsersMapper sysUsersMapper;
    /**
     * 登陆的方法
     * @param sysUsers 登录所需账号，密码
     * @return
     * user skl
     */
    @Override
    public SysUsers login(SysUsers sysUsers) {
        sysUsersMapper.selectList(null);
        return sysUsersMapper.login(sysUsers);
    }

}
