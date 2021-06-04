package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 注：
 * 1、PARENT_ID与M_DESIGN_PROCEDURE_DETAILS的ID相对应，为外键
 * 2、对每一个产品工序的物料组成而言，第一个物料的DETAILS_NUMBER从1开始，每增加一个物料DETAILS_NUMBER递增1
 * 3,SUBTOTAL= AMOUNT*COST_PRICE
 */
@Data
@TableName("m_design_procedure_module")
public class MDesignProcedureModule  {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("PARENT_ID")
    private Integer parentId;/*父级序号*/

    @TableField("DETAILS_NUMBER")
    private Integer detailsNumber;/*工序物料序号*/

    @TableField("PRODUCT_ID")
    private String productId;/*物料编号*/

    @TableField("PRODUCT_NAME")
    private String productName;/*物料名称*/

    @TableField("TYPE")
    private String type;/*用途类型*/

    @TableField("AMOUNT")
    private Integer amount;/*本工序数量*/

    @TableField("PRODUCT_DESCRIBE")
    private String productDescribe;/*描述*/

    @TableField("AMOUNT_UNIT")
    private String amountUnit;/*单位*/

    @TableField("COST_PRICE")
    private Double costPrice;/*单价*/

    @TableField("SUBTOTAL")
    private Double subtotal;/*小计*/



}
