package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MDesignProcedureDetailsMapper;
import com.hnguigu.service.MDesignProcedureDetailsService;
import com.hnguigu.vo.MDesignProcedureDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MDesignProcedureDetailsServiceImpl extends ServiceImpl<MDesignProcedureDetailsMapper, MDesignProcedureDetails> implements MDesignProcedureDetailsService {

    @Autowired
    MDesignProcedureDetailsMapper mDesignProcedureDetailsMapper;

    /**
     *hhy
     * 根据工序改变状态查询
     * D003-0: 未变更
     * D003-1: 已变更
     * @param State
     * @return
     */
    @Override
    public List<MDesignProcedureDetails> queryByChangeState(String State) {
        QueryWrapper<MDesignProcedureDetails> queryWrapper = new QueryWrapper<MDesignProcedureDetails>();
        queryWrapper.eq("DESIGN_MODULE_CHANGE_TAG", State);
        return mDesignProcedureDetailsMapper.selectList(queryWrapper);
    }
}
