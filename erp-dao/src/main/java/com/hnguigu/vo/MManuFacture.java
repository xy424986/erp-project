package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
 * 注：
 * 1、APPLY_ID_GROUP包括本派工单对应的所有工作计划编号，其中使用“|”进行分隔
 * 2、MODULE_COST_PRICE_SUM为本派工单包含所有产品对应的物料成本和
 * REAL_LABOUR_COST_PRICE_SUM为本派工单包含所有产品对应的工时成本和
 */
@Data
@TableName("m_manufacture")
public class MManuFacture {
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("MANUFACTURE_ID")
    private String manufactureId;/*派工单编号*/

    @TableField("PRODUCT_ID")
    private String productId;/*产品编号*/

    @TableField("PRODUCT_NAME")
    private String productName;/*产品名称*/

    @TableField("AMOUNT")
    private Integer amount;/*投产数量*/

    @TableField("TESTED_AMOUNT")
    private Integer testedAmount;/*合格数量*/

    @TableField("APPLY_ID_GROUP")
    private String applyIdGroup;/*生产计划序号组*/

    @TableField("PRODUCT_DESCRIBE")
    private String productDescribe;/*产品描述*/

    @TableField("MODULE_COST_PRICE_SUM")
    private Double moduleCostPriceSun;/*设计物料总成本*/

    @TableField("REAL_MODULE_COST_PRICE_SUM")
    private Double pealModuleCostPriceSun;/*实际物料总成本*/

    @TableField("LABOUR_COST_PRICE_SUM")
    private Double labourCostPriceSun;/*设计工时总成本*/

    @TableField("REAL_LABOUR_COST_PRICE_SUM")
    private Double peallabourCostPriceSun;/*实际工时总成本*/

    @TableField("DESIGNER")
    private String designer;/*工单制定人*/

    @TableField("REGISTER")
    private String register;/*登记人*/

    @TableField("REGISTER_TIME")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date registerTime;/*登记时间*/

    @TableField("CHECKER")
    private String shecker;/*审核人*/

    @TableField("CHECK_TIME")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date checkTime;/*审核时间*/

    @TableField("REMARK")
    private String remark;/*备注*/

    @TableField("CHECK_TAG")
    private String checkTag;/*审核标志
                                S001-0: 等待审核
                                S001-1: 审核通过
                                S001-2: 审核不通过*/

    @TableField("MANUFACTURE_PROCEDURE_TAG")
    private String manufactureProcedureTag;/*生产过程标志
                                                S002-0: 待登记
                                                S002-1: 未审核
                                                S002-2: 已完工*/

}
