package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.MProceduring;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MProceduringMapper extends BaseMapper<MProceduring> {

    @Select("select * from m_proceduring where PARENT_ID=#{parentid}")
        List<MProceduring> selectparentid(int parentid);
}
