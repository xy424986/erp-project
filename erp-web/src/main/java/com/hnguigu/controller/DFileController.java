package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hnguigu.service.DFileService;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.DModule;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DFile> queryByState(){
        return dFileService.queryByState("S001-1");
    }

    @RequestMapping("/queryAllDFile.May")
    public IPage<DFile> queryAllDFile(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                      @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                      DFile dFile){
        return  dFileService.page(new Page<DFile>(pageno,pagesize),null);
    }
    @RequestMapping("/queryByIdDFile.May")
    public DFile queryByIdDFile(String productId){
        System.out.println("productId"+productId);
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PRODUCT_ID",productId);
        return  dFileService.getOne(queryWrapper);
    }
    @RequestMapping("/queryByIdDFile2.May")
    public List<DFile> queryByIdDFile2(String productId){
        System.out.println("productId"+productId);
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PRODUCT_ID",productId);
        return  dFileService.list(queryWrapper);
    }
}

