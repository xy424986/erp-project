package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.service.MManuFactureService;
import com.hnguigu.vo.MManuFacture;
import com.hnguigu.vo.extend.MManuFactureEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("MManuFacture")
public class MManuFactureController {
    @Autowired
    MManuFactureService mManuFactureService;

    /**
     * 生产查询-首页表格-xyb
     * @param pageno
     * @param pagesize
     * @param manuFacture
     * @return
     */
    @RequestMapping("/queryMManuFactureAll.May")
    public IPage<MManuFacture> queryMManuFactureAll(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                                    @RequestParam(value = "pagesize",defaultValue = "10") int pagesize,
                                                    MManuFacture manuFacture){
        return mManuFactureService.queryMManuFactureAll(pageno,pagesize,manuFacture);
    }

    /**
     * 生产查询-beng-xyb
     * @param id
     * @return
     */
    @RequestMapping("/queryByIdMManuFacture.May")
    public MManuFacture queryByIdMManuFacture(int id){
        return mManuFactureService.queryByIdMManuFacture(id);
    }

    /**
     * 生产查询-表格-xyb
     * @param id
     * @return
     */
    @RequestMapping("/queryByIdMManuFactureEx1.May")
    public List<MManuFactureEx> queryByIdMManuFactureEx1(int id){
        return mManuFactureService.queryByIdMManuFactureEx1(id);
    }

}
