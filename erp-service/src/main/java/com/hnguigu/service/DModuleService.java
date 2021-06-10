package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.DModule;

import java.util.List;

public interface DModuleService extends IService<DModule> {

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
    List<DModule> queryByState(String state);
}
