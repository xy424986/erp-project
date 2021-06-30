package com.hnguigu.service.zsxservice.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.sys.MenusMapper;
import com.hnguigu.vo.zsxvo.pojo.sys.Menus;
import com.hnguigu.service.zsxservice.sys.MenusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusServiceImpl  extends ServiceImpl<MenusMapper, Menus> implements MenusService {

    @Override
    public List<Menus> queryallmenus() {
        //查找父菜单 为pid 的菜单集合
        QueryWrapper<Menus> queryWrapper = new QueryWrapper<Menus>();
        queryWrapper.eq("parent_id",0);
        List<Menus> parents = this.list(queryWrapper);
        Chaxun(parents);
        return parents;
    }

    public List<Menus> Chaxun(List<Menus> list){
        for (Menus menu:list){
            QueryWrapper<Menus> queryWrapper = new QueryWrapper<Menus>();
            queryWrapper = new QueryWrapper<Menus>();
            queryWrapper.eq("parent_id",menu.getId());
            List<Menus> childs = this.list(queryWrapper);
            if (childs!=null){
                Chaxun(childs);
            }
            menu.setChildMenu(childs);
        }
        return list;
    }
}
