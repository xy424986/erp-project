package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MDesignProcedureDetailsMapper;
import com.hnguigu.mapper.MDesignProcedureMapper;
import com.hnguigu.service.MDesignProcedureDetailsService;
import com.hnguigu.service.MDesignProcedureService;
import com.hnguigu.vo.MDesignProcedure;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.extend.MDesignProcedureDetailsExtend;
import com.hnguigu.vo.extend.MDesignProcedureExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MDesignProcedureDetailsServiceImpl extends ServiceImpl<MDesignProcedureDetailsMapper, MDesignProcedureDetails> implements MDesignProcedureDetailsService {

    @Autowired
    MDesignProcedureDetailsMapper mDesignProcedureDetailsMapper;

    @Autowired
    MDesignProcedureMapper mDesignProcedureMapper;
    @Autowired
    private MDesignProcedureService mDesignProcedureService;
    /**
     * hhy
     * @param mDesignProcedureExtendList
     * @return
     */
    @Override
    public int updateByPId(List<MDesignProcedureExtend> mDesignProcedureExtendList) {
        MDesignProcedureDetails mDesignProcedureDetails = new MDesignProcedureDetails();

        return 0;
    }

    /**
     * hhy
     * @param mDesignProcedureDetailsExtendList
     * @return
     */
    @Override
    public int update(List<MDesignProcedureDetailsExtend> mDesignProcedureDetailsExtendList) {

        MDesignProcedureDetails mDesignProcedureDetails = new MDesignProcedureDetails();

        Double moduleSubtotal = 0.0;
        for (MDesignProcedureDetailsExtend mDesignProcedureDetailsExtend : mDesignProcedureDetailsExtendList){
            mDesignProcedureDetails.setId(mDesignProcedureDetailsExtend.getmDPDId());
            moduleSubtotal = mDesignProcedureDetailsExtend.getAmount()*mDesignProcedureDetailsExtend.getCostPrice();
        }

        mDesignProcedureDetails.setRegisterTime(new Date());
        mDesignProcedureDetails.setDesignModuleTag("D002-1");
        mDesignProcedureDetails.setModuleSubtotal(moduleSubtotal);
        return mDesignProcedureDetailsMapper.updateById(mDesignProcedureDetails);
    }

    /**
     * hhy
     * @param mDesignProcedureDetails
     * @return
     */
    @Override
    public List<MDesignProcedureDetails> queryByPId(MDesignProcedureDetails mDesignProcedureDetails) {
        QueryWrapper<MDesignProcedureDetails> queryWrapper = new QueryWrapper<MDesignProcedureDetails>();
        queryWrapper.eq("PARENT_ID", mDesignProcedureDetails.getParentId());
        return mDesignProcedureDetailsMapper.selectList(queryWrapper);
    }

    /**
     * hhy
     *
     * @param
     * @return
     */
    @Override
    public int insert(List<MDesignProcedureExtend> mDesignProcedureExtendList) {



        MDesignProcedureDetails mDesignProcedureDetails = new MDesignProcedureDetails();
        int row = 0;
        int id = 1;
        MDesignProcedure mDesignProcedure = new MDesignProcedure();
//        for (MDesignProcedureExtend mDesignProcedureExtend1 : mDesignProcedureExtendList){
        int parentId = mDesignProcedureService.insert(mDesignProcedureExtendList);
        System.out.println(parentId);
        for (MDesignProcedureExtend mDesignProcedureExtend1 : mDesignProcedureExtendList) {
            mDesignProcedureDetails.setProcedureId(mDesignProcedureExtend1.getProcedureId());
            mDesignProcedureDetails.setParentId(parentId);
            mDesignProcedureDetails.setDetailsNumber(id);
            id++;
            mDesignProcedureDetails.setProcedureName(mDesignProcedureExtend1.getProcedureName());
            mDesignProcedureDetails.setLabourHourAmount(mDesignProcedureExtend1.getLabourHourAmount());
            mDesignProcedureDetails.setProcedureDescribe(mDesignProcedureExtend1.getProcedureDescribe());
            mDesignProcedureDetails.setAmountUnit(mDesignProcedureExtend1.getAmountUnit());
            mDesignProcedureDetails.setCostPrice(mDesignProcedureExtend1.getCostPrice());
            mDesignProcedureDetails.setRegister(mDesignProcedureExtend1.getRegister());
            mDesignProcedureDetails.setSubtotal(mDesignProcedureExtend1.getLabourHourAmount() * mDesignProcedureExtend1.getCostPrice());
            mDesignProcedureDetails.setDesignModuleTag("D002-0");
            mDesignProcedureDetails.setDesignModuleChangeTag("D003-0");
            row = mDesignProcedureDetailsMapper.insert(mDesignProcedureDetails);
        }
        return row;
    }
}
