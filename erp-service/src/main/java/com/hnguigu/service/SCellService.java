package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SCell;

import java.util.List;

public interface SCellService extends IService<SCell> {
    /**
     * 制作安全库存配置单-添加-xyb
     * @param sCell
     * @return
     */
    boolean addSCll(SCell sCell);
    /**
     * 安全库存配置单-复核-总数据查询-xyb
     * @return
     */
    PageInfo<DFile> queryAllSCll(int pageNo, int pageSize, DFile dFile,String tag,String tag2);
    /**
     *查询安全库存配置单-复核的数据-xyb
     * @param id
     * @return
     */
    SCell queryByIdSCell(String id);
    /**
     *查询安全库存配置单中的-复核表格数据-xyb
     * @param id
     * @return
     */
    List<SCell> queryByIdSCell2(String id);
    /**
     * 制作安全库存配置单-复核-xyb
     * @param id,CheckTag
     * @return
     */
    boolean amendCheckTag(int id,String CheckTag);
    /**
     * 制作安全库存配置单-修改-xyb
     * @param sCell
     * @return
     */
    public boolean amendSCll(SCell sCell);
}
