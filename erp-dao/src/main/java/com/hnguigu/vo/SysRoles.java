package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("sys_roles")
public class SysRoles  {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("NAME")
    private String name;/*角色名称*/

    @TableField("CODE")
    private String code;/*角色编号*/

    @TableField("DESCN")
    private String descn;/*角色说明*/



}
