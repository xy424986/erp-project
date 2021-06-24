package com.hnguigu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.util.OutInStorage;
import com.hnguigu.util.Scheduling;
import com.hnguigu.util.SchedulingOutbound;
import com.hnguigu.vo.SGather;
import com.hnguigu.vo.SPay;
import com.hnguigu.vo.extend.SGatherEx;
import com.hnguigu.vo.extend.SPayEX;

import java.util.List;

public interface SPayService extends IService<SPay> {
    /**
     * 出库调度-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sPay
     * @return
     */
    IPage<SPay> queryAllSPay(int pageNo, int pageSize, SPay sPay);

    /**
     * 出库调度-总数据-调度查询-xyb
     * @param payId
     * @return
     */
    SPay queryByPayIdSPay(String payId);
    /**
     * 出库调度单-查询-xyb
     * @param id 产品编号
     * @return
     */
    SPayEX queryByIdSPayEX(int id);
    /**
     * 出库调度-xyb
     * @param schedulingOutbound 出库调度特制beng
     * @return
     */
    String addSPay(SchedulingOutbound schedulingOutbound);
    /**
     * 出库-复核-xyb
     * @param sPay
     * @return
     */
    boolean amendSPay(SPay sPay);
    /**
     * 出库登记-xyb
     * @param outInStorages
     * @return
     */
    boolean addOutInStorage(List<OutInStorage> outInStorages);
}
