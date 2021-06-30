package com.hnguigu.service.zsxservice.impl.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.sys.RolesMapper;
import com.hnguigu.vo.zsxvo.pojo.sys.Roles;
import com.hnguigu.service.zsxservice.sys.RolesService;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl  extends ServiceImpl<RolesMapper, Roles> implements RolesService {
}
