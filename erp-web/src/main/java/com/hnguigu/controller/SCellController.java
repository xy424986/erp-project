package com.hnguigu.controller;


import com.github.pagehelper.PageInfo;
import com.hnguigu.service.SCellService;
import com.hnguigu.util.PageUtil;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SCell;
import com.hnguigu.vo.extend.SCellEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/SCell")
public class SCellController {

    @Autowired
    SCellService sCellService;
    /**
     * 制作安全库存配置单-添加-xyb
     * @param sCell
     * @return
     */
    @RequestMapping("/addScll.May")
    public boolean addSCll(SCell sCell){
        System.out.println(sCell);
        return sCellService.addSCll(sCell);
    }

    /**
     * 安全库存配置单-复核-总数据查询-xyb
     * @return
     */
    @RequestMapping("/queryAllSCell.May")
    public PageUtil<SCellEx> queryAllSCell(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                           @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                           DFile dFile){
        PageInfo<SCellEx> sCellPageInfo = sCellService.queryAllSCll(pageno,pagesize,dFile,"S001-0","");
        PageUtil<SCellEx> pageUtil =new PageUtil<SCellEx>();
        pageUtil.setTotal(sCellPageInfo.getTotal());
        pageUtil.setRows(sCellPageInfo.getList());
        return pageUtil;
    }

    /**
     * 查询安全库存配置单-复核的数据-xyb
     * @param productId
     * @return
     */
    @RequestMapping("/queryByIdSCell.May")
    public SCell queryByIdSCell(String productId, HttpSession session){
        System.out.println("queryByIdDFile的productId"+productId);
        return  sCellService.queryByIdSCell(productId,session);
    }

    /**
     * 查询安全库存配置单中的-复核表格数据-xyb
     * @param productId
     * @return
     */
    @RequestMapping("/queryByIdSCell2.May")
    public List<SCell> queryByIdSCell2(String productId){
        System.out.println("queryByIdDFile2的productId"+productId);
        return  sCellService.queryByIdSCell2(productId);
    }

    /**
     * 安全库存配置单中的-复核-xyb
     * @param id
     * @param sCell
     * @return
     */
    @RequestMapping("/amendCheckTag.May")
    public boolean amendCheckTag(int id,SCell sCell){
        return sCellService.amendCheckTag(id,sCell);
    }


    /**
     * 安全库存配置单-查询-总数据查询-xyb
     * @return
     */
    @RequestMapping("/queryAllSCell2.May")
    public PageUtil<SCellEx> queryAllSCell2(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                         @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                         DFile dFile){
        PageInfo<SCellEx> sCellPageInfo = sCellService.queryAllSCll2(pageno,pagesize,dFile,"S001-1", "S001-2");
        PageUtil<SCellEx> pageUtil =new PageUtil<SCellEx>();
        pageUtil.setTotal(sCellPageInfo.getTotal());
        pageUtil.setRows(sCellPageInfo.getList());
        return pageUtil;
    }


    /**
     * 制作安全库存配置单-修改-xyb
     * @param sCell
     * @return
     */
    @RequestMapping("/amendSCll.May")
    public boolean amendSCll(SCell sCell){
        return sCellService.amendSCll(sCell);
    }


    /**
     * 动态库存查询-查询-总数据查询-xyb
     * @return
     */
    @RequestMapping("/queryAllSCell3.May")
    public PageUtil<SCellEx> queryAllSCell3(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                            @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                            DFile dFile){
        PageInfo<SCellEx> sCellPageInfo = sCellService.queryAllSCll2(pageno,pagesize,dFile,"S001-1","");
        PageUtil<SCellEx> pageUtil =new PageUtil<SCellEx>();
        pageUtil.setTotal(sCellPageInfo.getTotal());
        pageUtil.setRows(sCellPageInfo.getList());
        return pageUtil;
    }
}
