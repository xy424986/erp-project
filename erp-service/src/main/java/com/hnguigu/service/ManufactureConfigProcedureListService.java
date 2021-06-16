package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.ManufactureConfigProcedureList;

import java.util.List;

public interface ManufactureConfigProcedureListService extends IService<ManufactureConfigProcedureList> {
    List<ManufactureConfigProcedureList> queryAll();
}
