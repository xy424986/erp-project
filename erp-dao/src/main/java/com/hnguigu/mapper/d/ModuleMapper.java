package com.hnguigu.mapper.d;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.zsxvo.pojo.d.Module;
import org.apache.ibatis.annotations.Select;

public interface ModuleMapper  extends BaseMapper<Module> {
    @Select("SELECT d_module.DESIGN_ID FROM d_module ORDER BY 'id' DESC LIMIT 0,1")
    String getLoginId();
}