package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hnguigu.service.MManuFactureService;
import com.hnguigu.service.MProcedureModulingService;
import com.hnguigu.service.MProcedureService;
import com.hnguigu.service.MProceduringService;
import com.hnguigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("MProceduring")
public class MProceduringController {
    @Autowired
    MProceduringService mProceduringService;
    @Autowired
    MManuFactureService mManuFactureService;
    @Autowired
    MProcedureService mProcedureService;
    @Autowired
    MProcedureModulingService mProcedureModulingService;
    /**
     * 生产登记：查询已审核的派工单-skl
     * @param pageno
     * @param pagesize
     * @return
     */
    @RequestMapping("dengji_Make_production.action")
    public IPage<MManuFacture> shenhe_Make_production(@RequestParam(value = "pageno", defaultValue = "1") Integer pageno
            , @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        QueryWrapper<MManuFacture> queryWrapper = new QueryWrapper<MManuFacture>();
        queryWrapper.eq("CHECK_TAG", "S001-1");
        queryWrapper.eq("MANUFACTURE_PROCEDURE_TAG", "S002-0").
        or().eq("MANUFACTURE_PROCEDURE_TAG", "S002-1");
        return mManuFactureService.page(new Page<MManuFacture>(pageno, pagesize), queryWrapper);
    }

    /**
     * 生产登记，添加生产登记的工序-skl
     * @param mProceduring
     * @return
     */
    @RequestMapping("adddengjigongxu_Make_production.action")
    public boolean adddengjigongxu_Make_production(MProceduring mProceduring) {

        QueryWrapper<MProceduring> queryWrapper = new QueryWrapper<MProceduring>();
        queryWrapper.eq("PARENT_ID", mProceduring.getParentId());
        queryWrapper.eq("DETAILS_NUMBER", mProceduring.getDetailsNumber());
        MProceduring one = mProceduringService.getOne(queryWrapper);

        QueryWrapper<MProcedure> queryWrapper2 = new QueryWrapper<MProcedure>();
        queryWrapper2.eq("PARENT_ID", mProceduring.getParentId());
        queryWrapper2.eq("DETAILS_NUMBER", mProceduring.getDetailsNumber());
        MProcedure one1 = mProcedureService.getOne(queryWrapper2);
        one1.setProcedureFinishTag("G004-1");

        MManuFacture byId = mManuFactureService.getById(mProceduring.getParentId());
        boolean tag=false;
        if(one==null){
            mProceduring.setSubtotal(mProceduring.getLabourHourAmount()*mProceduring.getCostPrice());
            mProceduring.setRegCount(1);
            byId.setManufactureProcedureTag("S002-1");
            mManuFactureService.updateById(byId);
            boolean save = mProceduringService.save(mProceduring);
            boolean b = mProcedureService.updateById(one1);
            if(save==true&&b==true){
                tag=true;
            }
        }else if(one!=null){
            mProceduring.setId(one.getId());
            mProceduring.setSubtotal(mProceduring.getLabourHourAmount()*mProceduring.getCostPrice());
            mProceduring.setRegCount(one.getRegCount()+1);
            boolean b1 = mProcedureService.updateById(one1);
            boolean b = mProceduringService.updateById(mProceduring);
            if(b==true&&b1==true){
                tag=true;
            }
        }
        return true;
    }

