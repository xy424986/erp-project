package com.hnguigu.controller;

import com.hnguigu.service.SGatherDetailsService;
import com.hnguigu.vo.SGatherDetails;
import com.hnguigu.vo.extend.SGatherEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/queryByParentIdSGatherDetails.May")
    public List<SGatherEx> queryByParentIdSGatherDetails(String parentId){
        System.out.println("queryByParentIdSGatherDetails"+parentId);
        List<SGatherEx> sGatherExes = sGatherDetailsService.queryByParentIdSGatherDetails(parentId);
        for (SGatherEx s:sGatherExes) {
            System.out.println(s);
        }
        return sGatherExes;
    }


}
