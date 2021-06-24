package com.hnguigu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MManuFacture;
import com.hnguigu.vo.extend.MManuFactureEx;

import java.util.List;

public interface MManuFactureService extends IService<MManuFacture> {
    /**
     * 生产查询-首页表格-xyb
     * @param pageno
     * @param pagesize
     * @param manuFacture
     * @return
     */
    IPage<MManuFacture> queryMManuFactureAll(int pageno, int pagesize, MManuFacture manuFacture);
    /**
     * 生产查询-表格-xyb
     * @param id
     * @return
     */
    List<MManuFactureEx> queryByIdMManuFactureEx1(int id);
    /**
     * 生产查询-beng-xyb
     * @param id
     * @return
     */
    MManuFacture queryByIdMManuFacture(int id);
}
