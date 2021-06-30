package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.hnguigu.mapper.SCellMapper;
import com.hnguigu.mapper.SPayDetailsMapper;
import com.hnguigu.mapper.SPayMapper;
import com.hnguigu.service.SPayService;
import com.hnguigu.util.OutInStorage;
import com.hnguigu.util.SchedulingOutbound;
import com.hnguigu.vo.*;
import com.hnguigu.vo.extend.SPayEX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SPayServiceImpl extends ServiceImpl<SPayMapper, SPay> implements SPayService {

    @Autowired
    SPayMapper sPayMapper;
    @Autowired
    SCellMapper sCellMapper;
    @Autowired
    SPayDetailsMapper sPayDetailsMapper;
    /**
     * 出库调度-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sPay
     * @return
     */
    @Override
    public IPage<SPay> queryAllSPay(int pageNo, int pageSize, SPay sPay) {
        QueryWrapper<SPay> sPayQueryWrapper = new QueryWrapper<>();
        if (!StringUtil.isEmpty(sPay.getPayId())&&!"undefined".equals(sPay.getPayId())) {
            sPayQueryWrapper.eq("PAY_ID", sPay.getPayId());
        }
        sPayQueryWrapper.eq("PAY_TAG","K002-1");

        return  this.page(new Page<SPay>(pageNo, pageSize), sPayQueryWrapper);

    }
    /**
     * 出库管理-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sPay
     * @return
     */
    @Override
    public IPage<SPay> queryAllSPay1(int pageNo, int pageSize, SPay sPay) {
        QueryWrapper<SPay> sPayQueryWrapper = new QueryWrapper<>();
        if (!StringUtil.isEmpty(sPay.getPayId())&&!"undefined".equals(sPay.getPayId())) {
            sPayQueryWrapper.eq("PAY_ID", sPay.getPayId());
        }
        sPayQueryWrapper.eq("PAY_TAG","K002-2");
        if (!StringUtil.isEmpty(sPay.getCheckTag())) {
            sPayQueryWrapper.eq("CHECK_TAG", sPay.getCheckTag());
        }
        return  this.page(new Page<SPay>(pageNo, pageSize), sPayQueryWrapper);
    }
    /**
     * chu库查询-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sPay
     * @return
     */
    @Override
    public IPage<SPay> queryChuKuAllSPay(int pageNo, int pageSize, SPay sPay) {
        QueryWrapper<SPay> sPayQueryWrapper = new QueryWrapper<>();
        if (!StringUtil.isEmpty(sPay.getPayId())&&!"undefined".equals(sPay.getPayId())) {
            sPayQueryWrapper.eq("PAY_ID", sPay.getPayId());
        }
        sPayQueryWrapper.eq("PAY_TAG","K002-2");
        sPayQueryWrapper.eq("CHECK_TAG","S001-2");
        sPayQueryWrapper.or();
        sPayQueryWrapper.eq("CHECK_TAG","S001-1");
        return  this.page(new Page<SPay>(pageNo, pageSize), sPayQueryWrapper);
    }

    /**
     * 出库调度-总数据-调度查询-xyb
     * @param payId
     * @return
     */
    @Override
    public SPay queryByPayIdSPay(String payId) {
        QueryWrapper<SPay> sPayQueryWrapper = new QueryWrapper<>();
        sPayQueryWrapper.eq("PAY_ID",payId);
        return this.getOne(sPayQueryWrapper);
    }

    /**
     * 出库调度单-查询-xyb
     * @param id 产品编号
     * @return
     */
    @Override
    public SPayEX queryByIdSPayEX(int id) {
        return sPayMapper.queryByIdSPayEX(id);
    }
    /**
     * 出库调度-xyb
     * @param schedulingOutbound 出库调度特制beng
     * @return
     */
    @Transactional
    @Override
    public String addSPay(SchedulingOutbound schedulingOutbound) {
        System.out.println("SchedulingOutbound"+schedulingOutbound);



        //b)如果是生产出库，则应把相应的出库产品数量更新到生产工序物料的补充数量中
        QueryWrapper<SPayDetails> sPayDetailsQueryWrapper = new QueryWrapper<>();
        sPayDetailsQueryWrapper.eq("PRODUCT_ID",schedulingOutbound.getProductId());
        SPayDetails sPayDetails = sPayDetailsMapper.selectOne(sPayDetailsQueryWrapper);

        QueryWrapper<SPay> sPayQueryWrapper = new QueryWrapper<>();
        sPayQueryWrapper.eq("PAY_ID", schedulingOutbound.getPayId());
        SPay sPay = this.getOne(sPayQueryWrapper);
        sPay.setAmountSum(sPay.getAmountSum()+schedulingOutbound.getAmount());//总确认数

        // 本次出库数量=应出库数
        if (sPayDetails.getAmount().equals(schedulingOutbound.getAmount())){
            // 本次出库数量<=当前存储量
            QueryWrapper<SCell> sCellQueryWrapper = new QueryWrapper<>();
            sCellQueryWrapper.eq("PRODUCT_ID",schedulingOutbound.getProductId());
            SCell sCell = sCellMapper.selectOne(sCellQueryWrapper);

            if(sCell.getAmount()<=schedulingOutbound.getAmount()){
                System.out.println(sCell.getAmount()+"本次出库数量过大,仓库储存不足"+schedulingOutbound.getAmount());
                return "本次出库数量过大,仓库储存不足";
            }
            // 保存时：
            // a)当前存储量=当前存储量—本次出库数量
            int sCellAmount2=sCell.getAmount()-schedulingOutbound.getAmount();
            sCell.setAmount(sCellAmount2);//当前储存

            sPayDetails.setPayTag("K002-2");//明细-已调度
            sPayDetails.setPayAss(schedulingOutbound.getAss());//储存地址集合
            sPayDetails.setPaidAmount(schedulingOutbound.getAmount());//确认出库数量
            //连接查询
            List<SPayEX> sPayEXES = sPayDetailsMapper.queryByParentIdSPayDetails1(schedulingOutbound.getScellformId());
            //判断明细表里的入库标志为K002-1字段是否只有一条
            //只有一条就证明:这条明细记录入库标志为K002-1
            //修改完这条就没有不调用的明细记录,可进入if判断修改入库表库存标志为K002-2(以调用)
            System.out.println("addSGather中的sGatherDetails1.getProductId:"+schedulingOutbound.getProductId());
            System.out.println("addSGather中的sGatherDetails1.size:"+sPayEXES.size());
            if (sPayEXES.size() ==1){
                System.out.println("进入if方法");
                sPay.setPayTag("K002-2");//已调度
            }

            sPay.setAttemper(schedulingOutbound.getAttemper());//调度人
            sPay.setAttemperTime(schedulingOutbound.getAttemperTime());//调度时间;

           // 如果是生产出库，则应把相应的出库产品数量更新到生产工序物料的补充数量中


            UpdateWrapper<SPay> sPayUpdateWrapper = new UpdateWrapper<>();
            sPayUpdateWrapper.eq("PAY_ID",schedulingOutbound.getPayId());

            sCellMapper.updateById(sCell);//添加当前储存
            sPayDetailsMapper.updateById(sPayDetails);//修改入库标志
            boolean save = this.update(sPay,sPayUpdateWrapper);
            if (save)
                return "出库成功!";
        }else {
            System.out.println(sPayDetails.getAmount()+"本次出库数量应该与应出库数量一致!"+schedulingOutbound.getAmount());
            return "本次出库数量应该与应入库数量一致!";
        }
        return "出库失败!";
    }
    /**
     * 出库-复核-xyb
     * @param sPay
     * @return
     */
    @Override
    public boolean amendSPay(SPay sPay) {
        return this.updateById(sPay);
    }
    /**
     * 出库登记-xyb
     * @param outInStorages
     * @return
     */
    @Transactional
    @Override
    public boolean addOutInStorage(List<OutInStorage> outInStorages) {
        SPay sPay = new SPay();
        SPayDetails sPayDetails = new SPayDetails();
        UpdateWrapper<SPay> sPayUpdateWrapper = new UpdateWrapper<>();
        Integer sum=0;
        int i = 0;
        for (OutInStorage out:outInStorages) {
            System.out.println("addOutInStorage-outInStorages:"+out);
            sPayDetails.setId(out.getId());//明细表-id
            sPayDetails.setPaidAmount(out.getGatheredAmount());//明细表-确认入库件数
            sum+=out.getGatheredAmount();//确认入库总件数
            if (!StringUtil.isEmpty(out.getRegister())) {
                System.out.println("out.getRegister():"+out.getRegister());
                sPay.setRegister(out.getRegister());//登记人
            }
            if (out.getRegisterTime()!=null){
                System.out.println("out.getRegisterTime():"+out.getRegisterTime());
                sPay.setRegisterTime(out.getRegisterTime());//登记时间
            }
            if (!StringUtil.isEmpty(out.getGatherId())) {
                System.out.println("out.getGatherId():"+out.getGatherId());
                sPayUpdateWrapper.eq("GATHER_ID",out.getGatherId());//用入库单号做条件
            }
            sPayDetails.setPayTag("K002-1");//明细表状态已调度
            i = sPayDetailsMapper.updateById(sPayDetails);//修改入库明细表
        }
        sPay.setCheckTag("S001-0");//等待审核
        sPay.setPayTag("K002-1");//已调度
        sPay.setPaidAmountSum(sum);//确认入库总件数
        System.out.println("i:"+i);
        boolean update = this.update(sPay,sPayUpdateWrapper);
        System.out.println("update:"+update);
        return update;//修改入库表
    }
}
