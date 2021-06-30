package com.hnguigu.vo.zsxvo.pojo.s;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;


/**
 *	出库明细
 */
@Data
@TableName("s_pay_details")
public class PayDetails {
    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 父级序号
     */
    @TableField(value = "parent_id")
    private Integer parentId;

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
     * 描述
     */
    @TableField(value = "product_describe")
    private String productDescribe;

    /**
     * 数量
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 单位
     */
    @TableField(value = "amount_unit")
    private String amountUnit;

    /**
     * 单价
     */
    @TableField(value = "cost_price")
    private BigDecimal costPrice;

    /**
     * 小计
     */
    @TableField(value = "subtotal")
    private BigDecimal subtotal;

    /**
     * 确认出库件数
     */
    @TableField(value = "paid_amount")
    private BigDecimal paidAmount;

    /**
     * 出库标志
     * k002-1: 已登记
     * k002-2: 已调度
     */
    @TableField(value = "pay_tag")
    private String payTag;

   }