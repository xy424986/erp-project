package com.hnguigu.vo.zsxvo.pojo.s;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 	出库
 */
@Data
@TableName("s_pay")
public class Pay {
    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 出库单编号
     */
    @TableField(value = "pay_id")
    private String payId;

    /**
     * 出库人
     */
    @TableField(value = "storer")
    private String storer;

    /**
     * 出库理由
     * c002-1: 生产领料
     * c002-2: 赠送
     * c002-3: 内部借领
     * c002-4: 其他借领
     */
    @TableField(value = "reason")
    private String reason;

    /**
     * 出库详细理由
     */
    @TableField(value = "reasonexact")
    private String reasonexact;

    /**
     * 总件数
     */
    @TableField(value = "amount_sum")
    private BigDecimal amountSum;

    /**
     * 总金额
     */
    @TableField(value = "cost_price_sum")
    private BigDecimal costPriceSum;

    /**
     * 确认出库总件数
     */
    @TableField(value = "paid_amount_sum")
    private BigDecimal paidAmountSum;

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
     * 调度人
     */
    @TableField(value = "attemper")
    private String attemper;

    /**
     * 调度时间
     */
    @TableField(value = "attemper_time")
    private Date attemperTime;

    /**
     * 库存标志
     * k002-1: 已登记
     * k002-2: 已调度
     */
    @TableField(value = "pay_tag")
    private String payTag;

  }