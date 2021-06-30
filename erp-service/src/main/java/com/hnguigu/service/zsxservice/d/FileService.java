package com.hnguigu.service.zsxservice.d;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.zsxvo.dao.QueryCondition;
import com.hnguigu.vo.zsxvo.pojo.d.File;

public interface FileService  extends IService<File> {

    //查询已删除的产品档案
    public IPage<File> queryDelete(int pageno, int pagesize,QueryCondition queryCondition);

    //查询未审核的产品档案
    public IPage<File> queryNoShenghe(int pageno, int pagesize,QueryCondition queryCondition);

    //查询需要组装的产品档案
    public IPage<File> queryFlieZuZuang(int pageno, int pagesize,QueryCondition queryCondition);

    //查询需要生产计划工序的产品档案
    public IPage<File> queryFlieShengChanGongXu(int pageno, int pagesize,QueryCondition queryCondition);

    //查询需要生产计划工序的产品档案
    public IPage<File> queryGongXu(int pageno, int pagesize,QueryCondition queryCondition);

    //查询可以生产的物料
    public IPage<File> querykeSC(int pageno, int pagesize,QueryCondition queryCondition);

}
