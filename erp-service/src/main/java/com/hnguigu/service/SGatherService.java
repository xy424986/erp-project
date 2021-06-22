package com.hnguigu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.util.PutInStorage;
import com.hnguigu.util.Scheduling;
import com.hnguigu.vo.SGather;
import com.hnguigu.vo.extend.SGatherEx;

import java.util.List;

public interface SGatherService extends IService<SGather> {

    /**
     * 入库调度-总数据查询-xyb
     * @param pageNo
     * @param pageSize
     * @param sGather
     * @return
     */
    IPage<SGather> queryAllSGather(int pageNo, int pageSize, SGather sGather);
    /**
     * 入库调度单-查询-xyb
     *
     * @param id @return
     */
     SGatherEx queryByIdSGatherEx(int id);
    /**
     * 入库调度-xyb
     * @param scheduling 入库调度特制beng
     * @return
     */
     String addSGather(Scheduling scheduling);
    /**
     * 入库调度单总调度-xyb
     * @param gatherId 入库编号
     * @return
     */
    SGather queryByGatherIdSGather(String gatherId);
    /**
     * 入库-复核-xyb
     * @param sGather
     * @return
     */
    boolean amendSGather(SGather sGather);
    /**
     * 入库登记-xyb
     * @param putInStorages
     * @return
     */
    boolean addPutInStorage(List<PutInStorage> putInStorages);
}
