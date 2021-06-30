package com.hnguigu.vo.zsxvo.pojo.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 基础代码表
 */
@Data
@TableName("sys_Codes")
public class Codes {

    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 父级序号
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 代码编号
     */
    @TableField("code_id")
    private String codeId;

    /**
     * 代码名称
     */
    @TableField("name")
    private String name;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 默认值
     */
    @TableField("defValue")
    private String defValue;

    /**
     * 说明
     */
    @TableField("descn")
    private String descn;

   }