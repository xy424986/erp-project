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

    /**
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
        dFile.setCheckTag("S001-1");
        return  dFileService.queryAllDFile(pageno,pagesize,dFile);
    }

    /**
     * 查询安全库存配置单的数据-xyb
     * @param productId
     * @return
     */
    @RequestMapping("/queryByIdDFile.May")
    public DFile queryByIdDFile(String productId){
        System.out.println("queryByIdDFile的productId"+productId);
        return  dFileService.queryByIdDFile(productId);
    }

    /**
     * 查询安全库存配置单中的表格数据-xyb
     * @param productId
     * @return
     */
    @RequestMapping("/queryByIdDFile2.May")
    public List<DFile> queryByIdDFile2(String productId){
        System.out.println("queryByIdDFile2的productId"+productId);
        return  dFileService.queryByIdDFile2(productId);
    }

    /**
     *产品档案登记的方法-skl
     * @param dFile 登记所需的参数
     * @return
     * user skl
     */
    @RequestMapping("addProductFile.action")
    public boolean addProductFile(DFile dFile){
        System.out.println(dFile);
        List<DFile> list = dFileService.list();
        int size = list.size();
        int size1=size+1;
        dFile.setProductId("100"+dFile.getFirstKindId()+dFile.getSecondKindId()+dFile.getThirdKindId()+"0000"+size1);
        dFile.setChangeTag("D002-0");
        dFile.setPriceChangeTag("J001-0");
        dFile.setDeleteTag("C001-0");
        dFile.setDesignCellTag("K001-0");
        dFile.setDesignModuleTag("W001-0");
        dFile.setDesignProcedureTag("G001-0");
        dFile.setCheckTag("S001-0");
        return dFileService.save(dFile);
    }

    /**
     * 产品档案登记复核查询的方法-skl
     * @param pageno 页码
     * @param pagesize 页大小
     * @return
     * user skl
     */
    @RequestMapping("cpdafuhesel.action")
    public IPage<DFile> cpdafuhesel(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            ,@RequestParam(value ="pagesize",defaultValue="5")Integer pagesize){
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        queryWrapper.eq("CHECK_TAG","S001-0").or().
                eq("CHECK_TAG","S001-2").or().
                eq("CHECK_TAG","S001-0").
                eq("CHANGE_TAG","D002-1");
        return dFileService.page(new Page<DFile>(pageno,pagesize),queryWrapper);
    }

    /**
     * 产品档案登记复核,根据产品档案编号查询当前产品档案-skl
     * @param id 产品档案编号
     * @return
     * user skl
     */
    @RequestMapping("cpdafuheselbegin.action")
    public DFile cpdafuheselbegin(int id){
        return dFileService.getById(id);
    }

    /**
     * 产品档案登记复核,根据产品档案编号修改审核通过状态-skl
     * @param dFile 对象数据
     * @return
     * user skl
     */
    @RequestMapping("editCheckTag.action")
    public boolean editCheckTag(DFile dFile){
        DFile byId = dFileService.getById(dFile.getId());
        byId.setCheckTag("S001-1");
        byId.setChecker(dFile.getChecker());
        byId.setCheckTime(dFile.getCheckTime());
        return dFileService.updateById(byId);
    }
    /**
     * 产品档案登记复核,根据产品档案编号修改审核不通过状态-skl
     * @param dFile 对象数据
     * @return
     * user skl
     */
    @RequestMapping("editCheckTagtwo.action")
    public boolean editCheckTagtwo(DFile dFile){
        DFile byId = dFileService.getById(dFile.getId());
        byId.setCheckTag("S001-2");
        byId.setChecker(dFile.getChecker());
        byId.setCheckTime(dFile.getCheckTime());
        return dFileService.updateById(byId);
    }

    /**
     * 产品档案查询-skl
     * @param pageno 页码
     * @param pagesize 页大小
     * @param dFile 查询条件
     * @return
     * user skl
     */
    @RequestMapping("queryTrueCheckTag.action")
    public IPage<DFile> queryTrueCheckTag(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            ,@RequestParam(value ="pagesize",defaultValue="5") Integer pagesize,DFile dFile){
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        queryWrapper.eq("CHECK_TAG","S001-1");
//        queryWrapper.eq("TYPE","Y001-1");
        if(dFile.getProductClass()!=""&&dFile.getProductClass()!=null){
            queryWrapper.eq("PRODUCT_CLASS",dFile.getProductClass());
        }
        if(dFile.getType()!=""&&dFile.getType()!=null){
            queryWrapper.eq("TYPE",dFile.getType());
        }
        return dFileService.page(new Page<DFile>(pageno,pagesize),queryWrapper);
    }

    /**
     * 产品档案更改根据id查询，产品档案查询详细根据id查询-skl
     * @param id
     * @return
     */
    @RequestMapping("queryTrueCheckTagXiangXi.action")
    public DFile queryTrueCheckTagXiangXi(int id){
        return dFileService.getById(id);
    }

    /**
     * 产品档案更改的方法-skl
     * @param dFile 更改所需的对象
     * @return
     */
    @RequestMapping("editchangeTag.action")
    public boolean editchangeTag(DFile dFile){
        DFile byId = dFileService.getById(dFile.getId());
        if(byId.getListPrice()!=dFile.getListPrice()){
            dFile.setPriceChangeTag("J001-1");
        }else {
            dFile.setPriceChangeTag("J001-0");
        }
        dFile.setFileChangeAmount(dFile.getFileChangeAmount()+1);
        dFile.setCheckTag("S001-0");
        dFile.setChangeTag("D002-1");
        return dFileService.updateById(dFile);
    }

    /**
     * 删除产品档案：查询已通过审核的数据-skl
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    @RequestMapping("deleteproductfile.action")
    public IPage<DFile> deleteproductfile(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            ,@RequestParam(value ="pagesize",defaultValue="5")Integer pagesize,DFile dFile){
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        queryWrapper.eq("CHECK_TAG","S001-1");
        queryWrapper.eq("DELETE_TAG","C001-0");
        if(dFile.getProductClass()!=""&&dFile.getProductClass()!=null){
            queryWrapper.eq("PRODUCT_CLASS",dFile.getProductClass());
        }
        return dFileService.page(new Page<DFile>(pageno,pagesize),queryWrapper);
    }
    /**
     * 恢复删除产品档案：查询需要恢复的数据-skl
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    @RequestMapping("deleteproductfiletwo.action")
    public IPage<DFile> deleteproductfiletwo(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            ,@RequestParam(value ="pagesize",defaultValue="5")Integer pagesize,DFile dFile){
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        queryWrapper.eq("CHECK_TAG","S001-1");
        queryWrapper.eq("DELETE_TAG","C001-1");
        if(dFile.getProductClass()!=""&&dFile.getProductClass()!=null){
            queryWrapper.eq("PRODUCT_CLASS",dFile.getProductClass());
        }
        return dFileService.page(new Page<DFile>(pageno,pagesize),queryWrapper);
    }
    /**
     * 永久删除产品档案：查询状态为已删除的数据-skl
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    @RequestMapping("deleteproductfilethree.action")
    public IPage<DFile> deleteproductfilethree(@RequestParam(value ="pageno",defaultValue="1") Integer pageno
            ,@RequestParam(value ="pagesize",defaultValue="5")Integer pagesize,DFile dFile){
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        queryWrapper.eq("CHECK_TAG","S001-1");
        queryWrapper.eq("DELETE_TAG","C001-1");
        if(dFile.getProductClass()!=""&&dFile.getProductClass()!=null){
            queryWrapper.eq("PRODUCT_CLASS",dFile.getProductClass());
        }
        return dFileService.page(new Page<DFile>(pageno,pagesize),queryWrapper);
    }
    /**
     * 删除，修改档案的状态为已删除-skl
     * @param id
     * @param dFile
     * @return
     */
    @RequestMapping("deletetruetag.action")
    public boolean deletetruetag(int id,DFile dFile){
        dFile.setId(id);
        dFile.setDeleteTag("C001-1");
        return dFileService.updateById(dFile);
    }
    /**
     * 恢复删除，修改档案的状态为未删除-skl
     * @param id
     * @param dFile
     * @return
     */
    @RequestMapping("huifudeletetruetag.action")
    public boolean huifudeletetruetag(int id,DFile dFile){
        dFile.setId(id);
        dFile.setDeleteTag("C001-0");
        return dFileService.updateById(dFile);
    }
    /**
     * 永久删除，删除产品档案 -skl
     * @param id 产品档案id
     * @param
     * @return
     */
    @RequestMapping("yongjiudeletetruetag.action")
    public boolean yongjiudeletetruetag(int id){
        return dFileService.removeById(id);
    }
}

