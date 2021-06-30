package com.hnguigu.mapper.d;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.zsxvo.pojo.d.ModuleDetails;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ModuleDetailsMapper extends BaseMapper<ModuleDetails> {
    @Select("select md.* from 'd_module_details' md left join 'd_module' m on md.'product_id'=m.'id' left join 'd_file' f on f.'product_id'=m.'product_id' where f.'product_id'=#{productId} ")
    List<ModuleDetails> selectByProductId(String productId);


    @Select("SELECT dmd.* FROM `m_design_procedure_details` mdpd \n" +
            "INNER JOIN `m_design_procedure` mdp ON mdpd.`PARENT_ID`=mdp.`ID`\n" +
            "INNER JOIN `d_module` dm ON mdp.`PRODUCT_ID`=dm.`PRODUCT_ID`\n" +
            "INNER JOIN `d_module_details` dmd ON dm.`ID`=dmd.`PARENT_ID`\n" +
            "WHERE mdpd.id=#{Id}")
    List<ModuleDetails> selectByGongXuId(String Id);


    @Select("SELECT dmd.* FROM `d_module` dm \n" +
            "INNER JOIN `d_module_details` dmd ON dm.`ID`=dmd.`PARENT_ID`\n" +
            "WHERE dm.product_id=#{Id}")
    List<ModuleDetails> SelectByProcedureIdAll(String Id);

}