package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MApplyMapper;
import com.hnguigu.service.MApplyService;
import com.hnguigu.vo.MApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MApplyServiceImpl extends ServiceImpl<MApplyMapper, MApply> implements MApplyService {
    @Autowired
    MApplyMapper mApplyMapper;
    /**
     * 制定生产派工单：根据产品编号查询生产计划数据
     * @param productId
     * @return
     */
    @Override
    public MApply queryByproductId(String productId) {
        return mApplyMapper.queryByproductId(productId);
    }
}
