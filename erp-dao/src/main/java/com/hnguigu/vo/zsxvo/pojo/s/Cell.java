package com.hnguigu.vo.zsxvo.pojo.s;

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
 *  库存单元
 */
@Data
@TableName("s_cell")
public class Cell {

    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 库存编号
     */
    @TableField(value = "store_id")
    private String storeId;

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
     * 产品I级分类编号
     */
    @TableField(value = "first_kind_id")
    private String firstKindId;

    /**
     * 产品I级分类名称
     */
    @TableField(value = "first_kind_name")
    private String firstKindName;

    /**
     * 产品II级分类编号
     */
    @TableField(value = "second_kind_id")
    private String secondKindId;

    /**
     * 产品II级分类名称
     */
    @TableField(value = "second_kind_name")
    private String secondKindName;

    /**
     * 产品III级分类编号
     */
    @TableField(value = "third_kind_id")
    private String thirdKindId;

    /**
     * 产品III级分类名称
     */
    @TableField(value = "third_kind_name")
    private String thirdKindName;

    /**
     * 库存报警下限数
     */
    @TableField(value = "min_amount")
    private BigDecimal minAmount;

    /**
     * 库存报警上限数
     */
    @TableField(value = "max_amount")
    private BigDecimal maxAmount;

    /**
     * 最大存储量
     */
    @TableField(value = "max_capacity_amount")
    private BigDecimal maxCapacityAmount;

    /**
     * 当前存储量
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 配置要求
     */
    @TableField(value = "config")
    private String config;

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
     * 复核时间
     */
    @TableField(value = "check_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date checkTime;

    /**
     * 审核标志
     */
    @TableField(value = "check_tag")
    private String checkTag;


}