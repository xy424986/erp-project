package com.hnguigu.service.zsxservice.impl.d;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hnguigu.mapper.d.ModuleDetailsMapper;
import com.hnguigu.mapper.m.DesignProcedureDetailsMapper;
import com.hnguigu.mapper.m.DesignProcedureModuleMapper;
import com.hnguigu.vo.zsxvo.pojo.d.ModuleDetails;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedureDetails;
import com.hnguigu.vo.zsxvo.pojo.m.DesignProcedureModule;
import com.hnguigu.service.zsxservice.d.ModuleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ModuleDetailsServiceImpl  extends ServiceImpl<ModuleDetailsMapper, ModuleDetails> implements ModuleDetailsService {

    @Autowired
    ModuleDetailsMapper moduleDetailsMapper;

    @Autowired
    DesignProcedureModuleMapper designProcedureModuleMapper;

    @Autowired
    DesignProcedureDetailsMapper designProcedureDetailsMapper;

    @Override
    public List<ModuleDetails> SelectByProcedureIdAll(String procedureId) {
        return moduleDetailsMapper.SelectByProcedureIdAll(procedureId);
    }

    @Override
    public List<ModuleDetails> selectByGongXuId(String procedureId) {
        return moduleDetailsMapper.selectByGongXuId(procedureId);
    }

    @Override
    public List<ModuleDetails> ChongXin(String Id){
         DesignProcedureDetails designProcedureDetails = designProcedureDetailsMapper.selectById(Id);
        designProcedureDetails.setDesignModuleTag("0");
        designProcedureDetails.setModuleSubtotal(new BigDecimal(0));
        designProcedureDetailsMapper.updateById(designProcedureDetails);

        List<DesignProcedureModule> designProcedureModules = designProcedureModuleMapper.SelectByProcedureIdAll(Id);
         List<ModuleDetails> moduleDetailsList = moduleDetailsMapper.selectByGongXuId(Id);
         for(ModuleDetails moduleDetails:moduleDetailsList){
             for(DesignProcedureModule designProcedureModule:designProcedureModules){
                if (moduleDetails.getProductId().equals(designProcedureModule.getProductId())){
                    moduleDetails.setResidualAmount(moduleDetails.getResidualAmount()+designProcedureModule.getAmount().intValue());
                    designProcedureModuleMapper.deleteById(designProcedureModule.getId());
                    moduleDetailsMapper.updateById(moduleDetails);
                }
             }
         }
         return moduleDetailsList;
    }

}
