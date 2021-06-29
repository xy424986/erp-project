package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MProcedure;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MProcedureService extends IService<MProcedure> {
    /**
     * 根据父级id查询产品生产工序-skl
     * @param id
     * @return
     */
    List<MProcedure> queryByparentID(int id);

    /**
     *生产登记复核，查询所有工序是否已经审核-skl
     * @param id
     * @return
     */
    List<MProcedure> queryByparentIDtwo(int id);
}
