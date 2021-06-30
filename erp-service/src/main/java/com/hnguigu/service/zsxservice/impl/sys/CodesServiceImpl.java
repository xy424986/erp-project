package com.hnguigu.service.zsxservice.impl.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.sys.CodesMapper;
import com.hnguigu.vo.zsxvo.pojo.sys.Codes;
import com.hnguigu.service.zsxservice.sys.CodesService;
import org.springframework.stereotype.Service;

@Service
public class CodesServiceImpl  extends ServiceImpl<CodesMapper, Codes> implements CodesService {
}
