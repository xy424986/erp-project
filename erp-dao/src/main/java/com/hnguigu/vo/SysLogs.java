package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("sys_logs")
public class SysLogs {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("LOGIN_ID")
    private String loginId;/*用户名称*/

    @TableField("PRIORITY")
    private String priority;/*级别*/

    @TableField("LOG_DATE")
    private Date logDate;/*时间*/

    @TableField("CLASS")
    private String sysclasss;/*类名*/

    @TableField("METHOD")
    private String method;/*方法名*/

    @TableField("MSG")
    private String msg;/*信息*/




}
