package com.hnguigu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.extend.MDesignProcedureExtend;

import java.util.List;

public interface MDesignProcedureDetailsService extends IService<MDesignProcedureDetails> {

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
}
