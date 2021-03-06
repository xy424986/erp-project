package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.DFileMapper;
import com.hnguigu.mapper.MDesignProcedureMapper;
import com.hnguigu.service.DFileService;
import com.hnguigu.service.MDesignProcedureService;
import com.hnguigu.util.IdUtil;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.MApply;
import com.hnguigu.vo.MDesignProcedure;
import com.hnguigu.vo.extend.MDesignProcedureExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MDesignProcedureServiceImpl extends ServiceImpl<MDesignProcedureMapper, MDesignProcedure> implements MDesignProcedureService {

    @Autowired
    MDesignProcedureMapper mDesignProcedureMapper;

    @Autowired
    DFileService dFileService;

    @Autowired
    DFileMapper dFileMapper;

    /**
     * hhy
     * 提交物料设计单
     *
     * @param mDesignProcedureExtendList
     * @return
     */
    @Override
    public int updateByIds(List<MDesignProcedureExtend> mDesignProcedureExtendList) {
        MDesignProcedure mDesignProcedure = new MDesignProcedure();

        Double sum = 0.0;
        for (MDesignProcedureExtend mDesignProcedureExtend : mDesignProcedureExtendList) {
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
        DFile dFile = new DFile();
        if(!StringUtils.isEmpty(mDesignProcedure.getDFileId())){
            dFile.setId(mDesignProcedure.getDFileId());
        }
        if(!StringUtils.isEmpty(mDesignProcedure.getDesignProcedureTag())){
            dFile.setDesignProcedureTag(mDesignProcedure.getDesignProcedureTag());
        }
        if(!StringUtils.isEmpty(mDesignProcedure.getDFileId())){
            dFileMapper.updateById(dFile);
        }
        mDesignProcedure.setCheckTime(new Date());
        if (!StringUtils.isEmpty(mDesignProcedure.getCheckTag())) {
            mDesignProcedure.setCheckTag(mDesignProcedure.getCheckTag());
        }
        if (!StringUtils.isEmpty(mDesignProcedure.getDesignModuleTag())) {
            mDesignProcedure.setDesignModuleTag(mDesignProcedure.getDesignModuleTag());
        }
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
        IdUtil idUtil = new IdUtil();
        Double priceSum = 0.0;
        int dFileId = 0;
        List<MDesignProcedure> list = this.list();
        if (list.size() != 0) {
            MDesignProcedure mDesignProcedure1 = list.get(list.size() - 1);
            String procedureId = idUtil.DesignProcedureId(mDesignProcedure1);
            mDesignProcedure.setDesignId(procedureId);//设计编号
        } else {
            //获取当前时间
            Date dt = new Date();
            SimpleDateFormat matter1 = new SimpleDateFormat("yyyyMMdd");
            String date = matter1.format(dt);
            mDesignProcedure.setDesignId("201" + date + "00001");//设计编号
            System.out.println("201" + date + "00001");
        }

        for (MDesignProcedureExtend mDesignProcedureExtend1 : mDesignProcedureExtend) {
            mDesignProcedure.setProductId(mDesignProcedureExtend1.getProductId());//产品编号
            mDesignProcedure.setProductName(mDesignProcedureExtend1.getProductName());
            mDesignProcedure.setProcedureDescribe(mDesignProcedureExtend1.getProcedureDescribe1());
            mDesignProcedure.setDesigner(mDesignProcedureExtend1.getDesigner());
            mDesignProcedure.setRegister(mDesignProcedureExtend1.getRegister());
            mDesignProcedure.setRegisterTime(new Date());
            mDesignProcedure.setCheckTag("S001-0");
            mDesignProcedure.setChangeTag("B002-0");
            mDesignProcedure.setDesignModuleTag("G002-0");
            mDesignProcedure.setDesignModuleChangeTag("G003-0");
            priceSum += mDesignProcedureExtend1.getLabourHourAmount() * mDesignProcedureExtend1.getCostPrice();
            dFileId = mDesignProcedureExtend1.getdFileId();
        }
        mDesignProcedure.setCostPriceSum(priceSum);

        dFileService.updateById(dFileId);
        boolean save = this.save(mDesignProcedure);
        return mDesignProcedure.getId();
    }

    /**
     * hhy
     *
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
        if (!StringUtils.isEmpty(mDesignProcedure.getDesignModuleTag())) {
            queryWrapper.eq("DESIGN_MODULE_TAG", mDesignProcedure.getDesignModuleTag());
        }

//        if (!StringUtils.isEmpty(mDesignProcedure.getProductName())) {
//            queryWrapper.like("name", mDesignProcedure.getProductName());
//        }
        return this.page(new Page<MDesignProcedure>(pageno, pagesize), queryWrapper);
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
