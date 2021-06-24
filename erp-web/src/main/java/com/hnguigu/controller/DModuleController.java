package com.hnguigu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.hnguigu.service.DFileService;
import com.hnguigu.service.DModuleDetailsService;
import com.hnguigu.service.DModuleService;
import com.hnguigu.util.PageUtil;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.DModule;
import com.hnguigu.vo.DModuleDetails;
import com.hnguigu.vo.MDesignProcedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/DModule")
public class DModuleController {
    @Autowired
    DModuleService dModuleService;
    @Autowired
    DFileService dFileService;
    @Autowired
    DModuleDetailsService dModuleDetailsService;

    /**
     * 产品物料组成设计单，查询通过档案审核且类型为商品且还没有设计的数据-skl
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    @RequestMapping("design_sheet.action")
    public IPage<DFile> design_sheet(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            , @RequestParam(value ="pagesize",defaultValue="5")Integer pagesize, DFile dFile){
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        queryWrapper.eq("CHECK_TAG","S001-1");
        queryWrapper.eq("TYPE","Y001-1");
        queryWrapper.eq("DESIGN_MODULE_TAG","W001-0");
        if(dFile.getProductClass()!=""&&dFile.getProductClass()!=null){
            queryWrapper.eq("PRODUCT_CLASS",dFile.getProductClass());
        }
        if(dFile.getType()!=""&&dFile.getType()!=null){
            queryWrapper.eq("TYPE",dFile.getType());
        }
        return dFileService.page(new Page<DFile>(pageno,pagesize),queryWrapper);
    }

    /**
     * 根据id查询需要设计的商品的数据-skl
     * @param id 商品编号
     * @return
     */
    @RequestMapping("design_sheet_sel.action")
    public DFile design_sheet_sel(int id){
        return dFileService.getById(id);
    }

    /**
     * 查询设计商品所需且可以用的物料-skl
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    @RequestMapping("design_sheetsel_wuliao.action")
    public IPage<DFile> design_sheetsel_wuliao(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            , @RequestParam(value ="pagesize",defaultValue="5")Integer pagesize, DFile dFile){
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        queryWrapper.eq("TYPE","Y001-2");
        queryWrapper.eq("DELETE_TAG","C001-0");
        queryWrapper.eq("CHECK_TAG","S001-1");
//        queryWrapper.eq("DESIGN_MODULE_TAG","W001-0");
        if(dFile.getProductClass()!=""&&dFile.getProductClass()!=null){
            queryWrapper.eq("PRODUCT_CLASS",dFile.getProductClass());
        }
        return dFileService.page(new Page<DFile>(pageno,pagesize),queryWrapper);
    }

    /**
     * 根据物料编号将其添加到商品设计所需的物料中-skl
     * @param id
     * @return
     */
    @RequestMapping("design_sheetsel_wuliaoById.action")
    public DFile design_sheetsel_wuliaoById(int id){
        return dFileService.getById(id);
    }

