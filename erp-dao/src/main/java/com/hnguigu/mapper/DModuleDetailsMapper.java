package com.hnguigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hnguigu.vo.DModuleDetails;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DModuleDetailsMapper extends BaseMapper<DModuleDetails> {
    /**
     * 物料组成设计添加的方法第三部-skl
     * @param
     * @param
     * @return
     */
    @Select("select * from d_module_details where PARENT_ID=#{parentId}")
    public List<DModuleDetails> getByparentId(int parentId);

}
