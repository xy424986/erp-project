package com.hnguigu.service.zsxservice.impl.m;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.d.ModuleDetailsMapper;
import com.hnguigu.mapper.m.DesignProcedureDetailsMapper;
import com.hnguigu.mapper.m.DesignProcedureModuleMapper;
import com.hnguigu.vo.zsxvo.pojo.d.ModuleDetails;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedureDetails;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedureModule;
import com.hnguigu.service.zsxservice.m.DesignProcedureModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DesignProcedureModuleServiceImpl extends ServiceImpl<DesignProcedureModuleMapper, DesignProcedureModule> implements DesignProcedureModuleService {

    @Autowired
    ModuleDetailsMapper moduleDetailsMapper;

    @Autowired
    DesignProcedureDetailsMapper designProcedureDetailsMapper;

    @Autowired
    DesignProcedureModuleMapper designProcedureModuleMapper;

    @Override
    public boolean add(List<DesignProcedureModule> designProcedureModules) {
        Integer parentId = designProcedureModules.get(0).getParentId();
        DesignProcedureDetails designProcedureDetails = designProcedureDetailsMapper.selectById(parentId);
        designProcedureDetails.setDesignModuleTag("1");

        int a = 1;
        BigDecimal sum = new BigDecimal(0);
        for (DesignProcedureModule m:designProcedureModules){
            ModuleDetails moduleDetails1 = moduleDetailsMapper.selectById(m.getId());

            m.setDetailsNumber(a++);

            moduleDetails1.setResidualAmount(moduleDetails1.getResidualAmount()-Integer.parseInt(m.getAmount().toString()));
            moduleDetailsMapper.updateById(moduleDetails1);
            m.setId(null);
            m.setSubtotal(m.getAmount().multiply(m.getCostPrice()));
            sum=sum.add(m.getSubtotal());
        }

        designProcedureDetails.setModuleSubtotal(sum);
        designProcedureDetailsMapper.updateById(designProcedureDetails);
        return this.saveBatch(designProcedureModules);
    }

    @Override
    public List<DesignProcedureModule> WuLiaoGongXuByidAll(String Id) {
       return designProcedureModuleMapper.SelectByProcedureIdAll(Id);
    }

    @Override
    public List<DesignProcedureModule> selectWuLiaoByid(String Id) {
        if("".equals(Id)||Id==null){
            return new ArrayList<DesignProcedureModule>();
        }
        QueryWrapper<DesignProcedureModule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",Id);
        return this.list(queryWrapper);
    }

    @Override
    public List<DesignProcedureModule> SelectWLGXUpdateByidAll(String id) {
        List<ModuleDetails> moduleDetailsList = moduleDetailsMapper.selectByGongXuId(id);
        List<DesignProcedureModule> designProcedureModuleList = designProcedureModuleMapper.SelectByProcedureIdAll(id);
        for(int i=0;i<moduleDetailsList.size(); i++){
            Integer residualAmount = moduleDetailsList.get(i).getResidualAmount();
            designProcedureModuleList.get(i).setKeyong(new BigDecimal(residualAmount));
             BigDecimal amount = designProcedureModuleList.get(i).getAmount();
            designProcedureModuleList.get(i).setZuida(amount.add(new BigDecimal(residualAmount)));
        }
        return designProcedureModuleList;
    }

    @Override
    public boolean WLGXUupdate(List<DesignProcedureModule> List) {
        Integer parentId = List.get(0).getParentId();
        DesignProcedureDetails designProcedureDetails = designProcedureDetailsMapper.selectById(parentId);
        java.util.List<ModuleDetails> mDList = moduleDetailsMapper.selectByGongXuId(parentId + "");
        designProcedureDetails.setDesignModuleChangeTag("1");

        BigDecimal sum = new BigDecimal(0);
        for(int i=0;i<mDList.size(); i++){
             DesignProcedureModule dpm = List.get(i);
            ModuleDetails moduleDetails = mDList.get(i);
            moduleDetails.setResidualAmount(Integer.parseInt(List.get(i).getKeyong().toString()));
            int i1 = moduleDetailsMapper.updateById(moduleDetails);
            if(i1==0){
                return false;
            }
            dpm.setSubtotal(dpm.getAmount().multiply(dpm.getCostPrice()));
            sum=sum.add(dpm.getSubtotal());
             int dpmaddnum = designProcedureModuleMapper.updateById(dpm);
             if(dpmaddnum==0){
                 return false;
             }
        }
        designProcedureDetails.setModuleSubtotal(sum);
         int i = designProcedureDetailsMapper.updateById(designProcedureDetails);
        if(i==0){
            return false;
        }
        return true;
    }

    @Override
    public List<DesignProcedureModule> ChongxinUpdate(String id) {
        DesignProcedureDetails designProcedureDetails = designProcedureDetailsMapper.selectById(id);
        designProcedureDetails.setDesignModuleChangeTag("0");
        List<ModuleDetails> moduleDetailsList = moduleDetailsMapper.selectByGongXuId(id);
        List<DesignProcedureModule> designProcedureModuleList = designProcedureModuleMapper.SelectByProcedureIdAll(id);
        for(int i=0;i<moduleDetailsList.size(); i++){
            ModuleDetails moduleDetails = moduleDetailsList.get(i);
            DesignProcedureModule dpm = designProcedureModuleList.get(i);
            moduleDetails.setResidualAmount(moduleDetails.getResidualAmount()+ Integer.parseInt(dpm.getAmount().setScale( 0, BigDecimal.ROUND_DOWN ).toString()));
            dpm.setAmount(new BigDecimal(0));

            dpm.setKeyong(new BigDecimal(moduleDetails.getResidualAmount()));
            dpm.setZuida(new BigDecimal(moduleDetails.getResidualAmount()));
            moduleDetailsMapper.updateById(moduleDetails);
            designProcedureModuleMapper.updateById(dpm);
        }
        designProcedureDetails.setModuleSubtotal(new BigDecimal(0));
        designProcedureDetailsMapper.updateById(designProcedureDetails);
        return designProcedureModuleList;
    }


}
