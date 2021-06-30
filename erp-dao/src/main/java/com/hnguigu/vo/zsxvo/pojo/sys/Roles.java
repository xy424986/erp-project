package com.hnguigu.vo.zsxvo.pojo.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_roles")
/**
 *  角色信息表
 */
public class Roles {

    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    @TableField("name")
    private String name;

    /**
     * 角色编号
     */
    @TableField("code")
    private String code;

    /**
     * 是否可用
     */
    @TableField("descn")
    private String descn;


}