package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.SysMenus;

import java.util.List;

public interface SysMenusService extends IService<SysMenus> {

    List<SysMenus> queryAllMenus();
}
