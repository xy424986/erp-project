package com.hnguigu.service.zsxservice.d;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.zsxvo.pojo.d.Module;
import com.hnguigu.vo.zsxvo.pojo.d.ModuleDetails;
import com.hnguigu.vo.zsxvo.pojo.util.ListUtil;
import com.hnguigu.vo.zsxvo.pojo.util.ResultUtil;

import java.util.List;

public interface ModuleService extends IService<Module> {
    ResultUtil saveBatchExtend(List<ModuleDetails> roleMenus);

    ListUtil selectById(int id);

    ResultUtil deleteById(int id);

    ResultUtil checkTag(int id, String checker);

    ResultUtil updateBatchExtend(List<ModuleDetails> moduleDetails);
}
