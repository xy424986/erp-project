package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hnguigu.service.*;
import com.hnguigu.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.service.MApplyService;
import com.hnguigu.vo.MApply;
import com.hnguigu.vo.MDesignProcedure;
import com.hnguigu.vo.extend.MDesignProcedureExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/MApply")
public class MApplyController {
    @Autowired
    MApplyService mApplyService;
    @Autowired
    MDesignProcedureService mDesignProcedureService;
    @Autowired
    MDesignProcedureDetailsService mDesignProcedureDetailsService;
    @Autowired
    MDesignProcedureModuleService mDesignProcedureModuleService;
    @Autowired
    MManuFactureService mManuFactureService;
    @Autowired
    MProcedureService mProcedureService;
    @Autowired
    MProcedureModuleService mProcedureModuleService;
    /**
     * 制定生产派工单：查询能制定的生产计划-skl
     * @param pageno
     * @param pagesize
     * @return
     */
    @RequestMapping("query_Make_production.action")
    public IPage<MApply> query_Make_production(@RequestParam(value = "pageno", defaultValue = "1") Integer pageno
            , @RequestParam(value = "pagesize", defaultValue = "5") Integer pagesize) {
        QueryWrapper<MApply> queryWrapper = new QueryWrapper<MApply>();
        queryWrapper.eq("CHECK_TAG", "S001-1");
        queryWrapper.eq("MANUFACTURE_TAG", "P001-0");
        return mApplyService.page(new Page<MApply>(pageno, pagesize), queryWrapper);
    }

    /**
     * 制定生产派工单：根据产品编号查询此生产计划的数据-skl
     * @param productId 产品编号
     * @return
     */
    @RequestMapping("query_Make_productionByid.action")
    public MApply design_sheet_sel(String productId){
        return mApplyService.queryByproductId(productId);
    }

    /**
     * 制定生产派工单:根据产品编号查询产品生产工序下面的产品生产工序明细数据-skl
     * @param productId
     * @return
     */
    @RequestMapping("query_Make_productionproductId.action")
    public List<MDesignProcedureDetails> query_Make_productionproductId(String productId){
        MDesignProcedure mDesignProcedure = mDesignProcedureService.queryByproductID(productId);
        return mDesignProcedureDetailsService.queryByparentId(mDesignProcedure.getId());
    }

    /**
     * 制定生产派工单:根据产品生产工序明细id查询产品生产工序物料明细数据-skl
     * @param pageno
     * @param pagesize
     * @param parentId
     * @return
     */
    @RequestMapping("query_Make_productionByparentId.action")
    public IPage<MDesignProcedureModule> query_Make_productionByparentId(@RequestParam(value = "pageno", defaultValue = "1") Integer pageno
            , @RequestParam(value = "pagesize", defaultValue = "100") Integer pagesize,int parentId) {
        QueryWrapper<MDesignProcedureModule> queryWrapper = new QueryWrapper<MDesignProcedureModule>();
        queryWrapper.eq("PARENT_ID", parentId);

        return mDesignProcedureModuleService.page(new Page<MDesignProcedureModule>(pageno, pagesize), queryWrapper);
    }

    /**
     * 根据产品生产计划id修改生产计划状态为已派工-skl
     * @param id
     * @return
     */
    @RequestMapping("add_Make_productionone")
    public boolean add_Make_productionone(int id){
        MApply byId = mApplyService.getById(id);
        byId.setManufactureTag("P001-1");
        mApplyService.updateById(byId);
        return true;
    }

    /**
     * 生产总表的添加-skl
     * @param mManuFacture
     * @return
     */
    @RequestMapping("add_Make_productiontwo")
    public boolean add_Make_productiontwo(MManuFacture mManuFacture){
        QueryWrapper<MDesignProcedure> queryWrapper = new QueryWrapper<MDesignProcedure>();
        queryWrapper.eq("PRODUCT_ID", mManuFacture.getProductId());
        MDesignProcedure one = mDesignProcedureService.getOne(queryWrapper);
        mManuFacture.setModuleCostPriceSun(one.getModuleCostPriceSum());
        mManuFacture.setPealModuleCostPriceSun(0.0);
        mManuFacture.setLabourCostPriceSun(one.getCostPriceSum());
        mManuFacture.setPeallabourCostPriceSun(0.0);

        List<MManuFacture> list = mManuFactureService.list();
        int size = list.size();
        int size1=size+1;

        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
        String date = matter1.format(dt);

        mManuFacture.setManufactureId("301"+date+"00"+size1);
        mManuFacture.setCheckTag("S001-0");
        mManuFacture.setManufactureProcedureTag("S002-0");
        return mManuFactureService.save(mManuFacture);
    }

