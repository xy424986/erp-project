package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SCell;
import com.hnguigu.vo.extend.SCellEx;

import javax.servlet.http.HttpSession;
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
    PageInfo<SCellEx> queryAllSCll(int pageNo, int pageSize, DFile dFile, String tag, String tag2);
    /**
     *查询安全库存配置单-复核的数据-xyb
     * @param id
     * @param session
     * @return
     */
    SCell queryByIdSCell(String id, HttpSession session);
    /**
     *查询安全库存配置单中的-复核表格数据-xyb
     * @param id
     * @return
     */
    List<SCell> queryByIdSCell2(String id);
    /**
     * 制作安全库存配置单-复核-xyb
     * @param id,sCell
     * @param sCell
     * @return
     */
    boolean amendCheckTag(int id, SCell sCell);
    /**
     * 制作安全库存配置单-修改-xyb
     * @param sCell
     * @return
     */
    public boolean amendSCll(SCell sCell);
    /**
     * 安全库存配置单-查询-总数据查询-xyb
     * @return
     */
    PageInfo<SCellEx> queryAllSCll2(int pageno, int pagesize, DFile dFile, String s, String s1);
}
