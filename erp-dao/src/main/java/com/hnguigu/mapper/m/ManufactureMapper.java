package com.hnguigu.mapper.m;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.zsxvo.pojo.m.Manufacture;
import org.apache.ibatis.annotations.Select;

public interface ManufactureMapper extends BaseMapper<Manufacture> {

  @Select("SELECT MAX(manufacture_id)   FROM `m_manufacture` WHERE TO_DAYS(register_time) = TO_DAYS(NOW()) ")
  String ShowManufactureId();

  @Select("select * from `m_manufacture` mf inner join\n" +
          "`m_procedure` mp on mf.`ID`=mp.`PARENT_ID`\n" +
          "where mp.`ID`=#{ProcedureId}")
  Manufacture ShowByProcedureId(int ProcedureId);
}