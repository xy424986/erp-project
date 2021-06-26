package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.hnguigu.vo.DModule;

import java.util.List;

public interface DModuleService extends IService<DModule> {
    /**
     * 物料组成查询
     * @param pageno
     * @param pagesize
     * @return
     */
    PageInfo<DModule> query_design_sheetdata(int pageno, int pagesize);

    /**
     * hhy
     * @param dModule
     * @return
     */
    DModule queryByDesignId(DModule dModule);
}
