package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.ManufactureConfigProcedureListMapper;
import com.hnguigu.service.ManufactureConfigProcedureListService;
import com.hnguigu.vo.ManufactureConfigProcedureList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureConfigProcedureListServiceImpl extends ServiceImpl<ManufactureConfigProcedureListMapper, ManufactureConfigProcedureList> implements ManufactureConfigProcedureListService {

    @Autowired
    ManufactureConfigProcedureListMapper manufactureConfigProcedureListMapper;

    @Override
    public List<ManufactureConfigProcedureList> queryAll() {

        return manufactureConfigProcedureListMapper.selectList(null);
    }
}
