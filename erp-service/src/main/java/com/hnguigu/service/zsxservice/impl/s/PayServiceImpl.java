package com.hnguigu.service.zsxservice.impl.s;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.s.PayMapper;
import com.hnguigu.vo.zsxvo.pojo.s.Pay;
import com.hnguigu.service.zsxservice.s.PayService;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay> implements PayService {
}
