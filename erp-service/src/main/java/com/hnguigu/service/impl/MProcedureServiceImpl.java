package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MProcedureMapper;
import com.hnguigu.service.MProcedureService;
import com.hnguigu.vo.MProcedure;
import org.springframework.stereotype.Service;

@Service
public class MProcedureServiceImpl extends ServiceImpl<MProcedureMapper, MProcedure> implements MProcedureService {
}
