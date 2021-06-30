package com.hnguigu.vo.zsxvo.pojo.m;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品档案
 */
@Data
@TableName("m_apply")
public class Apply {
    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 生产计划编号
     */
    @TableField(value = "apply_id")
    private String applyId;

    /**
     * 产品编号
     */
    @TableField(value = "product_id")
    private String productId;

    /**
     * 产品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 产品描述
     */
    @TableField(value = "product_describe")
    private String productDescribe;

    /**
     * 用途类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 数量
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 设计人
     */
    @TableField(value = "designer")
    private String designer;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 登记人
     */
    @TableField(value = "register")
    private String register;

    /**
     * 登记时间
     */
    @TableField(value = "register_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registerTime;

    /**
     * 复核人
     */
    @TableField(value = "checker")
    private String checker;

    /**
     * 审核意见
     */
    @TableField(value = "check_suggestion")
    private String checkSuggestion;

    /**
     * 审核时间
     */
    @TableField(value = "check_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date checkTime;

    /**
     * 审核标志
     * s001-0: 等待审核
     * s001-1: 审核通过
     * s001-2: 审核不通过
     */
    @TableField(value = "check_tag")
    private String checkTag;

    /**
     * 派工标志
     * p001-0: 未派工
     * p001-1: 已派工
     */
    @TableField(value = "manufacture_tag")
    private String manufactureTag;


}