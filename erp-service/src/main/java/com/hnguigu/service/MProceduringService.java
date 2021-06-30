package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MProceduring;

import java.util.List;

public interface MProceduringService extends IService<MProceduring> {
    List<MProceduring> selectparentid(int parentid);
}
