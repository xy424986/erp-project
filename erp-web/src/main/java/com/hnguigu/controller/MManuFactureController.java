package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.service.MManuFactureService;
import com.hnguigu.vo.MManuFacture;
import com.hnguigu.vo.extend.MManuFactureEx;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hnguigu.service.MManuFactureService;
import com.hnguigu.service.MProcedureModuleService;
import com.hnguigu.service.MProcedureService;
import com.hnguigu.vo.*;
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
    @Autowired
    MProcedureService mProcedureService;
    @Autowired
    MProcedureModuleService mProcedureModuleService;

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

    /**
     * 生产派工单审核：查询未审核的派工单-skl
     * @param pageno
     * @param pagesize
     * @return
     */
    @RequestMapping("shenhe_Make_production.action")
    public IPage<MManuFacture> shenhe_Make_production(@RequestParam(value = "pageno", defaultValue = "1") Integer pageno
            , @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        QueryWrapper<MManuFacture> queryWrapper = new QueryWrapper<MManuFacture>();
        queryWrapper.eq("CHECK_TAG", "S001-0");
        return mManuFactureService.page(new Page<MManuFacture>(pageno, pagesize), queryWrapper);
    }

    /**
     * 生产派工单审核：查询正在审核的派工单数据-skl
     * @param id
     * @return
     */
    @RequestMapping("shenhe_Make_productionByid.action")
    public MManuFacture shenhe_Make_productionByid(int id){
        System.out.println(mManuFactureService.getById(id));
        return mManuFactureService.getById(id);
    }

    /**
     * 生产派工单审核：查询正在审核的派工单下面的工序-skl
     * @param id
     * @return
     */
    @RequestMapping("shenhe_Make_productionparentid.action")
    public List<MProcedure> shenhe_Make_productionparentid(int id){
        System.out.println(mProcedureService.queryByparentID(id));
        return mProcedureService.queryByparentID(id);
    }
    /**
     * 生产派工单审核：查询正在审核的派工单下面的工序所需物料-skl
     * @param
     * @return
     */
    @RequestMapping("shenhe_Make_productionByparentId.action")
    public IPage<MProcedureModule> shenhe_Make_productionByparentId(@RequestParam(value = "pageno", defaultValue = "1") Integer pageno
            , @RequestParam(value = "pagesize", defaultValue = "100") Integer pagesize,int parentId) {
        QueryWrapper<MProcedureModule> queryWrapper = new QueryWrapper<MProcedureModule>();
        queryWrapper.eq("PARENT_ID", parentId);
        return mProcedureModuleService.page(new Page<MProcedureModule>(pageno, pagesize), queryWrapper);
    }

    /**
     * 生产派工单通过审核
     * @param mManuFacture
     * @return
     */
    @RequestMapping("shenheTag_Make_productionByparentId.action")
    public boolean shenheTag_Make_productionByparentId(MManuFacture mManuFacture){
        MManuFacture byId = mManuFactureService.getById(mManuFacture.getId());
        byId.setCheckTag("S001-1");
        byId.setChecker(mManuFacture.getChecker());
        byId.setCheckTime(mManuFacture.getCheckTime());
        return mManuFactureService.updateById(byId);
    }

    /**
     * 生产派工单不通过审核
     * @param mManuFacture
     * @return
     */
    @RequestMapping("shenheTag_Make_productionByparentIdtwo.action")
    public boolean shenheTag_Make_productionByparentIdtwo(MManuFacture mManuFacture){
        MManuFacture byId = mManuFactureService.getById(mManuFacture.getId());
        byId.setCheckTag("S001-2");
        byId.setChecker(mManuFacture.getChecker());
        byId.setCheckTime(mManuFacture.getCheckTime());
        return mManuFactureService.updateById(byId);
    }
}
