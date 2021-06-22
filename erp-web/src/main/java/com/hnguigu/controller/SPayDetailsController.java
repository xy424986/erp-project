package com.hnguigu.controller;

import com.hnguigu.service.SPayDetailsService;
import com.hnguigu.vo.SGather;
import com.hnguigu.vo.SPay;
import com.hnguigu.vo.extend.SGatherEx;
import com.hnguigu.vo.extend.SPayEX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/SPayDetails")
public class SPayDetailsController {
    @Autowired
    SPayDetailsService sPayDetailsService;

    /**
     * 出库调度单中的表格-xyb
     * @param parentId PARENT_ID与S_GATHER的ID相对应，为外键
     * @return
     */
    @RequestMapping("/queryByParentIdSPayDetails.May")
    public List<SPayEX> queryByParentIdSPayDetails(String parentId){
        System.out.println("queryByParentIdSPayDetails-parentId:"+parentId);
        return sPayDetailsService.queryByParentIdSPayDetails(parentId);
    }
    /**
     * 出库查询-查看-xyb
     * @param id
     * @return
     */
    @RequestMapping("/queryByIdSPayEX.May")
    public SPayEX queryByIdSPayEX(int id){
        return sPayDetailsService.queryByIdSPayEX(id);
    }
    /**
     * 出库查询-查看-表格-xyb
     * @param id
     * @return
     */
    @RequestMapping("/queryByIdSPayEX2.May")
    public List<SPayEX> queryByIdSPayEX2(int id){
        return sPayDetailsService.queryByIdSPayEX2(id);
    }

}
