package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
     * 物料组成查询
     * @param pageno
     * @param pagesize
     * @return
     */
    @Override
    public PageInfo<DModule> query_design_sheetdata(int pageno, int pagesize) {
        // 设置分页参数
        PageHelper.startPage(pageno, pagesize);
        List<DModule> dModules = dModuleMapper.query_design_sheetdata();
        // 封装分页对象
        PageInfo<DModule> dModulePageInfo = new PageInfo<>(dModules);
        return dModulePageInfo;
    }

    /**
     * hhy
     * @param dModule
     * @return
     */
    @Override
    public DModule queryByDesignId(DModule dModule) {
        QueryWrapper<DModule> queryWrapper = new QueryWrapper<DModule>();
        queryWrapper.eq("DESIGN_ID", dModule.getDesignId());
        return dModuleMapper.selectOne(queryWrapper);
    }

}
