package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.DModuleMapper;
import com.hnguigu.service.DModuleService;
import com.hnguigu.vo.DModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DModuleServiceImpl extends ServiceImpl<DModuleMapper, DModule> implements DModuleService {

    @Autowired
    DModuleMapper dModuleMapper;

}
