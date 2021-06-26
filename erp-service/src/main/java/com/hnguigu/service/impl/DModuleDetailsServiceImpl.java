package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.DModuleDetailsMapper;
import com.hnguigu.service.DModuleDetailsService;
import com.hnguigu.service.DModuleService;
import com.hnguigu.vo.DModule;
import com.hnguigu.vo.DModuleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DModuleDetailsServiceImpl extends ServiceImpl<DModuleDetailsMapper, DModuleDetails> implements DModuleDetailsService {
    @Autowired
    DModuleDetailsMapper dModuleDetailsMapper;

    @Autowired
    DModuleService dModuleService;
    /**
     * 物料组成设计添加的方法第三部-skl
     * @param
     * @param
     * @return
     */
    @Override
    public List<DModuleDetails> getByparentId(int parentId) {
        return dModuleDetailsMapper.getByparentId(parentId);
    }

    /**
     * hhy
     * @param dModule
     * @return
     */
    @Override
    public List<DModuleDetails> queryByParentId(DModule dModule) {
        DModule dModule1 = dModuleService.queryByDesignId(dModule);

        QueryWrapper<DModuleDetails> queryWrapper = new QueryWrapper<DModuleDetails>();
        queryWrapper.eq("PARENT_ID", dModule1.getId());

        return dModuleDetailsMapper.selectList(queryWrapper);
    }
}
