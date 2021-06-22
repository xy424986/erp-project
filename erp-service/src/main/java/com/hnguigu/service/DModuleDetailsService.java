package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.DModuleDetails;

import java.util.List;

public interface DModuleDetailsService extends IService<DModuleDetails> {
    /**
     * 物料组成设计添加的方法第三部-skl
     * @param
     * @param
     * @return
     */
    public List<DModuleDetails> getByparentId(int parentId);

}
