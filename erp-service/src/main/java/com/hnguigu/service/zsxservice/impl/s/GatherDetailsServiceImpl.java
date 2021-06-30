package com.hnguigu.service.zsxservice.impl.s;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.s.GatherDetailsMapper;
import com.hnguigu.vo.zsxvo.pojo.s.GatherDetails;
import com.hnguigu.service.zsxservice.s.GatherDetailsService;
import org.springframework.stereotype.Service;

@Service
public class GatherDetailsServiceImpl  extends ServiceImpl<GatherDetailsMapper, GatherDetails> implements GatherDetailsService {
}
