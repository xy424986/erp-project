package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MProcedureMapper;
import com.hnguigu.service.MProcedureService;
import com.hnguigu.vo.MProcedure;
import com.hnguigu.vo.MProcedureModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MProcedureServiceImpl extends ServiceImpl<MProcedureMapper, MProcedure> implements MProcedureService {
    @Autowired
    MProcedureMapper mProcedureMapper;
    /**
     * 根据父级id查询产品生产工序
     * @param id
     * @return
     */
    @Override
    public List<MProcedure> queryByparentID(int id) {
        return mProcedureMapper.queryByparentID(id);
    }

    @Override
    public List<MProcedure> queryByparentIDtwo(int id) {
        return mProcedureMapper.queryByparentIDtwo(id);
    }
}
