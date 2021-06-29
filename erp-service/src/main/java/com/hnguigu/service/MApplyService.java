package com.hnguigu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MApply;
import com.hnguigu.vo.ManufactureConfigProcedureList;

import java.util.List;

public interface MApplyService extends IService<MApply> {
    /**
     * 制定生产派工单：根据产品编号查询生产计划数据
     * @param productId
     * @return
     */
    public MApply queryByproductId(String productId);

    /**
     *  hhy
     * @param pageno
     * @param pagesize
     * @param mApply
     * @return
     */
    IPage<MApply> queryAll(int pageno, int pagesize, MApply mApply);

    /**
     * hhy
     * @param mApply
     * @return
     */
    List<MApply> queryById(MApply mApply);

    /**
     * hhy
     * @param mApply
     * @return
     */
    int updateStateById(MApply mApply);

    /**
     * hhy
     * 根据状态查找审核数据
     * @param mApply
     * @return
     */
    List<MApply> queryByState(MApply mApply);

    /**
     * hhy
     * @param mApplyList
     * @return
     */
    int insert(List<MApply> mApplyList);
}
