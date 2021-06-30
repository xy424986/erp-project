package com.hnguigu.vo.zsxvo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class QueryCondition {

    /**
     * 一级菜单选中的名称
     */
    private String firskindname;

    /**
     * 二级菜单选中的名称
     */
    private String secondkindname;

    /**
     * 三级菜单选中的名称
     */
    private String thirdkindname;


    /**
     * 建档开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date starttime;

    /**
     * 建档结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date overtime;

    /**
     * 模糊查询的名字
     */
    private String tjname;
}
