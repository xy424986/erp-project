package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.DFileMapper;
import com.hnguigu.service.DFileService;
import com.hnguigu.vo.DFile;
import org.springframework.stereotype.Service;

@Service
public class DFileServiceImpl extends ServiceImpl<DFileMapper, DFile> implements DFileService {
}
