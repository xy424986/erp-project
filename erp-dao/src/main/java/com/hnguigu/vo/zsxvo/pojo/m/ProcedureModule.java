package com.hnguigu.vo.zsxvo.pojo.m;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 *  生产工序物料表
 */
@Data
@TableName("m_procedure_module")
public class ProcedureModule {
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
     * 物料单价
     */
    @TableField(value = "cost_price")
    private BigDecimal costPrice;

    /**
     * 设计数量
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 已从库存领料数量
     */
    @TableField(value = "renew_amount")
    private BigDecimal renewAmount;

    /**
     * 实际使用数量
     */
    @TableField(value = "real_amount")
    private BigDecimal realAmount;

    /**
     * 设计物料成本小计
     */
    @TableField(value = "subtotal")
    private BigDecimal subtotal;

    /**
     * 实际物料成本小计
     */
    @TableField(value = "real_subtotal")
    private BigDecimal realSubtotal;

    @TableField(exist = false)
    private String shr;

    @TableField(exist = false)
    private boolean iswancheng;

    @TableField(exist = false)
    private BigDecimal gss;

    @TableField(exist = false)
    private BigDecimal sl;
}