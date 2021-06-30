package com.hnguigu.service.zsxservice.impl.m;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.m.ProcedureMapper;
import com.hnguigu.vo.zsxvo.pojo.m.Procedure;
import com.hnguigu.service.zsxservice.m.ProcedureService;
import org.springframework.stereotype.Service;

@Service
public class ProcedureServiceImpl extends ServiceImpl<ProcedureMapper, Procedure> implements ProcedureService {
}
