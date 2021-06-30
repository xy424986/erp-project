package com.hnguigu.service.zsxservice.m;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedureModule;

import java.util.List;

public interface DesignProcedureModuleService extends IService<DesignProcedureModule> {

    //添加工序物料
    boolean add(List<DesignProcedureModule> moduleDetails);

    //查询所有工序组成下的物料
    List<DesignProcedureModule> WuLiaoGongXuByidAll(String Id);

    //根据 Id 查询产品生产工序物料明细
    List<DesignProcedureModule> selectWuLiaoByid(String Id);

    //工序物料设计单变更 根据 id 查询产品生产工序物料明细
    List<DesignProcedureModule> SelectWLGXUpdateByidAll(String id);

    //工序物料设计单变更 - 修改部分
    boolean WLGXUupdate(List<DesignProcedureModule> moduleDetails);

    //工序物料设计单变更 - 修改部分
    List<DesignProcedureModule> ChongxinUpdate(String id);
}
