package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MProcedureModuleMapper;
import com.hnguigu.service.MProcedureModuleService;
import com.hnguigu.vo.MProcedureModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MProcedureModuleServiceImpl extends ServiceImpl<MProcedureModuleMapper, MProcedureModule> implements MProcedureModuleService {
@Autowired
MProcedureModuleMapper mProcedureModuleMapper;
    /**
     * 根据父级编号查询工序所需的物料-skl
     * @param parentid
     * @return
     */
    @Override
    public List<MProcedureModule> querybyparentid(int parentid) {
        return mProcedureModuleMapper.querybyparentid(parentid);
    }
}
