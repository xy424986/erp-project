package com.hnguigu.vo.zsxvo.pojo.m;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *  产品生产工序明细
 */
@Data
@TableName("m_design_procedure_details")
public class DesignProcedureDetails {

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
     * 工序序号
     */
    @TableField(value = "details_number")
    private Integer detailsNumber;

    /**
     * 工序编号
     */
    @TableField(value = "procedure_id")
    private String procedureId;

    /**
     * 工序名称
     */
    @TableField(value = "procedure_name")
    private String procedureName;

    /**
     * 工时数
     */
    @TableField(value = "labour_hour_amount")
    private BigDecimal labourHourAmount;


    /**
     * 工序描述
     */
    @TableField(value = "procedure_describe")
    private String procedureDescribe;

    /**
     * 单位
     */
    @TableField(value = "amount_unit")
    private String amountUnit;

    /**
     * 单位工时成本
     */
    @TableField(value = "cost_price")
    private BigDecimal costPrice;

    /**
     * 工时成本小计
     */
    @TableField(value = "subtotal")
    private BigDecimal subtotal;

    /**
     * 物料成本小计
     */
    @TableField(value = "module_subtotal")
    private BigDecimal moduleSubtotal;

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
     * 当前工序物料标志
     * d002-0: 未设计
     * d002-1: 已设计
     */
    @TableField(value = "design_module_tag")
    private String designModuleTag;

    /**
     * 当前工序物料变更标志
     * d003-0: 未变更
     * d003-0: 已变更
     */
    @TableField(value = "design_module_change_tag")
    private String designModuleChangeTag;

}