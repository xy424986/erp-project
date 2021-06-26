package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MProcedure;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MProcedureService extends IService<MProcedure> {
    /**
     * 根据父级id查询产品生产工序
     * @param id
     * @return
     */
    List<MProcedure> queryByparentID(int id);
}
