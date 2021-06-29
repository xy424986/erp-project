package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SCell;
import com.hnguigu.vo.extend.SCellEx;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SCellMapper extends BaseMapper<SCell> {
    @Select("select * from `d_file` df\n" +
            "left join s_cell sc on df.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where df.`CHECK_TAG`='S001-1' and df.DESIGN_CELL_TAG='K001-1' and sc.check_tag=#{tag} or sc.check_tag=#{tag2}")
     List<SCellEx> queryAllSCll(@Param("tag")String tag, @Param("tag2")String tag2);
    //
/*    @Select("select * from `d_file` df\n" +
            "left join s_cell sc on df.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where df.`CHECK_TAG`='S001-1' #{tag13} #{tag14} and sc.check_tag=#{tag1} or sc.check_tag=#{tag12} ")
    List<SCellEx> queryAllSCll2(@Param("tag1")String tag,@Param("tag12")String tag2,@Param("tag13")String tag3,@Param("tag14")String tag4);
   */
    @Select("select * from `d_file` df\n" +
            "left join s_cell sc on df.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where df.`CHECK_TAG`='S001-1'  and sc.check_tag=#{tag1} or sc.check_tag=#{tag12}\n"+
            "and df.DESIGN_CELL_TAG='K001-1'")
    List<SCellEx> queryAllSCll2(@Param("tag1")String tag,@Param("tag12")String tag2);


}
