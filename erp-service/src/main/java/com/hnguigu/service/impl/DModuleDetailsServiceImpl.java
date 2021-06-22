package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.DModuleDetailsMapper;
import com.hnguigu.service.DModuleDetailsService;
import com.hnguigu.vo.DModuleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DModuleDetailsServiceImpl extends ServiceImpl<DModuleDetailsMapper, DModuleDetails> implements DModuleDetailsService {
    @Autowired
    DModuleDetailsMapper dModuleDetailsMapper;
    /**
     * 物料组成设计添加的方法第三部-skl
     * @param
     * @param
     * @return
     */
    @Override
    public List<DModuleDetails> getByparentId(int parentId) {
        return dModuleDetailsMapper.getByparentId(parentId);
    }
}
