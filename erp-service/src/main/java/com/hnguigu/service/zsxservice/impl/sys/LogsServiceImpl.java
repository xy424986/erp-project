package com.hnguigu.service.zsxservice.impl.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.sys.LogsMapper;
import com.hnguigu.vo.zsxvo.pojo.sys.Logs;
import com.hnguigu.service.zsxservice.sys.LogsService;
import org.springframework.stereotype.Service;

@Service
public class LogsServiceImpl  extends ServiceImpl<LogsMapper, Logs> implements LogsService {
}
