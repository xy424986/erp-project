package com.hnguigu.service.zsxservice.m;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.zsxvo.dao.QueryCondition;
import com.hnguigu.vo.zsxvo.pojo.m.Manufacture;

public interface ManufactureService extends IService<Manufacture> {

    // 制定生产派工单 - 添加
    boolean Add(Manufacture manufacture);

    // 生产派工单审核-显示数据
    IPage<Manufacture> selectShengHeAll(int pageno, int pagesize, QueryCondition queryCondition);

    // 生产派工单查询-显示数据
    IPage<Manufacture> selectAll(int pageno, int pagesize, QueryCondition queryCondition);

    //根据id查询 生产总表
    Manufacture SelectId(String id);

    //修改审核状态
    boolean UpdateByid(Manufacture manufacture ,boolean type);

    //生产登记-显示数据
    IPage<Manufacture> selectDengJiAll(int pageno, int pagesize, QueryCondition queryCondition);

    //生产审核-显示数据
    IPage<Manufacture>  selectSCSHAll(int pageno, int pagesize, QueryCondition queryCondition);

    //生产查看-显示数据
    IPage<Manufacture>  selectSCAll(int pageno, int pagesize, QueryCondition queryCondition);


}
