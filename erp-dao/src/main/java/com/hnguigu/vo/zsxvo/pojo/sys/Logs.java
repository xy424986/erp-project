package com.hnguigu.vo.zsxvo.pojo.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 日志信息
 */
@Data
@TableName("sys_Logs")
public class Logs {
    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    @TableField("login_id")
    private String loginId;

     /**
     * 级别
     */
    @TableField("priority")
    private String priority;

    /**
     * 时间
     */
    @TableField("log_date")
    private Date logDate;

    /**
     * 类名
     */
    @TableField("type")
    private String type;

    /**
     * 方法名
     */
    @TableField("method")
    private String method;

    /**
     * 信息
     */
    @TableField("msg")
    private String msg;


}