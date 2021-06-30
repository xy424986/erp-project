package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.MProceduringMapper;
import com.hnguigu.service.MProceduringService;
import com.hnguigu.vo.MProceduring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MProceduringServiceImpl extends ServiceImpl<MProceduringMapper, MProceduring> implements MProceduringService {
    @Autowired
    MProceduringMapper mProceduringMapper;
    @Override
    public List<MProceduring> selectparentid(int parentid) {
        return mProceduringMapper.selectparentid(parentid);
    }
}
