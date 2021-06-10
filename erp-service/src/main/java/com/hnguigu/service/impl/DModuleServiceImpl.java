package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.DModuleMapper;
import com.hnguigu.service.DModuleService;
import com.hnguigu.vo.DModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DModuleServiceImpl extends ServiceImpl<DModuleMapper, DModule> implements DModuleService {

    @Autowired
    DModuleMapper dModuleMapper;

    /**
     * hhy
     * 根据复核状态查询生产工序设计单数据
     * 状态：
     * S001-0: 等待审核
     * S001-1: 审核通过
     * S001-2: 审核不通过
     * @param state
     * @return
     */
    @Override
    public List<DModule> queryByState(String state) {
        QueryWrapper<DModule> queryWrapper = new QueryWrapper<DModule>();
        queryWrapper.eq("CHECK_TAG", state);
        return dModuleMapper.selectList(queryWrapper);
    }
}
