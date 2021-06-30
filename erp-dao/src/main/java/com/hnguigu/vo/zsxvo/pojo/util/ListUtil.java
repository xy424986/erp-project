package com.hnguigu.vo.zsxvo.pojo.util;

import com.hnguigu.vo.zsxvo.pojo.d.Module;
import com.hnguigu.vo.zsxvo.pojo.d.ModuleDetails;
import lombok.Data;

import java.util.List;

@Data
public class ListUtil {
    private Module module;
    private List<ModuleDetails> moduleDetailsList;
}
