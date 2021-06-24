package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.util.StringUtil;
import com.hnguigu.mapper.MManuFactureMapper;
import com.hnguigu.service.MManuFactureService;
import com.hnguigu.vo.MManuFacture;
import com.hnguigu.vo.SPay;
import com.hnguigu.vo.extend.MManuFactureEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MManuFactureServiceImpl extends ServiceImpl<MManuFactureMapper, MManuFacture> implements MManuFactureService {
    @Autowired
    MManuFactureMapper mManuFactureMapper;

    /**
     * 生产查询-首页表格-xyb
     * @param pageno
     * @param pagesize
     * @param manuFacture
     * @return
     */
    @Override
    public IPage<MManuFacture> queryMManuFactureAll(int pageno, int pagesize, MManuFacture manuFacture) {
        QueryWrapper<MManuFacture> sPayQueryWrapper = new QueryWrapper<MManuFacture>();
        if (!StringUtil.isEmpty(manuFacture.getProductId()))
            sPayQueryWrapper.eq("PRODUCT_ID",manuFacture.getProductId());
        return  this.page(new Page<MManuFacture>(pageno, pagesize), sPayQueryWrapper);

    }
    /**
     * 生产查询-表格-xyb
     * @param id
     * @return
     */
    @Override
    public List<MManuFactureEx> queryByIdMManuFactureEx1(int id) {
        System.out.println("queryByIdMManuFactureEx1-id:"+id);
        return mManuFactureMapper.queryByIdMManuFactureEx1(id);
    }
    /**
     * 生产查询-beng-xyb
     * @param id
     * @return
     */
    @Override
    public MManuFacture queryByIdMManuFacture(int id) {
        System.out.println("queryByIdMManuFacture-id:"+id);
        return this.getById(id);
    }
}
