package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MDesignProcedureMapper;
import com.hnguigu.service.MDesignProcedureService;
import com.hnguigu.vo.MDesignProcedure;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.extend.MDesignProcedureExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MDesignProcedureServiceImpl extends ServiceImpl<MDesignProcedureMapper, MDesignProcedure> implements MDesignProcedureService {

    @Autowired
    MDesignProcedureMapper mDesignProcedureMapper;

    /**
     * hhy
     *
     * @param mDesignProcedureExtend
     * @return
     */
    @Override
    public int insert(List<MDesignProcedureExtend> mDesignProcedureExtend) {

        MDesignProcedure mDesignProcedure = new MDesignProcedure();
        MDesignProcedureDetails mDesignProcedureDetails = new MDesignProcedureDetails();

        Double priceSum = 0.0;

        for (MDesignProcedureExtend mDesignProcedureExtend1 : mDesignProcedureExtend) {
            mDesignProcedure.setDesignId("001");
            mDesignProcedure.setProductId(mDesignProcedureExtend1.getProductId());
            mDesignProcedure.setProductName(mDesignProcedureExtend1.getProductName());
            mDesignProcedure.setProcedureDescribe(mDesignProcedureExtend1.getProcedureDescribe1());
            mDesignProcedure.setDesigner(mDesignProcedureExtend1.getDesigner());
            mDesignProcedure.setRegister(mDesignProcedureExtend1.getRegister());
            mDesignProcedure.setRegisterTime(new Date());
            mDesignProcedure.setCheckTag("S001-0");
            mDesignProcedure.setChangeTag("B002-0");
            mDesignProcedure.setDesignModuleTag("G002-0");
            mDesignProcedure.setDesignModuleChangeTag("G003-0");
            priceSum += mDesignProcedureExtend1.getLabourHourAmount()*mDesignProcedureExtend1.getCostPrice();
        }
        mDesignProcedure.setCostPriceSum(priceSum);
//        System.out.println(priceSum);
//        System.out.println(mDesignProcedure);

        return mDesignProcedureMapper.insert(mDesignProcedure);
    }
}
