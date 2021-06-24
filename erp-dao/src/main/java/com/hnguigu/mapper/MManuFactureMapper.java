package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.MManuFacture;
import com.hnguigu.vo.extend.MManuFactureEx;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MManuFactureMapper extends BaseMapper<MManuFacture> {

    @Select("select * from `m_procedure` mpr \n" +
            "left join `m_manufacture` mma on mpr.parent_id=mma.id \n" +
            "where mma.id=#{id}")
    MManuFactureEx queryByIdMManuFactureEx(@Param("id") int id);

    @Select("select * from   `m_procedure` mpr \n" +
            "left join `m_manufacture` mma on mpr.parent_id=mma.id \n" +
            "where mma.id=#{id1}")
    List<MManuFactureEx> queryByIdMManuFactureEx1(@Param("id1") int id);

}