    /**
     * 生产登记，添加工序登记的物料-skl
     * @param mProcedureModules
     * @return
     */
    @RequestMapping(value = "adddengjigongxuwuliao.action",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean adddengjigongxuwuliao(@RequestBody List<MProcedureModule> mProcedureModules) {

        for (MProcedureModule mProcedureModule:mProcedureModules) {
            QueryWrapper<MProceduring> queryWrapper = new QueryWrapper<MProceduring>();
            queryWrapper.eq("PARENT_ID", mProcedureModule.getId());
            queryWrapper.eq("DETAILS_NUMBER", mProcedureModule.getParentId());
            MProceduring one = mProceduringService.getOne(queryWrapper);
            QueryWrapper<MProcedureModuling> queryWrapper2 = new QueryWrapper<MProcedureModuling>();
            queryWrapper2.eq("PARENT_ID", one.getId());
            boolean b = mProcedureModulingService.remove(queryWrapper2);
        }

        MProcedureModuling mProcedureModuling = new MProcedureModuling();
        for (MProcedureModule mProcedureModule:mProcedureModules) {
            QueryWrapper<MProceduring> queryWrapper = new QueryWrapper<MProceduring>();
            queryWrapper.eq("PARENT_ID", mProcedureModule.getId());
            queryWrapper.eq("DETAILS_NUMBER", mProcedureModule.getParentId());
            MProceduring one = mProceduringService.getOne(queryWrapper);
            boolean b = mProcedureModulingService.removeById(one.getId());
            mProcedureModuling.setParentId(one.getId());
            mProcedureModuling.setDetailsNumber(mProcedureModule.getDetailsNumber());
            mProcedureModuling.setProductId(mProcedureModule.getProductId());
            mProcedureModuling.setProductName(mProcedureModule.getProductName());
            mProcedureModuling.setCostPrice(mProcedureModule.getCostPrice());
            mProcedureModuling.setAmount(mProcedureModule.getRowamount());
            mProcedureModuling.setSubtotal(mProcedureModule.getCostPrice()*mProcedureModule.getRowamount());
            boolean save = mProcedureModulingService.save(mProcedureModuling);
        }
        return true;
    }
    /**
     * 生产登记复核：查询生产标志为未审核的派工单-skl
     * @param pageno
     * @param pagesize
     * @return
     */
    @RequestMapping("dengjifuhe_Make_production.action")
    public IPage<MManuFacture> dengjifuhe_Make_production(@RequestParam(value = "pageno", defaultValue = "1") Integer pageno
            , @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        QueryWrapper<MManuFacture> queryWrapper = new QueryWrapper<MManuFacture>();
        queryWrapper.eq("MANUFACTURE_PROCEDURE_TAG", "S002-1");
        return mManuFactureService.page(new Page<MManuFacture>(pageno, pagesize), queryWrapper);
    }

    /**
     * 生产登记复核，工序登记通过方法-skl
     * @param gongxuId
     * @param checker
     * @param checkTime
     * @return
     */
    @RequestMapping("dengjifuhetruetag_Make.action")
    public boolean dengjifuhetruetag_Make(int gongxuId, String checker, Date checkTime) {
        MProcedure byId = mProcedureService.getById(gongxuId);
        MManuFacture byId1 = mManuFactureService.getById(byId.getParentId());
        QueryWrapper<MProceduring> queryWrapper = new QueryWrapper<MProceduring>();
        queryWrapper.eq("PARENT_ID", byId1.getId());
        queryWrapper.eq("DETAILS_NUMBER", byId.getDetailsNumber());
        MProceduring one = mProceduringService.getOne(queryWrapper);
        byId.setProcedureFinishTag("G004-3");
        one.setChecker(checker);
        one.setCheckTime(checkTime);
        boolean b = mProcedureService.updateById(byId);
        boolean b1 = mProceduringService.updateById(one);
        if(b==true&&b1==true){
            return true;
        }
        return false;
    }
    /**
     * 生产登记复核，工序登记不通过方法-skl
     * @param gongxuId
     * @param
     * @param
     * @return
     */
    @RequestMapping("dengjifuhefalseetag_Make.action")
    public boolean dengjifuhefalseetag_Make(int gongxuId) {
        MProcedure byId = mProcedureService.getById(gongxuId);
       byId.setProcedureFinishTag("G004-2");
        return mProcedureService.updateById(byId);
    }
    /**
     * 生产登记复核，通过交接登记复核-skl
     * @param id
     * @param
     * @return
     */
    @RequestMapping("jiaojiefuhetruetag_Make.action")
    public boolean jiaojiefuhetruetag_Make(int id){

        MProcedure byId = mProcedureService.getById(id);
        byId.setProcedureTransferTag("G005-2");
        return mProcedureService.updateById(byId);
    }
    @RequestMapping("all_Make_production.action")
    public boolean all_Make_production(int id){
        List<MProcedure> mProcedures = mProcedureService.queryByparentIDtwo(id);
        MManuFacture byId = mManuFactureService.getById(id);
        byId.setManufactureProcedureTag("S002-2");
        boolean a=false;
        for (MProcedure mProcedure:mProcedures) {
            if("G005-2".equals(mProcedure.getProcedureTransferTag())){
                a=true;
            }else {
                a=false;
            }
        }
        if(a==true){
            mManuFactureService.updateById(byId);
        }
        return a;
    }
}
