package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("d_config_file_kind")
public class DConfigFileKind  {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;//序号

    @TableField("P_ID")
    private Integer pId;//父级序号

    @TableField("KIND_ID")
    private String kindId;//分类编号

    @TableField("KIND_NAME")
    private String kindName;//分类名称

    @TableField("KIND_LEVEL")
    private Integer kindLevel;//级别

}
