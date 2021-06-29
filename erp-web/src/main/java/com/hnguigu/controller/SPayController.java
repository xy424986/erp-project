package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.service.SPayService;
import com.hnguigu.util.OutInStorage;
import com.hnguigu.util.PutInStorage;
import com.hnguigu.util.Scheduling;
import com.hnguigu.util.SchedulingOutbound;
import com.hnguigu.vo.SPay;
import com.hnguigu.vo.extend.SGatherEx;
import com.hnguigu.vo.extend.SPayEX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/SPay")
public class SPayController {

    @Autowired
    SPayService sPayService;

    /**
     * chu库调度-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sPay
     * @return
     */
    @RequestMapping("/queryAllSPay.May")
    public IPage<SPay> qyeryAllSPay(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo,
                                    @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                    SPay sPay){
        return sPayService.queryAllSPay(pageNo,pageSize,sPay);
    }

    /**
     * 出库调度-总数据-调度查询-xyb
     * @param payId
     * @return
     */
    @RequestMapping("/queryByPayIdSPay.May")
    public SPay queryByPayIdSPay(String payId){
        return sPayService.queryByPayIdSPay(payId);
    }

    /**
     * 出库调度单-查询-xyb
     * @param id 产品编号
     * @return
     */
    @RequestMapping("/queryByIdSPayEX.May")
    public SPayEX queryByIdSPayEX(int id){
        System.out.println("queryByIdSPayEX"+id);
        return sPayService.queryByIdSPayEX(id);
    }
    /**
     * 出库调度-xyb
     * @param schedulingOutbound 出库调度特制beng
     * @return
     */
    /*@RequestMapping(value = "/addSGath.May",produces = {"text/json;charset=utf-8"})*/
    @RequestMapping("/addSPay.May")
    public String addSPay(SchedulingOutbound schedulingOutbound){
        System.out.println("addSPay-SchedulingOutbound:"+schedulingOutbound);
        return sPayService.addSPay(schedulingOutbound);
    }
    /**
     * 出库-复核-xyb
     * @param sPay
     * @return
     */
    @RequestMapping("/amendSPay.May")
    public boolean amendSPay(SPay sPay){
        return sPayService.amendSPay(sPay);
    }
    /**
     * 出库登记-xyb
     * @param outInStorages
     * @return
     */
    @RequestMapping(value = "/addOutInStorage.May", produces = {"text/json;charset=utf-8"})
    public String addOutInStorage(@RequestBody List<OutInStorage> outInStorages){
        boolean b = sPayService.addOutInStorage(outInStorages);
        if (b)
            return "true";
        return "false";
    }
    /**
     * chu库登记-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sPay
     * @return
     */
    @RequestMapping("/queryAllSPay1.May")
    public IPage<SPay> qyeryAllSPay1(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo,
                                    @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                    SPay sPay){

        return sPayService.queryAllSPay1(pageNo,pageSize,sPay);
    }
    /**
     * chu库复核-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sPay
     * @return
     */
    @RequestMapping("/queryAllSPay2.May")
    public IPage<SPay> qyeryAllSPay2(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo,
                                     @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                     SPay sPay){
        sPay.setCheckTag("S001-0");
        return sPayService.queryAllSPay1(pageNo,pageSize,sPay);
    }
    /**
     * chu库查询-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sPay
     * @return
     */
    @RequestMapping("/queryAllSPay3.May")
    public IPage<SPay> qyeryAllSPay3(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo,
                                     @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                     SPay sPay){
        sPay.setCheckTag("S001-1");
        return sPayService.queryAllSPay1(pageNo,pageSize,sPay);
    }
}
