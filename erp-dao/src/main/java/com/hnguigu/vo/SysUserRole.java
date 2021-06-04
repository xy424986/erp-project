package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("sys_user_role")
public class SysUserRole  {


    @TableField("USER_ID")
    private Integer userId;/*用户编号*/

    @TableField("ROLE_ID")
    private Integer roleId;/*角色编号*/



}
