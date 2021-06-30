package com.hnguigu.service.zsxservice.impl.s;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.s.CellMapper;
import com.hnguigu.vo.zsxvo.pojo.s.Cell;
import com.hnguigu.service.zsxservice.s.CellService;
import org.springframework.stereotype.Service;

@Service
public class CellServiceImpl  extends ServiceImpl<CellMapper, Cell> implements CellService {
}
