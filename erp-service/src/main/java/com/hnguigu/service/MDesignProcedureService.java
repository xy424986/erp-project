package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MDesignProcedure;
import com.hnguigu.vo.extend.MDesignProcedureExtend;

import java.util.List;

public interface MDesignProcedureService extends IService<MDesignProcedure> {
    /**
     * hhy
     * @param mDesignProcedureExtend
     * @return
     */
    int insert(List<MDesignProcedureExtend> mDesignProcedureExtend);
}
