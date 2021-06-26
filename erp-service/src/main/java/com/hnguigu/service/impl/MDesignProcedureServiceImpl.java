package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MDesignProcedureMapper;
import com.hnguigu.service.DFileService;
import com.hnguigu.service.MDesignProcedureService;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.MDesignProcedure;
import com.hnguigu.vo.extend.MDesignProcedureExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class MDesignProcedureServiceImpl extends ServiceImpl<MDesignProcedureMapper, MDesignProcedure> implements MDesignProcedureService {

    @Autowired
    MDesignProcedureMapper mDesignProcedureMapper;

    @Autowired
    DFileService dFileService;

    /**
     * hhy
     * 提交物料设计单
     * @param mDesignProcedureExtendList
     * @return
     */
    @Override
    public int updateByIds(List<MDesignProcedureExtend> mDesignProcedureExtendList) {
        MDesignProcedure mDesignProcedure = new MDesignProcedure();

        Double sum = 0.0;
        for (MDesignProcedureExtend mDesignProcedureExtend : mDesignProcedureExtendList){
            sum += mDesignProcedureExtend.getModuleSubtotal();
            mDesignProcedure.setDesignModuleTag("G002-1");
            mDesignProcedure.setId(mDesignProcedureExtend.getmDPId());
        }
        mDesignProcedure.setModuleCostPriceSum(sum);
        return mDesignProcedureMapper.updateById(mDesignProcedure);
    }

    /**
     * hhy
     * @param mDesignProcedure
     * @return
     */
    @Override
    public int updateByMDP(MDesignProcedure mDesignProcedure) {
        mDesignProcedure.setCheckTime(new Date());
        mDesignProcedure.setCheckTag(mDesignProcedure.getCheckTag());
        return mDesignProcedureMapper.updateById(mDesignProcedure);
    }

    /**
     * hhy
     *
     * @param mDesignProcedureExtend
     * @return
     */
    @Override
    public int insert(List<MDesignProcedureExtend> mDesignProcedureExtend) {

        MDesignProcedure mDesignProcedure = new MDesignProcedure();

        Double priceSum = 0.0;

        int dFileId = 0;

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
            dFileId = mDesignProcedureExtend1.getdFileId();
        }
        mDesignProcedure.setCostPriceSum(priceSum);
//        System.out.println(priceSum);
//        System.out.println(mDesignProcedure);


        dFileService.updateById(dFileId);

        return mDesignProcedureMapper.insert(mDesignProcedure);
    }

    /**
     * hhy
     * @param pageno
     * @param pagesize
     * @param mDesignProcedure
     * @return
     */
    @Override
    public IPage<MDesignProcedure> queryAll(int pageno, int pagesize, MDesignProcedure mDesignProcedure) {
        QueryWrapper<MDesignProcedure> queryWrapper = new QueryWrapper<MDesignProcedure>();

        if (!StringUtils.isEmpty(mDesignProcedure.getCheckTag())) {
            queryWrapper.eq("CHECK_TAG", mDesignProcedure.getCheckTag());
        }

//        if (!StringUtils.isEmpty(mDesignProcedure.getProductName())) {
//            queryWrapper.like("name", mDesignProcedure.getProductName());
//        }
        return this.page(new Page<MDesignProcedure>(pageno,pagesize), queryWrapper);
    }
    /**
     * 根据产品编号查询产品生产工序数据-skl
     * @param productId
     * @return
     */
    @Override
    public MDesignProcedure queryByproductID(String productId) {
        return mDesignProcedureMapper.queryByproductID(productId);
    }
}
