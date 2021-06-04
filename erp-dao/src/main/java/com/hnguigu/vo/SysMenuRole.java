package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("sys_menu_role")
public class SysMenuRole {


    @TableField("MENU_ID")
    private Integer menuId;/*菜单编号*/

    @TableField("ROLE_ID")
    private Integer roleId;/*角色编号*/



}