    /**
     * 生产工序及生产工序物料添加-skl
     * @param mDesignProcedureDetails
     * @return
     */
    @RequestMapping(value = "add_Make_productiononethree.action",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean add_Make_productiononethree(@RequestBody List<MDesignProcedureDetails> mDesignProcedureDetails){
        int i = 0;
        int ii=0;
        boolean a=false;
        boolean b=false;
        boolean c=false;
//        ArrayList<MProcedure> mProcedures = new ArrayList<>();
        MProcedure mProcedure = new MProcedure();
        MProcedureModule mProcedureModule = new MProcedureModule();
        for(i=0;i<mDesignProcedureDetails.size();i++){
            System.out.println(mDesignProcedureDetails.get(i));
            MDesignProcedure byId = mDesignProcedureService.getById(mDesignProcedureDetails.get(i).getParentId());//根据父级序号查询
            QueryWrapper<MManuFacture> queryWrapper = new QueryWrapper<MManuFacture>();
            queryWrapper.eq("PRODUCT_ID", byId.getProductId());
            MManuFacture one = mManuFactureService.getOne(queryWrapper);//根据产品编号查询
            mProcedure.setParentId(one.getId());
            mProcedure.setDetailsNumber(mDesignProcedureDetails.get(i).getDetailsNumber());//工序序号
            mProcedure.setProcedureName(mDesignProcedureDetails.get(i).getProcedureName());//工序名称
            mProcedure.setProcedureId(mDesignProcedureDetails.get(i).getProcedureId());//工序编号
            mProcedure.setLabourHourAmount(mDesignProcedureDetails.get(i).getLabourHourAmount());//设计工时数
            mProcedure.setRealLabourHourAmount(0.0);
            mProcedure.setSubtotal(mDesignProcedureDetails.get(i).getSubtotal());//设计工时成本
            mProcedure.setRealSubtotal(0.0);
            mProcedure.setModuleSubtotal(mDesignProcedureDetails.get(i).getModuleSubtotal());//设计物料成本
            mProcedure.setRealModuleSubtotal(0.0);
            mProcedure.setCostPrice(mDesignProcedureDetails.get(i).getCostPrice());//单位工时成本
            mProcedure.setDemandAmount(one.getAmount());//工序投产数量
            mProcedure.setProcedureFinishTag("G004-0");//工序完成标志
            mProcedure.setProcedureTransferTag("G005-0");//工序交接标志
            boolean save = mProcedureService.save(mProcedure);//添加工序
            if(save==true){
                c=true;
            }
            System.out.println(mProcedure);
            QueryWrapper<MProcedure> queryWrapper2 = new QueryWrapper<MProcedure>();
            queryWrapper2.eq("PARENT_ID", mProcedure.getParentId());
            queryWrapper2.eq("DETAILS_NUMBER", mProcedure.getDetailsNumber());
            MProcedure one1 = mProcedureService.getOne(queryWrapper2);
            List<MDesignProcedureModule> mDesignProcedureModules = mDesignProcedureModuleService.queryByparentId(mDesignProcedureDetails.get(i).getId());
            System.out.println(mDesignProcedureModules.size());
            System.out.println(mDesignProcedureModules);

            if(mDesignProcedureModules.size()!=0) {
                for (MDesignProcedureModule mDesignProcedureModule : mDesignProcedureModules) {
                    mProcedureModule.setParentId(one1.getId());//父级序号
                    mProcedureModule.setDetailsNumber(mDesignProcedureModule.getDetailsNumber());//工序物料序号
                    mProcedureModule.setProductId(mDesignProcedureModule.getProductId());//产品编号
                    mProcedureModule.setProductName(mDesignProcedureModule.getProductName());//产品名称
                    mProcedureModule.setCostPrice(mDesignProcedureModule.getCostPrice());//物料单价
                    mProcedureModule.setAmount(mDesignProcedureModule.getAmount());//设计数量
                    mProcedureModule.setRenewAmount(0);
                    mProcedureModule.setRealAmount(0);
                    mProcedureModule.setSubtotal(mDesignProcedureModule.getSubtotal());//设计物料成本小计
                    mProcedureModule.setRealSubtotal(0.0);
                    System.out.println(mProcedureModule);
                    boolean save1 = mProcedureModuleService.save(mProcedureModule);
                    if(save1==true){
                        b=true;
                    }
                }
            }
            if(b==true&&c==true){
                a=true;
            }
        }
        return true;
    }

    /**
     *  hhy
     * 查询状态
     * @return
     */
    @RequestMapping("queryAll.action")
    public IPage<MApply> queryAll(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                  MApply mApply){
        return mApplyService.queryAll(pageNumber, pageSize, mApply);
    }

    /**
     * hhy
     * 查询要审核的数据
     * @param mApply
     * @return
     */
    @RequestMapping("queryById.action")
    public List<MApply> queryById(MApply mApply){
        return mApplyService.queryById(mApply);
    }

    /**
     * hhy
     * 查询对应状态的所有数据
     * @param mApply
     * @return
     */
    @RequestMapping("queryByState.action")
    public List<MApply> queryByState(MApply mApply){
        return mApplyService.queryByState(mApply);
    }

    /**
     * hhy
     * 审核
     * @param mApply
     * @return
     */
    @RequestMapping(value = "audit.action", produces = {"text/json;charset=utf-8"})
    public String updateStateById(MApply mApply){
        int row = mApplyService.updateStateById(mApply);
        String message = row==0?"审核异常":"已审核";
        return message;
    }

    /**
     * hhy
     * @param mApplyList
     * @return
     */
    @RequestMapping(value = "insert.action", produces = {"text/json;charset=utf-8"})
    public String insert1(@RequestBody List<MApply> mApplyList) {

        int row = mApplyService.insert(mApplyList);
        if (row != 0) {
            return "已提交";
        }
        System.out.println(mApplyList);
        return "提交失败!";
    }
}
