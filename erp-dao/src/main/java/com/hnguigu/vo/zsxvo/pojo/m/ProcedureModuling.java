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
@TableName("m_procedure_moduling")
public class ProcedureModuling {
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
     * 设计物料成本小计
     */
    @TableField(value = "subtotal")
    private BigDecimal subtotal;





}
