package com.hnguigu.service.zsxservice.impl.m;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.m.ProcedureMapper;
import com.hnguigu.mapper.m.ProcedureModuleMapper;
import com.hnguigu.mapper.m.ProceduringMapper;

import com.hnguigu.mapper.s.GatherDetailsMapper;
import com.hnguigu.mapper.s.GatherMapper;
import com.hnguigu.vo.zsxvo.dao.ShowId;
import com.hnguigu.mapper.d.FileMapper;
import com.hnguigu.mapper.m.ManufactureMapper;
import com.hnguigu.vo.zsxvo.pojo.d.File;
import com.hnguigu.vo.zsxvo.pojo.m.*;
import com.hnguigu.vo.zsxvo.pojo.s.Gather;
import com.hnguigu.vo.zsxvo.pojo.s.GatherDetails;
import com.hnguigu.service.zsxservice.m.ProcedureModuleService;
import com.hnguigu.service.zsxservice.m.ProcedureModulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProcedureModuleServiceImpl extends ServiceImpl<ProcedureModuleMapper, ProcedureModule> implements ProcedureModuleService {

   @Autowired
   ManufactureMapper manufactureMapper;//生产总表

   @Autowired
   ProcedureMapper procedureMapper;//生产工序表

    @Autowired
    ProcedureModulingService procedureModulingService;//生产工序物料明细表

    @Autowired
    ProceduringMapper proceduringMapper;//生产工序明细表

    @Autowired
    GatherMapper gatherMapper;//入库表

    @Autowired
    GatherDetailsMapper gatherDetailsMapper;//入库明细表

    @Autowired
    FileMapper fileMapper; //档案表

    @Override
    public List<ProcedureModule> SelectByParentId(String id) {
        QueryWrapper<ProcedureModule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id);
        return this.list(queryWrapper);
    }

    @Override
    public boolean GongXuAdd(List<ProcedureModule> procedureModules) {
         ProcedureModule PM = procedureModules.get(0);

        Procedure procedure = procedureMapper.selectById(PM.getParentId());//生产工序表
        Manufacture manufacture = manufactureMapper.ShowByProcedureId(PM.getParentId());//生产总表

        if (PM.isIswancheng())
            procedure.setProcedureFinishTag("G004-1");
        else
            procedure.setProcedureFinishTag("G004-2");

        manufacture.setManufactureProcedureTag("S002-1");


        manufactureMapper.updateById(manufacture);

        Proceduring proceduring = new Proceduring();// 生产工序过程记录
        proceduring.setParentId(manufacture.getId());//父级序号
        proceduring.setDetailsNumber(procedure.getDetailsNumber());//工序序号
        proceduring.setProcedureId(procedure.getProcedureId());//工序编号
        proceduring.setProcedureName(procedure.getProcedureName());//工序名称
        proceduring.setLabourHourAmount(PM.getGss());//本次工时数
        BigDecimal gss = PM.getGss();
        proceduring.setCostPrice(procedure.getCostPrice());//单位工时成本
        proceduring.setSubtotal(procedure.getCostPrice().multiply(gss));//工时成本小计
        proceduring.setProcedureDescribe(null);//工序描述
        proceduring.setRegCount(new BigDecimal(1));//登记次数
        proceduring.setProcedureResponsiblePerson(PM.getShr());//负责人
        proceduring.setRegister(PM.getShr());//登记人
        proceduring.setRegisterTime(new Date());//登记时间
        proceduringMapper.insert(proceduring);

        procedure.setRealLabourHourAmount(gss.add(procedure.getRealLabourHourAmount()));//实际工时数
        procedure.setRealSubtotal((procedure.getCostPrice().multiply(gss)).add(procedure.getRealSubtotal()));//实际工时成本



        QueryWrapper<ProcedureModule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",procedure.getId());
         List<ProcedureModule> list = this.list(queryWrapper);
        ArrayList<ProcedureModuling> procedureModuleings = new ArrayList<>();


        BigDecimal ModuleSubtotal= new BigDecimal(0);//
        for (int i=0;i<list.size();i++){
            ProcedureModule procedureModule = list.get(i);
            ProcedureModuling procedureModuleing = new ProcedureModuling();
            procedureModuleing.setProductId(procedureModule.getProductId());//产品编号
            procedureModuleing.setParentId(proceduring.getId());//父级序号
            procedureModuleing.setDetailsNumber(procedureModule.getDetailsNumber());//本工序物料序号
            procedureModuleing.setProductId(procedureModule.getProductId());//产品编号
            procedureModuleing.setProductName(procedureModule.getProductName());//产品名称
            procedureModuleing.setCostPrice(procedureModule.getCostPrice());//单位物料成本
            BigDecimal amount = procedureModules.get(i).getSl();//数量
            procedureModuleing.setAmount(amount);//输入的数量

            if (procedureModule.getRealAmount()==new BigDecimal(0))
                procedureModule.setRealAmount(procedureModule.getRealAmount().add(amount));//实际使用数量
            else
                procedureModule.setRealAmount(amount);//实际使用数量


            BigDecimal multiply = procedureModule.getCostPrice().multiply(amount);
            procedureModuleing.setSubtotal(multiply);//物料成本小计
            ModuleSubtotal=ModuleSubtotal.add(multiply);
            procedureModuleings.add(procedureModuleing);
        }
        procedure.setRealModuleSubtotal(ModuleSubtotal.add(procedure.getRealModuleSubtotal()));//实际物料成本
        this.updateBatchById(list);
        procedureMapper.updateById(procedure);
         boolean b = procedureModulingService.saveBatch(procedureModuleings);
        return true;
    }

    @Override
    public boolean Shenghe(Integer id, boolean type) {
        Manufacture manufacture = manufactureMapper.ShowByProcedureId(id);
        Procedure pd = procedureMapper.selectById(id);
        if (type){
            manufacture.setManufactureProcedureTag("S002-0");//总表审核状态
            String procedureFinishTag = pd.getProcedureFinishTag();//工序表审核状态
            if ("G004-1".equals(procedureFinishTag))//完成设置
                pd.setProcedureFinishTag("G004-3");
            if("G004-2".equals(procedureFinishTag)) //未完成设置
                pd.setProcedureFinishTag("G004-0");
        }else{
            manufacture.setManufactureProcedureTag("S002-2");//审核状态
        }
        procedureMapper.updateById(pd);
        manufactureMapper.updateById(manufacture);
        return true;
    }

    @Override
    public boolean JiaojieAdd(Integer id,Integer shuliang) {
        Manufacture manufacture = manufactureMapper.ShowByProcedureId(id);
        Procedure procedure = procedureMapper.selectById(id);

        procedure.setRealAmount(new BigDecimal(shuliang));
        procedure.setProcedureTransferTag("G005-1");//工序交接设置

        manufacture.setManufactureProcedureTag("S002-1");

        int i = manufactureMapper.updateById(manufacture);
        if(i==0){ return false; }
        int i1 = procedureMapper.updateById(procedure);
        if(i1==0){ return false; }
        return true;
    }
    @Override
    @Transactional
    public boolean ShengheJiaojie(Integer id, boolean type) {

        Manufacture manufacture = manufactureMapper.ShowByProcedureId(id);
        Procedure procedure = procedureMapper.selectById(id);

        procedure.setProcedureTransferTag("G005-2");//审核状态
        manufacture.setManufactureProcedureTag("S002-0");//生产状态

        procedureMapper.updateById(procedure);

        QueryWrapper<Procedure> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",manufacture.getId());
        List<Procedure> procedures = procedureMapper.selectList(queryWrapper);
        int panduan=0;

        BigDecimal sum=new BigDecimal(0);//工序实际数量所缺的数量

        BigDecimal ModuleSubtotal = new BigDecimal("0");
        BigDecimal Subtotal = new BigDecimal("0");
        for(Procedure pd:procedures){
            ModuleSubtotal=ModuleSubtotal.add(pd.getRealModuleSubtotal());//实际物料成本
            Subtotal=Subtotal.add(pd.getRealSubtotal());//实际工时成本
            BigDecimal ji=pd.getRealAmount();//合格数量
            BigDecimal demandAmount = pd.getDemandAmount();//设计数量
            if (demandAmount.compareTo(ji) == 1){
                if (demandAmount.subtract(ji).compareTo(sum) == 1){
                    sum=demandAmount.subtract(ji);
                }
            }
            if ("G004-3".equals(pd.getProcedureFinishTag())){
                panduan++;
            }
        }
        if (panduan==procedures.size()){ //没有工序审核就
            manufacture.setRealModuleCostPriceSum(ModuleSubtotal);//设置物料总成
            manufacture.setRealLabourCostPriceSum(Subtotal);//设置工时总成
            manufacture.setTestedAmount(manufacture.getAmount().subtract(sum));//合格数量
            manufacture.setManufactureProcedureTag("S002-2");//生产过程标志
            ShowId showId = new ShowId();
            Gather gather=new Gather();//创建入库表
            String chukuId = showId.showChukuId(gatherMapper.showGatherid());
            gather.setGatherId(chukuId);//入库单编号
            gather.setReason("r001-1");
            gather.setReasonexact(manufacture.getManufactureId()+"生产入库");//入库详细理由
            gather.setAmountSum(manufacture.getTestedAmount());//总件数

            File file = fileMapper.selectProductId(manufacture.getProductId());

            gather.setCostPriceSum(manufacture.getRealLabourCostPriceSum().multiply(manufacture.getRealModuleCostPriceSum()));//总金额
           /* gather.setGatheredAmountSum(manufacture.getTestedAmount());//确认入库总件数*/
            gather.setRemark("生产入库");//备注
            gather.setRegister(manufacture.getChecker());//登记人
            gather.setCheckTime(new Date());//登记时间
            gather.setGatherTag("k002-1");//库存标志
            gather.setCheckTag("s001-1");//审核标志
            gather.setCheckTime(new Date());//审核时间
            gather.setChecker(manufacture.getChecker());
            gatherMapper.insert(gather);



            GatherDetails gatherDetails = new GatherDetails();//创建出库明细表
            gatherDetails.setParentId(gather.getId());//父级序号
            gatherDetails.setProductId(manufacture.getProductId());//产品编号
            gatherDetails.setProductName(manufacture.getProductName());//产品名称
            gatherDetails.setProductDescribe(manufacture.getProductDescribe());//描述
            gatherDetails.setAmount(manufacture.getTestedAmount());//数量
            gatherDetails.setAmountUnit(file.getAmountUnit());//单位
            gatherDetails.setSubtotal(file.getCostPrice());//小计
            gatherDetails.setGatherTag("k002-1");
            gatherDetailsMapper.insert(gatherDetails);

        }
        int i = manufactureMapper.updateById(manufacture);
        if (i==0)return false;

        return true;
    }



}
