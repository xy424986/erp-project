package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.SysUsersMapper;
import com.hnguigu.service.SysUsersService;
import com.hnguigu.vo.SysUsers;
import org.springframework.stereotype.Service;

@Service
public class SysUsersServiceImpl extends ServiceImpl<SysUsersMapper, SysUsers> implements SysUsersService {
}
