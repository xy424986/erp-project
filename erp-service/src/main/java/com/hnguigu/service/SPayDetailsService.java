package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.SPay;
import com.hnguigu.vo.SPayDetails;
import com.hnguigu.vo.extend.SPayEX;

import java.util.List;

public interface SPayDetailsService extends IService<SPayDetails> {
    /**
     * 出库调度单中的表格-xyb
     * @param parentId PARENT_ID与S_GATHER的ID相对应，为外键
     * @return
     */
    List<SPayEX> queryByParentIdSPayDetails(String parentId);
    /**
     * 出库查询-查看-xyb
     * @param id
     * @return
     */
    SPayEX queryByIdSPayEX(int id);
    /**
     * 出库查询-查看-表格-xyb
     * @param id
     * @return
     */
    List<SPayEX> queryByIdSPayEX2(int id);

}
