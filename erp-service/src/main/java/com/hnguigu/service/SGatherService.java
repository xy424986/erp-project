package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.hnguigu.util.Scheduling;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SGather;
import com.hnguigu.vo.ex.SGatherEx;

public interface SGatherService extends IService<SGather> {

    /**
     * 入库调度-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sGather
     * @return
     */
    PageInfo<DFile> queryAllSGather(int pageNo, int pageSize, SGather sGather);

    /**
     * 入库调度单-查询-xyb
     *
     * @param productId@return
     */
     SGatherEx queryByIdSGatherEx(String productId);
    /**
     * 入库调度-xyb
     * @param scheduling 入库调度特制beng
     * @return
     */
     String addSGather(Scheduling scheduling);
}
