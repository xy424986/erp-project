package com.hnguigu.vo.zsxvo.pojo.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_Users")
/**
 * 用户表
 */
public class Users {

    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    @TableField("LOGIN_ID")
    private String loginId;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 状态
     */
    @TableField("STATUS")
    private String status;

    /**
     * 图片路径
     */
    @TableField("PHOTO_PATH")
    private String photoPath;

   }