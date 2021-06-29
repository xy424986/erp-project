package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.MDesignProcedureDetails;
import com.hnguigu.vo.MDesignProcedureModule;
import com.hnguigu.vo.extend.MDesignProcedureDetailsExtend;
import com.hnguigu.vo.extend.MDesignProcedureExtend;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MDesignProcedureModuleService extends IService<MDesignProcedureModule> {

    /**
     *
     * @param mDesignProcedureDetailsExtendList
     * @return
     */
    int insert(List<MDesignProcedureDetailsExtend> mDesignProcedureDetailsExtendList);

    /**
     * hhy
     * @param mDesignProcedureModule
     * @return
     */
    List<MDesignProcedureModule> queryByPId(MDesignProcedureModule mDesignProcedureModule);

    /**
     * 根据父级编号查询工序所需物料-skl
     * @param id
     * @return
     */
    List<MDesignProcedureModule> queryByparentId(int id);

}
