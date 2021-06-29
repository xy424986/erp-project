package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.DFileMapper;
import com.hnguigu.service.DFileService;
import com.hnguigu.vo.DFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DFileServiceImpl extends ServiceImpl<DFileMapper, DFile> implements DFileService {

    @Autowired
    DFileMapper dFileMapper;

    /**
     * hhy
     * @param dFile
     * @return
     */
    @Override
    public List<DFile> queryByState(DFile dFile) {
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        if(!StringUtils.isEmpty(dFile.getType())){
            //用途类型
            queryWrapper.eq("TYPE", dFile.getType());
        }
        if(!StringUtils.isEmpty(dFile.getCheckTag())){
            //审核状态
            queryWrapper.eq("CHECK_TAG", dFile.getCheckTag());
        }
        if(!StringUtils.isEmpty(dFile.getDesignModuleTag())){
            //物料组成设计状态
            queryWrapper.eq("DESIGN_MODULE_TAG", dFile.getDesignModuleTag());
        }
        if(!StringUtils.isEmpty(dFile.getDesignProcedureTag())){
            queryWrapper.eq("DESIGN_PROCEDURE_TAG", dFile.getDesignProcedureTag());
        }
        return dFileMapper.selectList(queryWrapper);
    }

    /**
     *hhy
     * @param id
     * @return
     */
    @Override
    public int updateById(int id) {
        DFile dFile = new DFile();
        dFile.setDesignProcedureTag("G001-1");
        dFile.setId(id);
        return dFileMapper.updateById(dFile);
    }

    /**
     * xyb/
     * hhy
     *查询安全库存配置单表格数据
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    @Override
    public IPage<DFile> queryAllDFile(int pageno, int pagesize, DFile dFile) {
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<>();
       //xyb
        if (!StringUtils.isEmpty(dFile.getCheckTag())) {
            queryWrapper.eq("CHECK_TAG", dFile.getCheckTag());
        }
        if (!StringUtils.isEmpty(dFile.getDesignCellTag())) {
            queryWrapper.eq("DESIGN_CELL_TAG", dFile.getDesignCellTag());
        }
        if (!StringUtils.isEmpty(dFile.getProductId())) {
            queryWrapper.eq("PRODUCT_ID", dFile.getProductId());
        }
        if (!StringUtils.isEmpty(dFile.getProductName())) {
            queryWrapper.eq("PRODUCT_NAME", dFile.getProductName());
        }
//        hhy
        if (!StringUtils.isEmpty(dFile.getDesignProcedureTag())) {
            queryWrapper.eq("DESIGN_PROCEDURE_TAG", dFile.getDesignProcedureTag());
        }

        return this.page(new Page<DFile>(pageno,pagesize), queryWrapper);
    }

    /**xyb
     *查询安全库存配置单的数据
     * @param productId
     * @return
     */
    @Override
    public DFile queryByIdDFile(String productId) {
        System.out.println("queryByIdDFile1的productId"+productId);
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PRODUCT_ID",productId);
        return  this.getOne(queryWrapper);
    }
    /**xyb
     *查询安全库存配置单中的表格数据
     * @param productId
     * @return
     */
    @Override
    public List<DFile> queryByIdDFile2(String productId) {
        System.out.println("queryByIdDFile2的productId"+productId);
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PRODUCT_ID",productId);
        return  this.list(queryWrapper);
    }
}
