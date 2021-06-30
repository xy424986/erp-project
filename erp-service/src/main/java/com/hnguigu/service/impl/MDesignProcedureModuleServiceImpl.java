package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.DModuleDetailsMapper;
import com.hnguigu.mapper.MDesignProcedureModuleMapper;
import com.hnguigu.service.MDesignProcedureModuleService;
import com.hnguigu.vo.DModuleDetails;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.MDesignProcedureModule;
import com.hnguigu.vo.extend.MDesignProcedureDetailsExtend;
import com.hnguigu.vo.extend.MDesignProcedureExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MDesignProcedureModuleServiceImpl extends ServiceImpl<MDesignProcedureModuleMapper, MDesignProcedureModule> implements MDesignProcedureModuleService {

    @Autowired
    MDesignProcedureModuleMapper mDesignProcedureModuleMapper;


    @Autowired
    DModuleDetailsMapper dModuleDetailsMapper;

    /**
     * hhy
     * @param mDesignProcedureDetailsExtendList
     * @return
     */
    @Override
    public int insert(List<MDesignProcedureDetailsExtend> mDesignProcedureDetailsExtendList) {

        MDesignProcedureModule mDesignProcedureModule = new MDesignProcedureModule();
        DModuleDetails dModuleDetails = new DModuleDetails();
        int row = 0;
        int id = 1;
        for (MDesignProcedureDetailsExtend mDesignProcedureDetailsExtend : mDesignProcedureDetailsExtendList) {
            mDesignProcedureModule.setParentId(mDesignProcedureDetailsExtend.getmDPDId());
            mDesignProcedureModule.setDetailsNumber(id);
            mDesignProcedureModule.setProductId(mDesignProcedureDetailsExtend.getProductId());
            mDesignProcedureModule.setProductName(mDesignProcedureDetailsExtend.getProductName());
            mDesignProcedureModule.setAmount(mDesignProcedureDetailsExtend.getAmount());
            mDesignProcedureModule.setProductDescribe(mDesignProcedureDetailsExtend.getProductDescribe());
            mDesignProcedureModule.setAmountUnit(mDesignProcedureDetailsExtend.getAmountUnit());
            mDesignProcedureModule.setCostPrice(mDesignProcedureDetailsExtend.getCostPrice());
            mDesignProcedureModule.setSubtotal(mDesignProcedureDetailsExtend.getAmount() * mDesignProcedureDetailsExtend.getCostPrice());
            id++;
            row = mDesignProcedureModuleMapper.insert(mDesignProcedureModule);

            UpdateWrapper<DModuleDetails> updateWrapper = new UpdateWrapper<DModuleDetails>();
            updateWrapper.eq("PRODUCT_ID", mDesignProcedureDetailsExtend.getProductId());
            dModuleDetails.setResidualAmount(mDesignProcedureDetailsExtend.getResidualAmount()-mDesignProcedureDetailsExtend.getAmount1());
            dModuleDetailsMapper.update(dModuleDetails, updateWrapper);
        }
        return row;
    }

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

    @Override
    public List<MDesignProcedureModule> queryByparentId(int id) {
        return mDesignProcedureModuleMapper.queryByparentId(id);
    }
}
