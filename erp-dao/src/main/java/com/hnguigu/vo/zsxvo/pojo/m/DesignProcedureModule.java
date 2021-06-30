package com.hnguigu.vo.zsxvo.pojo.m;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 *   产品生产工序物料明细
 */
@Data
@TableName("m_design_procedure_module")
public class DesignProcedureModule {
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
     * 工序物料序号
     */
    @TableField(value = "details_number")
    private Integer detailsNumber;

    /**
     * 物料编号
     */
    @TableField(value = "product_id")
    private String productId;

    /**
     * 物料名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 用途类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 本工序数量
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 描述
     */
    @TableField(value = "product_describe")
    private String productDescribe;

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
     * 可用
     */
    @TableField(exist = false)
    private BigDecimal keyong;

    /**
     * 可用
     */
    @TableField(exist = false)
    private BigDecimal zuida;

}