package com.hnguigu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.SysMenusMapper;
import com.hnguigu.service.SysMenusService;
import com.hnguigu.vo.SysMenus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenusServiceImpl extends ServiceImpl<SysMenusMapper, SysMenus> implements SysMenusService {
    @Override
    public List<SysMenus> queryAllMenus() {
        //查找父菜单id  ==0 的菜单集合
        QueryWrapper<SysMenus> queryWrapper = new QueryWrapper<SysMenus>();
        queryWrapper.eq("PARENT_ID",0);
        List<SysMenus> parents = this.list(queryWrapper);

        //循环菜单集合  把每一个父菜单id当成  pid 继续查询
        for(SysMenus p:parents ){
            queryWrapper = new QueryWrapper<SysMenus>();
            queryWrapper.eq("PARENT_ID",p.getId());
            List<SysMenus> childs = this.list(queryWrapper);

            p.setChildMenu(childs);
        }

        return parents;

    }
}
