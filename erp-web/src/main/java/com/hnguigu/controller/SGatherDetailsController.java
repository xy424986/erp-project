package com.hnguigu.controller;

import com.hnguigu.service.SGatherDetailsService;
import com.hnguigu.vo.SGatherDetails;
import com.hnguigu.vo.extend.SGatherEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("SGatherDetails")
public class SGatherDetailsController {
    @Autowired
    SGatherDetailsService sGatherDetailsService;
    /**
     * 入库调度单中的表格-xyb
     * @param parentId PARENT_ID与S_GATHER的ID相对应，为外键
     * @return
     */
    @RequestMapping("/queryByParentIdSGatherEx.May")
    public List<SGatherEx> queryByParentIdSGatherDetails(String parentId){
        System.out.println("queryByParentIdSGatherDetails"+parentId);
        return sGatherDetailsService.queryByParentIdSGatherDetails(parentId);
    }

    /**
     * 入库查询-查看-xyb
     * @param id
     * @return
     */
    @RequestMapping("/queryByIdSGatherEx.May")
    public SGatherEx queryByIdSGatherEx(int id){
        return sGatherDetailsService.queryByIdSGatherEx(id);
    }
    /**
     * 入库查询-查看-表格-xyb
     * @param id
     * @return
     */
    @RequestMapping("/queryByIdSGatherEx2.May")
    public List<SGatherEx> queryByIdSGatherEx2(int id){
        return sGatherDetailsService.queryByIdSGatherEx2(id);
    }
}
