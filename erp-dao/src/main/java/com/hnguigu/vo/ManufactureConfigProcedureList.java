package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("manufacture_config_procedure_list")
public class ManufactureConfigProcedureList{


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("KIND")
    private String kind;

    @TableField("TYPE_ID")
    private String typeId;

    @TableField("TYPE_NAME")
    private String typeName;

    @TableField("DESCRIBE1")
    private String describe1;

    @TableField("DESCRIBE2")
    private String describe2;

    @TableField("REGISTER")
    private String register;

    @TableField("REGISTER_ID")
    private String registerId;



}
