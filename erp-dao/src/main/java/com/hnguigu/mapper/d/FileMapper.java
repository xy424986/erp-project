package com.hnguigu.mapper.d;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import com.hnguigu.vo.zsxvo.pojo.d.File;
import java.util.List;

public interface FileMapper extends BaseMapper<File> {

    @Select("SELECT MAX(d_file.`PRODUCT_ID`)   FROM d_file WHERE TO_DAYS(register_time) = TO_DAYS(NOW()) ")
    String showProductId();

    @Select("select  df.* from `d_file` df \n" +
            "where df.check_tag=1 and df.delete_tag=0 and df.design_module_tag=1 and df.design_procedure_tag=0 \n" +
            "and df.`PRODUCT_ID` not in(select distinct PRODUCT_ID from m_design_procedure)")
    List<File> Shengchangshow();

    @Select("SELECT * FROM `d_file` WHERE `PRODUCT_ID` = #{productId}")
    File selectProductId(String productId);
}