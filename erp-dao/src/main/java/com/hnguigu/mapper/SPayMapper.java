package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.SPay;
import com.hnguigu.vo.extend.SPayEX;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SPayMapper extends BaseMapper<SPay> {
    @Select("\n" +
            "select * from `s_pay_details` spd\n" +
            "left join `s_pay` sp  on sp.ID = spd.PARENT_ID\n" +
            "left join s_cell sc on spd.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "left join `d_file` df on df.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where spd.`ID`=#{id}\n" +
            "and sc.check_tag='S001-1'\n" +
            "and sp.check_tag='S001-1'\n" +
            "and sp.PAY_TAG='K002-1'\n" +
            "and spd.PAY_TAG='K002-1' ")
    SPayEX queryByIdSPayEX(@Param("id") int id);
}
