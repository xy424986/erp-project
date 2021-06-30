package com.hnguigu.service.zsxservice.impl.m;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.m.ProcedureMapper;
import com.hnguigu.vo.zsxvo.dao.QueryCondition;
import com.hnguigu.vo.zsxvo.dao.ShowId;
import com.hnguigu.mapper.m.*;
import com.hnguigu.mapper.s.PayMapper;
import com.hnguigu.vo.zsxvo.pojo.m.*;
import com.hnguigu.vo.zsxvo.pojo.s.Pay;
import com.hnguigu.vo.zsxvo.pojo.s.PayDetails;
import com.hnguigu.service.zsxservice.m.ManufactureService;
import com.hnguigu.service.zsxservice.s.PayDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ManufactureServiceImpl extends ServiceImpl<ManufactureMapper, Manufacture> implements ManufactureService {

    @Autowired
    ApplyMapper applyMapper;//生产计划表
    @Autowired
    DesignProcedureMapper designProcedureMapper;//生产表
    @Autowired
    DesignProcedureDetailsMapper designProcedureDetailsMapper;//工序组成表
    @Autowired
    DesignProcedureModuleMapper designProcedureModuleMapper;//工序物料组成表

    //要添加的表
    @Autowired
    ManufactureMapper manufactureMapper;//生产总表
    @Autowired
    ProcedureMapper procedureMapper;//生产工序表
    @Autowired
    ProcedureModuleMapper procedureModuleMapper;//生产工序物料表

    //库存方面
    @Autowired
    PayMapper payMapper;//出库
    @Autowired
    PayDetailsService payDetailsService;//出库明细


    @Override
    public boolean Add(Manufacture manufacture) {
         List<String> ids = manufacture.getIds();//生产计划表的id
         for(String idstu:ids){
              Apply apply = applyMapper.selectById(idstu);
             apply.setManufactureTag("p001-1");
             applyMapper.updateById(apply);
         }
         String productId = manufacture.getProductId();//产品编号

         if (productId==null)return false;
         DesignProcedure designProcedure = designProcedureMapper.showbyParentId(productId);//查询生产表

         Manufacture MF = new Manufacture();//新建一个生产总表
         ShowId showId = new ShowId();
         String s = showId.ShengChanId(manufactureMapper.ShowManufactureId());//新的编号

        MF.setManufactureId(s);//设置编号
        MF.setProductId(manufacture.getProductId());//设置产品编号procedure_id
        MF.setProductName(designProcedure.getProductName());//设置产品名称
        MF.setAmount(manufacture.getAmount());//设置数量

        MF.setProductDescribe(manufacture.getProductDescribe());//产品描述
        MF.setTestedAmount(manufacture.getTestedAmount());//合格数量
         BigDecimal Amount = manufacture.getAmount();
        MF.setProductDescribe(manufacture.getProductDescribe());//产品描述
        BigDecimal bigDecimal = new BigDecimal(0);
        MF.setRealModuleCostPriceSum(bigDecimal);//实际物料总成本
        MF.setRealLabourCostPriceSum(bigDecimal);//实际工时总成本

        MF.setDesigner(manufacture.getDesigner());//工单制定人
        MF.setRegister(manufacture.getDesigner());//登记人
        MF.setRegisterTime(new Date());//登记时间
        MF.setRemark(manufacture.getRemark());//备注
        MF.setCheckTag("S001-0");//审核标志
        MF.setManufactureProcedureTag("S002-0");//生产过程标志
        MF.setApplyIdGroup("");

         int insert = manufactureMapper.insert(MF);//保存
        if (insert==0)return false;

        QueryWrapper<DesignProcedureDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",designProcedure.getId());
        List<DesignProcedureDetails> DPDlist = designProcedureDetailsMapper.selectList(queryWrapper);//查询生产表下的工序表
        if(DPDlist.size()==0)return false;



         StringBuffer stringBuffer = new StringBuffer();

        BigDecimal Laboursum=new BigDecimal(0);
        BigDecimal Modulesum=new BigDecimal(0);
        for (DesignProcedureDetails DPD:DPDlist){

            Procedure pd = new Procedure();//新建生产工序

            pd.setParentId(MF.getId());//父级id
            pd.setDetailsNumber(DPD.getDetailsNumber());//工序序号
            stringBuffer.append(DPD.getProcedureId()+"|");
            pd.setProcedureId(DPD.getProcedureId());//工序编号
            pd.setProcedureName(DPD.getProcedureName());//工序名称
            pd.setLabourHourAmount(DPD.getLabourHourAmount().multiply(manufacture.getAmount()));//设计工时数
            pd.setRealLabourHourAmount(bigDecimal);//实际工时数
            pd.setSubtotal(DPD.getSubtotal().multiply(Amount)); //设计工时成本
            pd.setRealSubtotal(bigDecimal);//实际工时成本
            pd.setModuleSubtotal(DPD.getModuleSubtotal().multiply(Amount));//设计物料成本
            pd.setRealModuleSubtotal(bigDecimal);//实际物料成本
            pd.setCostPrice(DPD.getCostPrice());//单位工时成本
            pd.setDemandAmount(DPD.getLabourHourAmount().multiply(Amount));//工序投产数量
            pd.setRealAmount(bigDecimal);//工序合格数量
            pd.setProcedureFinishTag("G004-0");//工序完成标志
            pd.setProcedureTransferTag("G005-0");//工序交接标志

             int insert1 = procedureMapper.insert(pd);
             if (insert1==0)return false;
            Laboursum= Laboursum.add(DPD.getSubtotal());
            QueryWrapper<DesignProcedureModule> DPDqueryWrapper1 = new QueryWrapper<>();
            DPDqueryWrapper1.eq("parent_id",DPD.getId());
            List<DesignProcedureModule> DPMList = designProcedureModuleMapper.selectList(DPDqueryWrapper1);//查询生产表下的工序物料表
            if(DPMList.size()==0)return false;

            for (DesignProcedureModule DPM :DPMList){
                 ProcedureModule pm = new ProcedureModule();//生产工序物料
                pm.setParentId(pd.getId());//父级id
                pm.setDetailsNumber(DPM.getDetailsNumber());//工序物料序号
                pm.setProductId(DPM.getProductId());//产品编号
                pm.setProductName(DPM.getProductName());//产品名称
                pm.setCostPrice(DPM.getCostPrice());//物料单价
                pm.setAmount(DPM.getAmount().multiply(Amount));//设计数量
                pm.setRenewAmount(bigDecimal);//已从库存领料数量
                pm.setRealAmount(bigDecimal);//实际使用数量
                pm.setSubtotal(DPM.getSubtotal().multiply(Amount));//设计物料成本小计
                pm.setRealSubtotal(bigDecimal);//实际物料成本小计

                Modulesum=Modulesum.add(DPM.getSubtotal());
                stringBuffer.append(DPM.getProductId()+"|");

                 int insert2 = procedureModuleMapper.insert(pm);
                 if (insert2==0)return false;
            }
        }
        MF.setLabourCostPriceSum(Laboursum.multiply(Amount));//设计工时总成本 .multiply(manufacture.getAmount())
        MF.setModuleCostPriceSum(Modulesum.multiply(Amount));//设计物料总成本 .multiply(manufacture.getAmount())
        MF.setApplyIdGroup(stringBuffer.toString());//生产计划序号组
         int i = manufactureMapper.updateById(MF);
         if (i==0)return false;
        return true;
    }

    @Override
    public IPage<Manufacture> selectShengHeAll(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<Manufacture> manufactureQueryWrapper = queryWrapper(queryCondition);
        manufactureQueryWrapper.eq("check_tag","S001-0");
        return this.page(new Page<Manufacture>(pageno,pagesize),manufactureQueryWrapper);
    }

    @Override
    public IPage<Manufacture> selectAll(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<Manufacture> manufactureQueryWrapper = queryWrapper(queryCondition);
        manufactureQueryWrapper.eq("check_tag","S001-1");
        return this.page(new Page<Manufacture>(pageno,pagesize),manufactureQueryWrapper);

    }

    @Override
    public Manufacture SelectId(String id) {
        Manufacture manufacture = this.getById(id);
        QueryWrapper<Procedure> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",manufacture.getId());
        List<Procedure> list = procedureMapper.selectList(queryWrapper);
        manufacture.setProcedureList(list);
        return manufacture;
    }

    @Override
    public boolean UpdateByid(Manufacture manufacture,boolean type){
        Manufacture manu = this.getById(manufacture.getId());
        manu.setChecker(manufacture.getChecker());
        manu.setCheckTime(new Date());
        if (type) {
            manu.setCheckTag("s001-1");
             QueryWrapper<Procedure> procedureQueryWrapper = new QueryWrapper<>();
             procedureQueryWrapper.eq("parent_id", manufacture.getId());
             List<Procedure> procedures = procedureMapper.selectList(procedureQueryWrapper);

             for (Procedure procedure:procedures){
                 Pay pay = new Pay();
                  ShowId showId = new ShowId();
                 pay.setPayId(showId.showChukuId(payMapper.ShowPayId()));//出库编号
            /*     pay.setStorer(manufacture.getChecker());//出库出库人*/
                 pay.setReason("c002-1");//出库理由
                 pay.setPayTag("k002-1");//审核状态
                 pay.setReasonexact(manu.getManufactureId()+"-"+procedure.getProcedureName());//.出库详细理由
                 pay.setAmountSum(new BigDecimal(0));
                 pay.setRemark(manufacture.getRemark());//备注
                 pay.setRegister(manufacture.getChecker());//登记人
                 pay.setRegisterTime(new Date());//登记时间 .
                 pay.setChecker(manufacture.getChecker());//审核人
                 pay.setCheckTime(new Date());//审核时间 .
                 pay.setCheckTag("1");//审核标志
                 payMapper.insert(pay);

                 QueryWrapper<ProcedureModule> queryWrapper = new QueryWrapper<>();
                 procedureQueryWrapper.eq("parent_id", manufacture.getId());
                 List<ProcedureModule> procedureModules = procedureModuleMapper.selectList(queryWrapper);
                  ArrayList<PayDetails> payDetails1 = new ArrayList<>();
                  BigDecimal amountSum =new BigDecimal(0);
                 BigDecimal costPriceSum =new BigDecimal(0);
                 for (ProcedureModule procedureModule:procedureModules){
                     PayDetails payDetails = new PayDetails();

                     payDetails.setParentId(pay.getId());//父级序号
                     payDetails.setProductId(manu.getProductId());//产品编号
                     payDetails.setProductDescribe(manu.getProductDescribe());//描述
                     payDetails.setAmount(procedureModule.getAmount());  //数量
                    /* payDetails.setAmountUnit();// amount_unit 单位*/
                     payDetails.setCostPrice(procedureModule.getCostPrice());//单价
                     payDetails.setSubtotal(procedureModule.getAmount().multiply(procedureModule.getAmount()));//小计
                     /*payDetails.setParentId();//确认出库件数*/
                     payDetails.setPayTag("k002-1");//出库标志
                     payDetails1.add(payDetails);
                     amountSum =amountSum.add(procedureModule.getAmount());
                     costPriceSum = costPriceSum.add(procedureModule.getAmount().multiply(procedureModule.getAmount()));
                 }
                 payDetailsService.saveBatch(payDetails1);
                 pay.setAmountSum(procedure.getDemandAmount());//总件数
                 pay.setCostPriceSum(procedure.getCostPrice());//总金额\
                 payMapper.updateById(pay);
             }

        }
        else
            manu.setCheckTag("s001-2");
        return this.updateById(manu);
    }

    @Override
    public IPage<Manufacture> selectDengJiAll(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<Manufacture> manufactureQueryWrapper = queryWrapper(queryCondition);
        manufactureQueryWrapper.eq("CHECK_TAG","S001-1");
        manufactureQueryWrapper.eq("MANUFACTURE_PROCEDURE_TAG","S002-0");
        return this.page(new Page<Manufacture>(pageno,pagesize),manufactureQueryWrapper);
    }

    @Override
    public IPage<Manufacture> selectSCSHAll(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<Manufacture> manufactureQueryWrapper = queryWrapper(queryCondition);
        manufactureQueryWrapper.eq("check_tag","S001-1");
        manufactureQueryWrapper.eq("manufacture_procedure_tag","S002-1");
        return this.page(new Page<Manufacture>(pageno,pagesize),manufactureQueryWrapper);
    }
    @Override
    public IPage<Manufacture> selectSCAll(int pageno, int pagesize, QueryCondition queryCondition) {
        QueryWrapper<Manufacture> manufactureQueryWrapper = queryWrapper(queryCondition);
        manufactureQueryWrapper.eq("check_tag","S001-1");
        return this.page(new Page<Manufacture>(pageno,pagesize),manufactureQueryWrapper);
    }


    /**
     * 条件查询封装
     * @param file
     * @return
     */
    public QueryWrapper<Manufacture> queryWrapper(QueryCondition file) {
        QueryWrapper<Manufacture> queryWrapper = new QueryWrapper<>();
        if (file != null) {
            //一级菜单
            if (file.getFirskindname() != null && !"".equals(file.getFirskindname())&& !"undefined".equals(file.getFirskindname())) {
                queryWrapper.like("first_kind_name", file.getFirskindname());
            }
            //二级菜单
            if (file.getSecondkindname() != null && !"".equals(file.getSecondkindname())&& !"undefined".equals(file.getSecondkindname())) {
                queryWrapper.like("second_kind_name", file.getSecondkindname());
            }
            //三级菜单
            if (file.getThirdkindname() != null && !"".equals(file.getThirdkindname())&& !"undefined".equals(file.getThirdkindname())) {
                queryWrapper.like("third_kind_name", file.getThirdkindname());
            }
            // 时间查询
            if (file.getStarttime()!=null&& file.getOvertime()!=null){
                queryWrapper.ge("register_time",file.getStarttime());
                queryWrapper.le("register_time",file.getStarttime());
            }
            //名字查询菜单
            if (file.getTjname() != null && !"".equals(file.getTjname())) {
                queryWrapper.like("product_name", file.getTjname());
            }
        }
        return queryWrapper;
    }
}
