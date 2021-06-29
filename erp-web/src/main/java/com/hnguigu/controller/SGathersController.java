package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.service.SGatherService;
import com.hnguigu.util.PutInStorage;
import com.hnguigu.util.Scheduling;
import com.hnguigu.vo.SCell;
import com.hnguigu.vo.SGather;
import com.hnguigu.vo.extend.SGatherEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 入库登记-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sGather
     * @return
     */
    @RequestMapping("/queryAllSGather1.May")
    public IPage<SGather> queryAllSGather1(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo,
                                          @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                          SGather sGather){

        return sGatherService.queryAllSGather1(pageNo,pageSize,sGather);
    }
    /**
     * 入库复核-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sGather
     * @return
     */
    @RequestMapping("/queryAllSGather2.May")
    public IPage<SGather> queryAllSGather2(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo,
                                           @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                           SGather sGather){
        sGather.setCheckTag("S001-0");
        return sGatherService.queryAllSGather1(pageNo,pageSize,sGather);
    }
    /**
     * 入库查询-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sGather
     * @return
     */
    /**
     * 入库复核-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sGather
     * @return
     */
    @RequestMapping("/queryRuKuAllSGather.May")
    public IPage<SGather> queryRuKuAllSGather(@RequestParam(value = "pageNo",defaultValue = "1")int pageNo,
                                           @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                                           SGather sGather){
        return sGatherService.queryRuKuAllSGather(pageNo,pageSize,sGather);
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
    @RequestMapping(value ="/addSGath.May",produces = {"text/json;charset=utf-8"})
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

    /**
     * 入库登记-xyb
     * @param putInStorages
     * @return
     */
    @RequestMapping(value = "/addPutInStorage.May", produces = {"text/json;charset=utf-8"})
    public String addPutInStorage(@RequestBody List<PutInStorage> putInStorages){
        boolean b = sGatherService.addPutInStorage(putInStorages);
        if (b)
            return "true";
        return "false";
    }
}
