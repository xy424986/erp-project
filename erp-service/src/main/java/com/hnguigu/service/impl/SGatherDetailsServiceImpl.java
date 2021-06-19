package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.SGatherDetailsMapper;
import com.hnguigu.service.SGatherDetailsService;
import com.hnguigu.vo.SGatherDetails;
import com.hnguigu.vo.extend.SGatherEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SGatherDetailsServiceImpl extends ServiceImpl<SGatherDetailsMapper, SGatherDetails> implements SGatherDetailsService {

    @Autowired
    SGatherDetailsMapper sGatherDetailsMapper;

    /**
     * 入库调度单中的表格-xyb
     * @param parentId PARENT_ID与S_GATHER的ID相对应，为外键
     * @return
     */
    @Override
    public List<SGatherEx> queryByParentIdSGatherDetails(String parentId) {
        return sGatherDetailsMapper.queryByParentIdSGatherDetails(parentId);
    }
}
