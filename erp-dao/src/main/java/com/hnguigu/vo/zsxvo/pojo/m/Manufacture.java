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
import java.util.List;


/**
 * 	生产总表
 */
@Data
@TableName("m_manufacture")
public class Manufacture {
    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 派工单编号
     */
    @TableField(value = "manufacture_id")
    private String manufactureId;

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
     * 投产数量
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 合格数量
     */
    @TableField(value = "tested_amount")
    private BigDecimal testedAmount;

    /**
     * 合格数量
     */
    @TableField(value = "apply_id_group")
    private String applyIdGroup;

    /**
     * 产品描述
     */
    @TableField(value = "product_describe")
    private String productDescribe;

    /**
     * 设计物料总成本
     */
    @TableField(value = "module_cost_price_sum")
    private BigDecimal moduleCostPriceSum;

    /**
     * 实际物料总成本
     */
    @TableField(value = "real_module_cost_price_sum")
    private BigDecimal realModuleCostPriceSum;

    /**
     * 设计工时总成本
     */
    @TableField(value = "labour_cost_price_sum")
    private BigDecimal labourCostPriceSum;

    /**
     * 实际工时总成本
     */
    @TableField(value = "real_labour_cost_price_sum")
    private BigDecimal realLabourCostPriceSum;

    /**
     * 工单制定人
     */
    @TableField(value = "designer")
    private String designer;

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
     * 审核人
     */
    @TableField(value = "checker")
    private String checker;

    /**
     * 工单制定人
     */
    @TableField(value = "check_time")
    private Date checkTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 审核标志
     * s001-0: 等待审核
     * s001-1: 审核通过
     * s001-2: 审核不通过
     */
    @TableField(value = "check_tag")
    private String checkTag;

    /**
     * 生产过程标志
     * s002-0: 待登记
     * s002-1: 未审核
     * s002-2: 已完工
     */
    @TableField(value = "manufacture_procedure_tag")
    private String manufactureProcedureTag;


    @TableField(exist = false)
    private List<String>ids;

    @TableField(exist = false)
    private List<Procedure> procedureList;

}