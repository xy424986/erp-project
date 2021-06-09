package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.SPayMapper;
import com.hnguigu.service.SPayService;
import com.hnguigu.vo.SPay;
import org.springframework.stereotype.Service;

@Service
public class SPayServiceImpl extends ServiceImpl<SPayMapper, SPay> implements SPayService {
}
