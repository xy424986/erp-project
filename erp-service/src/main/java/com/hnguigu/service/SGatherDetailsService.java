package com.hnguigu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SGatherDetails;

import com.hnguigu.vo.extend.SGatherEx;

import java.util.List;

public interface SGatherDetailsService extends IService<SGatherDetails> {

    /**
     * 入库调度单中的表格-xyb
     * @param parentId PARENT_ID与S_GATHER的ID相对应，为外键
     * @return
     */
    List<SGatherEx> queryByParentIdSGatherDetails(String parentId);
    /**
     * 入库查询-查看-xyb
     * @param id
     * @return
     */
    SGatherEx queryByIdSGatherEx(int id);
    /**
     * 入库查询-查看-表格-xyb
     * @param id
     * @return
     */
    List<SGatherEx> queryByIdSGatherEx2(int id);
    //   入库申请中的表格
    List<DFile> queryAll();
}
