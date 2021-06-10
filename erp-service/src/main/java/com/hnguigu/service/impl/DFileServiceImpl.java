package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.DFileMapper;
import com.hnguigu.service.DFileService;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.DModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DFileServiceImpl extends ServiceImpl<DFileMapper, DFile> implements DFileService {

    @Autowired
    DFileMapper dFileMapper;

    /**
     * hhy
     * 根据复核状态查询生产工序设计单数据
     * 状态：
     * S001-0: 等待审核
     * S001-1: 审核通过
     * S001-2: 审核不通过
     * @param state
     * @return
     */
    @Override
    public List<DFile> queryByState(String state) {
        QueryWrapper<DFile> queryWrapper = new QueryWrapper<DFile>();
        queryWrapper.eq("CHECK_TAG", state);
        return dFileMapper.selectList(queryWrapper);
    }
}
