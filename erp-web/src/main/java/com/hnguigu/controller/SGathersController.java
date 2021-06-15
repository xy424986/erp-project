package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.hnguigu.service.SGatherService;
import com.hnguigu.util.Scheduling;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SGather;
import com.hnguigu.vo.ex.SGatherEx;
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
     * @param productId 产品编号
     * @return
     */
    @RequestMapping("/queryByIdSGather.May")
    public SGatherEx queryByIdSGather(String productId){
        System.out.println("queryByIdSGather"+productId);
        return sGatherService.queryByIdSGatherEx(productId);
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
}
