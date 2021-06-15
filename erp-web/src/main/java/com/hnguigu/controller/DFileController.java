package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hnguigu.service.DFileService;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.DModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/DFile")
public class DFileController {

    @Autowired
    DFileService dFileService;

    /**
     * hhy
     * 根据复核状态查询生产工序设计单数据
     * 状态：
     * S001-0: 等待审核
     * S001-1: 审核通过
     * S001-2: 审核不通过
     * @return
     */
    @RequestMapping("queryByState.action")
    public IPage<DFile> queryByState(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                    @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                    DFile dFile){

        return dFileService.queryAllDFile(pageNumber, pageSize, dFile);
    }

    /**xyb
     * 查询安全库存配置单表格数据-xyb
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    @RequestMapping("/queryAllDFile.May")
    public IPage<DFile> queryAllDFile(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                      @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                      DFile dFile){
        return  dFileService.queryAllDFile(pageno,pagesize,dFile);
    }

    /**xyb
     * 查询安全库存配置单的数据
     * @param productId
     * @return
     */
    @RequestMapping("/queryByIdDFile.May")
    public DFile queryByIdDFile(String productId){
        System.out.println("queryByIdDFile的productId"+productId);
        return  dFileService.queryByIdDFile(productId);
    }

    /**xyb
     * 查询安全库存配置单中的表格数据
     * @param productId
     * @return
     */
    @RequestMapping("/queryByIdDFile2.May")
    public List<DFile> queryByIdDFile2(String productId){
        System.out.println("queryByIdDFile2的productId"+productId);
        return  dFileService.queryByIdDFile2(productId);
    }
}

