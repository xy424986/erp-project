package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.SysLogsMapper;
import com.hnguigu.service.SysLogsService;
import com.hnguigu.vo.SysLogs;
import org.springframework.stereotype.Service;

@Service
public class SysLogsServiceImpl extends ServiceImpl<SysLogsMapper, SysLogs> implements SysLogsService {
}
