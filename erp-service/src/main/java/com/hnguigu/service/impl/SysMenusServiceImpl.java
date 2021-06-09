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
        queryWrapper.eq("PARENT_ID", 0);
        List<SysMenus> parentMenus = this.list(queryWrapper);

        //循环菜单集合  把每一个父菜单id当成  pid 继续查询
        for (SysMenus p : parentMenus) {
            queryWrapper = new QueryWrapper<SysMenus>();
            queryWrapper.eq("PARENT_ID", p.getId());
            List<SysMenus> childMenus = this.list(queryWrapper);

            p.setChildMenu(childMenus);

            for (SysMenus p1 : childMenus) {
                queryWrapper = new QueryWrapper<SysMenus>();
                queryWrapper.eq("PARENT_ID", p1.getId());
                List<SysMenus> childMenus2 = this.list(queryWrapper);

                p1.setChildMenu(childMenus2);

                for (SysMenus p2 : childMenus2) {
                    queryWrapper = new QueryWrapper<SysMenus>();
                    queryWrapper.eq("PARENT_ID", p2.getId());
                    List<SysMenus> childMenus3 = this.list(queryWrapper);

                    p2.setChildMenu(childMenus3);
                }
            }
        }

        return parentMenus;

    }
}
