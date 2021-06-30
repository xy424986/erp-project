package com.hnguigu.service.zsxservice.m;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hnguigu.vo.zsxvo.dao.QueryCondition;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedure;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedureDetails;

import java.util.List;

public interface DesignProcedureService  extends IService<DesignProcedure> {

    //添加工序
    public boolean DesignAdd(List<DesignProcedureDetails> designProcedureDetails);

    //查询要审核的工序
    public IPage<DesignProcedure> queryGongXuShenHe(int pageno, int pagesize, QueryCondition queryCondition);

    //查询所有工序
    public IPage<DesignProcedure> queryGongXuAll(int pageno, int pagesize, QueryCondition queryCondition);

    //查询审核成功工序
    public IPage<DesignProcedure> queryGongXuShenHeCG(int pageno, int pagesize, QueryCondition queryCondition);

    //查询单个工序设计单
    public DesignProcedure SelectByGongXuId(String id);

    //修改审核状态
    public boolean GongXuShenHe(DesignProcedure designProcedure,boolean type );

    //修改工序明细
    public boolean DesignUpdate(List<DesignProcedureDetails> designProcedure);

    //查询待审核工序物料
    public IPage<DesignProcedure> queryGongXuWuLiaoShenghe(int pageno, int pagesize, QueryCondition queryCondition);

    //查询待审核工序物料
    public IPage<DesignProcedure> queryGongXuWuLiaoList(int pageno, int pagesize, QueryCondition queryCondition);

    //查询待审核工序物料
    public IPage<DesignProcedure> queryGongXuWuLiaoShow(int pageno, int pagesize, QueryCondition queryCondition);

    //工序物料设计单审核 - 修改审核状态
    public boolean GongXuWuLiaoupdate(DesignProcedure designProcedure,boolean type );

    //制定工序物料设计单 - 提交添加好的数据
    public boolean GongXuWuLiaoZZ(String id);

    //工序物料设计单变更 - 显示数据
    IPage<DesignProcedure> GongXuWuLiaoUpdateShow(int pageno, int pagesize, QueryCondition queryCondition);

    //工序物料设计单变更 - 提交添加好的数据
    public boolean GXWLupdate(String id);

    //根据产品编号查询
    public DesignProcedure SelectByChanpingId(String id);
}
