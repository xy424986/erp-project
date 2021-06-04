package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("sys_users")
public class SysUsers  {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("LOGIN_ID")
    private String loginId;/*用户名称*/

    @TableField("PASSWORD")
    private String password;/*密码*/

    @TableField("STATUS")
    private String status;/*状态*/

    @TableField("PHOTO_PATH")
    private String photoPath;/*图片路径*/

}
