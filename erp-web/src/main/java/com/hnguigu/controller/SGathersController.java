package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.service.SGatherService;
import com.hnguigu.util.Scheduling;
import com.hnguigu.vo.SCell;
import com.hnguigu.vo.SGather;
import com.hnguigu.vo.extend.SGatherEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/SGathers")
public class SGathersController {

    @Autowired
    SGatherService sGatherService;
    /**
     * 入库调度-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sGather
     * @return
     */
    @RequestMapping("/queryAllSGather.May")
    public IPage<SGather> queryAllSGather(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo,
                                          @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                          SGather sGather){
        return sGatherService.queryAllSGather(pageNo,pageSize,sGather);
    }

    /**
     * 入库调度单-查询-xyb
     * @param id 产品编号
     * @return
     */
    @RequestMapping("/queryByIdSGather.May")
    public SGatherEx queryByIdSGather(int id){
        System.out.println("queryByIdSGather"+id);
        SGatherEx sGatherEx = sGatherService.queryByIdSGatherEx(id);
        return sGatherEx;
    }

    /**
     * 入库调度-xyb
     * @param scheduling 入库调度特制beng
     * @return
     */
    /*@RequestMapping(value = "/addSGath.May",produces = {"text/json;charset=utf-8"})*/
    @RequestMapping("/addSGath.May")
    public String addSGath(Scheduling scheduling){
        return sGatherService.addSGather(scheduling);
    }

    /**
     * 入库调度单总调度-xyb
     * @param gatherId 入库编号
     * @return
     */
    @RequestMapping("/queryByGatherIdSGather.May")
    public SGather queryByGatherIdSGather(String gatherId){
        return sGatherService.queryByGatherIdSGather(gatherId);
    }

    /**
     * 入库-复核-xyb
     * @param sGather
     * @return
     */
    @RequestMapping("/amendSGather.May")
    public boolean amendSGather(SGather sGather){
        return sGatherService.amendSGather(sGather);
    }

}
