package com.hnguigu.service.zsxservice.impl.s;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.s.PayDetailsMapper;
import com.hnguigu.vo.zsxvo.pojo.s.PayDetails;
import com.hnguigu.service.zsxservice.s.PayDetailsService;
import org.springframework.stereotype.Service;

@Service
public class PayDetailsServiceImpl extends ServiceImpl<PayDetailsMapper, PayDetails> implements PayDetailsService {
}
