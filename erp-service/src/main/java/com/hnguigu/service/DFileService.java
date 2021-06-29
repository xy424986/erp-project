package com.hnguigu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.DFile;

import java.util.List;

public interface DFileService extends IService<DFile> {

    /**
     * hhy
     * 根据id修改生产工序设计单数据
     * @param id
     * @return
     */
    int updateById(int id);

    /**
     * hhy
     * 根据复核状态查询生产吉华登记数据
     * @param dFile
     * @return
     */
    List<DFile> queryByState(DFile dFile);

    /**xyb
     *查询安全库存配置单表格数据
     * @param pageno
     * @param pagesize
     * @param dFile
     * @return
     */
    IPage<DFile> queryAllDFile( int pageno,int pagesize,DFile dFile);

    /**xyb
     *查询安全库存配置单的数据
     * @param productId
     * @return
     */
    DFile queryByIdDFile(String productId);

    /**xyb
     *查询安全库存配置单中的表格数据
     * @param productId
     * @return
     */
    List<DFile> queryByIdDFile2(String productId);

}