    /**
     * 物料组成设计添加的方法第一步-skl
     * @param dfileid
     * @param dModule
     * @return
     */
    @RequestMapping(value = "design_sheetadd_wuliaoone.action",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean design_sheetadd_wuliao(int dfileid,DModule dModule){
        System.out.println(dfileid);
        System.out.println(dModule);
        DFile byId = dFileService.getById(dfileid);
        byId.setDesignModuleTag("W001-1");
        boolean b = dFileService.updateById(byId);
        List<DModule> list = dModuleService.list();
        int size = list.size();
        int size1=size+1;

        Date dt=new Date();
        SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
        String date = matter1.format(dt);
        System.out.println(date);
        dModule.setDesignId("200"+date+"00"+size1);
        dModule.setCheckTag("S001-0");
        dModule.setChangeTag("B002-0");
        boolean save = dModuleService.save(dModule);

        return true;
    }
    /**
     * 物料组成设计添加的方法第二部-skl
     * @param
     * @param dModule
     * @return
     */
    @RequestMapping(value = "design_sheetadd_wuliaotwo.action",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public DModule design_sheetadd_wuliaotwo(DModule dModule){

        System.out.println(dModule);
        QueryWrapper<DModule> queryWrapper = new QueryWrapper<DModule>();
        queryWrapper.eq("PRODUCT_ID",dModule.getProductId());
        DModule one = dModuleService.getOne(queryWrapper);
        System.out.println(one);
        return dModuleService.getOne(queryWrapper);
    }
    /**
     * 物料组成设计添加的方法第三部-skl
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "design_sheetadd_wuliaothree.action",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean design_sheetadd_wuliaothree(@RequestBody List<DModuleDetails> dModuleDetails){
        int i = 0;
        boolean a=false;
        for(i=0;i<dModuleDetails.size();i++){
            dModuleDetails.get(i).setId(null);
            Integer parentId = dModuleDetails.get(i).getParentId();

            List<DModuleDetails> byparentId = dModuleDetailsService.getByparentId(parentId);
            System.out.println(byparentId.size());
            int size=byparentId.size();
            int size1=size+1;
            dModuleDetails.get(i).setDetailsNumber(size1);
            System.out.println(dModuleDetails.get(i));
            boolean save = dModuleDetailsService.save(dModuleDetails.get(i));
            if(save=true){
                a=true;
            }
        }

        return a;
    }
    /**
     * 查询需要审核的物料组成设计单数据-skl
     * @param pageno
     * @param pagesize
     * @return
     */
    @RequestMapping("review_design_sheet.action")
    public IPage<DModule> review_design_sheet(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            ,@RequestParam(value ="pagesize",defaultValue="5")Integer pagesize){
        QueryWrapper<DModule> queryWrapper = new QueryWrapper<DModule>();
        queryWrapper.eq("CHECK_TAG","S001-0").or().
                eq("CHECK_TAG","S001-2").or().
                eq("CHECK_TAG","S001-0").
                eq("CHANGE_TAG","B002-1");
        return dModuleService.page(new Page<DModule>(pageno,pagesize),queryWrapper);
    }

    /**
     * 根据设计单编号查询相应的数据-skl
     * @param id
     * @return
     */
    @RequestMapping("review_design_sheetsel.action")
    public DModule review_design_sheetsel(int id){
        return dModuleService.getById(id);
    }

    /**
     * 查询某个设计单所需要的物料-skl
     * @param id
     * @return
     */
    @RequestMapping("review_design_sheetselwuliao.action")
    public IPage<DModuleDetails> review_design_sheetselwuliao(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            ,@RequestParam(value ="pagesize",defaultValue="100")Integer pagesize,int id){
        QueryWrapper<DModuleDetails> queryWrapper = new QueryWrapper<DModuleDetails>();
        queryWrapper.eq("PARENT_ID",id);
        IPage<DModuleDetails> page = dModuleDetailsService.page(new Page<DModuleDetails>(pageno, pagesize), queryWrapper);
        System.out.println(page.getRecords());
        return  dModuleDetailsService.page(new Page<DModuleDetails>(pageno,pagesize),queryWrapper);
    }

    /**
     * 物料组成设计单通过的方法-skl
     * @param dModule
     * @return
     */
    @RequestMapping("edittrueCheckTag.action")
    public boolean edittrueCheckTag(DModule dModule){
        DModule byId = dModuleService.getById(dModule.getId());
        byId.setCheckTag("S001-1");
        byId.setChecker(dModule.getChecker());
        byId.setCheckTime(dModule.getCheckTime());
        return dModuleService.updateById(byId);
    }
    /**
     * 物料组成设计单不通过的方法-skl
     * @param dModule
     * @return
     */
    @RequestMapping("editfalseeCheckTag.action")
    public boolean editfalseeCheckTag(DModule dModule){
        DModule byId = dModuleService.getById(dModule.getId());
        byId.setCheckTag("S001-2");
        byId.setChecker(dModule.getChecker());
        byId.setCheckTime(dModule.getCheckTime());
        return dModuleService.updateById(byId);
    }

    /**
     * 物料组成设计单查询
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    @RequestMapping("query_design_sheetdata.action")
    public PageUtil<DModule> query_design_sheetdata(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            , @RequestParam(value ="pagesize",defaultValue="5") Integer pagesize, DFile dFile){
        PageInfo<DModule> dModulePageInfo = dModuleService.query_design_sheetdata(pageno, pagesize);
        PageUtil<DModule> pageUtil =new PageUtil<DModule>();
        pageUtil.setTotal(dModulePageInfo.getTotal());
        pageUtil.setRows(dModulePageInfo.getList());
        System.out.println(pageUtil.getRows());
        return pageUtil;
    }

    /**
     * 物料组成设计单查询,根据设计单编号查询相应的设计单数据-skl
     * @param id
     * @return
     */
    @RequestMapping("query_design_sheetsel.action")
    public DModule query_design_sheetsel(int id){
        return dModuleService.getById(id);
    }

    /**
     * 物料组成设计单查询,查询某个设计单所拥有的物料-skl
     * @param id
     * @return
     */
    @RequestMapping("query_design_sheetselwuliao.action")
    public IPage<DModuleDetails> query_design_sheetselwuliao(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            ,@RequestParam(value ="pagesize",defaultValue="100")Integer pagesize,int id){
        QueryWrapper<DModuleDetails> queryWrapper = new QueryWrapper<DModuleDetails>();
        queryWrapper.eq("PARENT_ID",id);
        IPage<DModuleDetails> page = dModuleDetailsService.page(new Page<DModuleDetails>(pageno, pagesize), queryWrapper);
        System.out.println(page.getRecords());
        return  dModuleDetailsService.page(new Page<DModuleDetails>(pageno,pagesize),queryWrapper);
    }
    /**
     * 物料组成设计单变更查询数据-skl
     * @param pageno
     * @param pagesize
     * @param
     * @return
     */
    @RequestMapping("change_design_sheet.action")
    public IPage<DModule> change_design_sheet(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            , @RequestParam(value ="pagesize",defaultValue="5") Integer pagesize){
        QueryWrapper<DModule> queryWrapper = new QueryWrapper<DModule>();
        queryWrapper.eq("CHECK_TAG","S001-1");
        IPage<DModule> page = dModuleService.page(new Page<DModule>(pageno, pagesize), queryWrapper);
        System.out.println(page);
        return dModuleService.page(new Page<DModule>(pageno, pagesize), queryWrapper);
    }

    /**
     * 物料组成设计单变更查询,根据设计单编号查询相应的设计单数据-skl
     * @param id
     * @return
     */
    @RequestMapping("querychange_design_sheetsel.action")
    public DModule querychange_design_sheetsel(int id){
        return dModuleService.getById(id);
    }

    /**
     * 物料组成设计单变更查询,查询某个设计单所拥有的物料-skl
     * @param id
     * @return
     */
    @RequestMapping("querychange_design_sheetselwuliao.action")
    public IPage<DModuleDetails> querychange_design_sheetselwuliao(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            ,@RequestParam(value ="pagesize",defaultValue="100")Integer pagesize,int id){
        QueryWrapper<DModuleDetails> queryWrapper = new QueryWrapper<DModuleDetails>();
        queryWrapper.eq("PARENT_ID",id);
        IPage<DModuleDetails> page = dModuleDetailsService.page(new Page<DModuleDetails>(pageno, pagesize), queryWrapper);
        System.out.println(page.getRecords());
        return  dModuleDetailsService.page(new Page<DModuleDetails>(pageno,pagesize),queryWrapper);
    }

    /**
     * 查询变更设计商品所需且可以用的物料-skl
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    @RequestMapping("editdesign_sheetsel_wuliao.action")
    public IPage<DFile> editdesign_sheetsel_wuliao(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            , @RequestParam(value ="pagesize",defaultValue="5")Integer pagesize, DFile dFile){
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        queryWrapper.eq("TYPE","Y001-2");
        queryWrapper.eq("DELETE_TAG","C001-0");
        queryWrapper.eq("CHECK_TAG","S001-1");
//        queryWrapper.eq("DESIGN_MODULE_TAG","W001-0");
        if(dFile.getProductClass()!=""&&dFile.getProductClass()!=null){
            queryWrapper.eq("PRODUCT_CLASS",dFile.getProductClass());
        }
        return dFileService.page(new Page<DFile>(pageno,pagesize),queryWrapper);
    }

    /**
     * 根据物料编号将其添加到设计单变更 商品设计所需的物料中-skl
     * @param id
     * @return
     */
    @RequestMapping("editdesign_sheetsel_wuliaoById.action")
    public DFile editdesign_sheetsel_wuliaoById(int id){
        return dFileService.getById(id);
    }

    /**
     * 物料组成设计变更的方法第一步-skl
     * @param
     * @param dModule
     * @return
     */
    @RequestMapping("changedesign_sheetadd_wuliaoone.action")
    public boolean changedesign_sheetadd_wuliaoone(DModule dModule){
        DModule byId = dModuleService.getById(dModule.getId());
        byId.setModuleDescribe(dModule.getModuleDescribe());
        byId.setCostPriceSum(dModule.getCostPriceSum());
        byId.setChanger(dModule.getChanger());
        byId.setChangeTime(dModule.getChangeTime());
        byId.setCheckTag("S001-0");
        byId.setChangeTag("B002-1");
        System.out.println(byId);
        return dModuleService.updateById(byId);
    }

    /**
     * 物料组成设计变更添加的方法第三部-skl
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "changedesign_sheetadd_wuliaothree.action",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean changedesign_sheetadd_wuliaothree(@RequestBody List<DModuleDetails> dModuleDetails){
        int i = 0;
        boolean a=false;
        for(i=0;i<dModuleDetails.size();i++) {
            QueryWrapper<DModuleDetails> queryWrapper = new QueryWrapper<DModuleDetails>();
            queryWrapper.eq("PARENT_ID",dModuleDetails.get(i).getParentId());
            boolean remove = dModuleDetailsService.remove(queryWrapper);
            System.out.println(remove);
        }
        for(i=0;i<dModuleDetails.size();i++){
            Integer parentId = dModuleDetails.get(i).getParentId();
            List<DModuleDetails> byparentId = dModuleDetailsService.getByparentId(parentId);
            System.out.println(byparentId.size());
            int size=byparentId.size();
            int size1=size+1;
            dModuleDetails.get(i).setDetailsNumber(size1);
            System.out.println(dModuleDetails.get(i));
            boolean save = dModuleDetailsService.save(dModuleDetails.get(i));
            if(save=true){
                a=true;
            }
        }
        return a;
    }

}
