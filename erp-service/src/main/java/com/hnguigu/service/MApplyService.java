package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MApply;

public interface MApplyService extends IService<MApply> {
    /**
     * 制定生产派工单：根据产品编号查询生产计划数据
     * @param productId
     * @return
     */
    public MApply queryByproductId(String productId);
}
