package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.DModule;
import com.hnguigu.vo.DModuleDetails;
import com.hnguigu.vo.extend.MDesignProcedureDetailsExtend;

import java.util.List;

public interface DModuleDetailsService extends IService<DModuleDetails> {

    /**
     * hhy
     * @param mDesignProcedureDetailsExtendList
     * @return
     */
    int updateBy(List<MDesignProcedureDetailsExtend> mDesignProcedureDetailsExtendList);

    /**
     * 物料组成设计添加的方法第三部-skl
     * @param
     * @param
     * @return
     */
    public List<DModuleDetails> getByparentId(int parentId);

    /**
     * hhy
     * @param dModule
     * @return
     */
    List<DModuleDetails> queryByParentId(DModule dModule);

}
