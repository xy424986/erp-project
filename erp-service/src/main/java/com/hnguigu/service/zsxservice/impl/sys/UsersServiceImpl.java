package com.hnguigu.service.zsxservice.impl.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.sys.UsersMapper;
import com.hnguigu.vo.zsxvo.pojo.sys.Users;
import com.hnguigu.service.zsxservice.sys.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
}
