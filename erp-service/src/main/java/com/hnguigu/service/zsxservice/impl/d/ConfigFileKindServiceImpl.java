package com.hnguigu.service.zsxservice.impl.d;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.d.ConfigFileKindMapper;
import com.hnguigu.vo.zsxvo.pojo.d.ConfigFileKind;
import com.hnguigu.service.zsxservice.d.ConfigFileKindService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigFileKindServiceImpl  extends ServiceImpl<ConfigFileKindMapper, ConfigFileKind> implements ConfigFileKindService {
    @Override
    public List<ConfigFileKind> isSanjild() {

        //查找一级菜单 id  ==0 的菜单集合
        QueryWrapper<ConfigFileKind> queryWrapper = new QueryWrapper<ConfigFileKind>();
        queryWrapper.eq("P_ID",0);
        List<ConfigFileKind> parents = this.list(queryWrapper);
        show(parents);
        //循环一级菜单集合  把每一个一级菜单id当成  pid 继续查询
        for(ConfigFileKind p:parents ){
            queryWrapper = new QueryWrapper<ConfigFileKind>();
            queryWrapper.eq("P_id",p.getId());
            List<ConfigFileKind> childs = this.list(queryWrapper);
            show(childs);
            //循环二级菜单集合  把每一个二级菜单id当成  pid 继续查询
            for (ConfigFileKind m:childs ){
                queryWrapper = new QueryWrapper<ConfigFileKind>();
                queryWrapper.eq("P_id",m.getId());
                List<ConfigFileKind> childs2 = this.list(queryWrapper);
                show(childs2);
                m.setChildren(childs2);
            }

            p.setChildren(childs);
        }
        return parents;
    }

    public List<ConfigFileKind> show(List<ConfigFileKind> list){
        for (ConfigFileKind configFileKind:list ){
            configFileKind.setValue(configFileKind.getId());
            configFileKind.setLabel(configFileKind.getKindName());
        }
        return list;
    }
}
