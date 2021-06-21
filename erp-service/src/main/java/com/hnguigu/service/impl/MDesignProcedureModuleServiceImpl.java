package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MDesignProcedureModuleMapper;
import com.hnguigu.service.MDesignProcedureModuleService;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.MDesignProcedureModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MDesignProcedureModuleServiceImpl extends ServiceImpl<MDesignProcedureModuleMapper, MDesignProcedureModule> implements MDesignProcedureModuleService {

    @Autowired
    MDesignProcedureModuleMapper mDesignProcedureModuleMapper;

    /**
     * hhy
     * @param mDesignProcedureModule
     * @return
     */
    @Override
    public List<MDesignProcedureModule> queryByPId(MDesignProcedureModule mDesignProcedureModule) {
        QueryWrapper<MDesignProcedureModule> queryWrapper = new QueryWrapper<MDesignProcedureModule>();
        queryWrapper.eq("PARENT_ID", mDesignProcedureModule.getParentId());
        return mDesignProcedureModuleMapper.selectList(queryWrapper);
    }
}
