package com.hnguigu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.extend.MDesignProcedureDetailsExtend;
import com.hnguigu.vo.extend.MDesignProcedureExtend;

import java.util.List;

public interface MDesignProcedureDetailsService extends IService<MDesignProcedureDetails> {

    /**
     * hhy
     * @param mDesignProcedureExtendList
     * @return
     */
    int updateByPId(List<MDesignProcedureExtend> mDesignProcedureExtendList);

    /**
     * hhy
     * @param mDesignProcedureDetailsExtendList
     * @return
     */
    int update(List<MDesignProcedureDetailsExtend> mDesignProcedureDetailsExtendList);

    /**
     * hhy
     * @param mDesignProcedureDetails
     * @return
     */
    List<MDesignProcedureDetails> queryByPId(MDesignProcedureDetails mDesignProcedureDetails);

    /**
     * hhy
     * @param mDesignProcedureExtend
     * @return
     */
    int insert(List<MDesignProcedureExtend> mDesignProcedureExtend);
    /**
     * 根据产品生产工序id查询相应的工序明细
     * @param id
     * @return
     */
    public List<MDesignProcedureDetails> queryByparentId(int id);
}
