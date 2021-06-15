package com.hnguigu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MDesignProcedureDetails;

import java.util.List;

public interface MDesignProcedureDetailsService extends IService<MDesignProcedureDetails> {
    /**
     * hhy
     * 根据工序改变状态查询
     * D003-0: 未变更
     * D003-1: 已变更
     * @param State
     * @return
     */
    List<MDesignProcedureDetails> queryByChangeState(String State);
}
