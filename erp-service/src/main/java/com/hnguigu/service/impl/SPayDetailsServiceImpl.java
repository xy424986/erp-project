package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.SPayDetailsMapper;
import com.hnguigu.service.SPayDetailsService;
import com.hnguigu.vo.SPayDetails;
import com.hnguigu.vo.extend.SPayEX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SPayDetailsServiceImpl extends ServiceImpl<SPayDetailsMapper, SPayDetails> implements SPayDetailsService {

    @Autowired
    SPayDetailsMapper sPayDetailsMapper;
    /**
     * 出库调度单中的表格-xyb
     * @param parentId PARENT_ID与S_GATHER的ID相对应，为外键
     * @return
     */
    @Override
    public List<SPayEX> queryByParentIdSPayDetails(String parentId) {
        List<SPayEX> sPayEXES = sPayDetailsMapper.queryByParentIdSPayDetails(parentId);
        System.out.println(sPayEXES.toArray());
        for (SPayEX s:sPayEXES) {
            System.out.println(s);
        }
        return sPayEXES;
    }
    /**
     * 出库查询-查看-xyb
     * @param id
     * @return
     */
    @Override
    public SPayEX queryByIdSPayEX(int id) {
        System.out.println("queryByIdSPayEX-id:"+id);
        return sPayDetailsMapper.queryByIdSPayEX(id);
    }

    /**
     * 出库查询-查看-表格-xyb
     * @param id
     * @return
     */
    @Override
    public List<SPayEX> queryByIdSPayEX2(int id) {
        System.out.println("queryByIdSPayEX2-id:"+id);
        return sPayDetailsMapper.queryByIdSPayEX2(id);
    }
}
