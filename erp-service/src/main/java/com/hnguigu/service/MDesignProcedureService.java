package com.hnguigu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.DFile;
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

    IPage<MDesignProcedure> queryAll(int pageno, int pagesize, MDesignProcedure mDesignProcedure);
}
