package com.hnguigu.vo.zsxvo.pojo.m;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 	生产工序表
 */
@Data
@TableName("m_procedure")
public class Procedure {
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
     * 设计工时数
     */
    @TableField(value = "labour_hour_amount")
    private BigDecimal labourHourAmount;

    /**
     * 实际工时数
     */
    @TableField(value = "real_labour_hour_amount")
    private BigDecimal realLabourHourAmount;

    /**
     * 设计工时成本
     */
    @TableField(value = "subtotal")
    private BigDecimal subtotal;

    /**
     * 实际工时成本
     */
    @TableField(value = "real_subtotal")
    private BigDecimal realSubtotal;

    /**
     * 设计物料成本
     */
    @TableField(value = "module_subtotal")
    private BigDecimal moduleSubtotal;

    /**
     * 实际物料成本
     */
    @TableField(value = "real_module_subtotal")
    private BigDecimal realModuleSubtotal;

    /**
     * 单位工时成本
     */
    @TableField(value = "cost_price")
    private BigDecimal costPrice;

    /**
     * 工序投产数量
     */
    @TableField(value = "demand_amount")
    private BigDecimal demandAmount;

    /**
     * 工序合格数量
     */
    @TableField(value = "real_amount")
    private BigDecimal realAmount;

    /**
     * 工序完成标志
     * g004-0: 未开始
     * g004-1: 已完成
     * g004-2: 未完成
     * g004-3: 已审核
     */
    @TableField(value = "procedure_finish_tag")
    private String procedureFinishTag;

    /**
     * 工序交接标志
     * g005-0: 未交接
     * g005-1: 已交接
     * g005-2: 已审核
     */
    @TableField(value = "procedure_transfer_tag")
    private String procedureTransferTag;


}