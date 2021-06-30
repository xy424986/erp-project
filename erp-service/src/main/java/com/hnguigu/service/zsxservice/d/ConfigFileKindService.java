package com.hnguigu.service.zsxservice.d;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.zsxvo.pojo.d.ConfigFileKind;

import java.util.List;

public interface ConfigFileKindService extends IService<ConfigFileKind> {

    public List<ConfigFileKind> isSanjild();
}
