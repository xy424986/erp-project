package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hnguigu.vo.DFile;
import com.hnguigu.vo.SCell;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SCellMapper extends BaseMapper<SCell> {
    @Select("select * from `d_file` df\n" +
            "left join s_cell sc on df.PRODUCT_ID = sc.PRODUCT_ID\n" +
            "where df.`CHECK_TAG`=1 and sc.check_tag=#{tag}")
    public List<DFile> queryAllSCll(int tag);
}
