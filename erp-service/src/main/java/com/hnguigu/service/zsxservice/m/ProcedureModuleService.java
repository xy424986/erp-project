package com.hnguigu.service.zsxservice.m;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.zsxvo.pojo.m.ProcedureModule;

import java.util.List;

public interface ProcedureModuleService extends IService<ProcedureModule> {

    //根据 ParentId 查找工序物料
    List<ProcedureModule> SelectByParentId(String id);

    //生产登记-提交模态框的数据
    boolean GongXuAdd (List<ProcedureModule> procedureModules);

    //生产审核-登记提交数据
    boolean Shenghe(Integer id ,boolean type);

    //生产审核-交接提交数据
    boolean ShengheJiaojie(Integer id, boolean type);

    //生产登记-交际提交数据
    boolean JiaojieAdd(Integer id,Integer shuliang);
}
