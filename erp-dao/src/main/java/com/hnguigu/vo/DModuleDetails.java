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
 * 1、PARENT_ID与DESIGN_MODULE的ID相对应，为外键
 * 2、对每一个产品的物料组成而言，第一个物料的DETAILS_NUMBER从1开始，每增加一个物料DETAILS_NUMBER递增1
 * 3、RESIDUAL_AMOUNT为当前物料在产品工序物料设计过程中还未使用的数量
 * 4,SUBTOTAL= COST_PRICE*AMOUNT
 */
@Data
@TableName("d_module_details")
public class DModuleDetails {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("PARENT_ID")
    private Integer parentId;/*父级序号*/

    @TableField("DETAILS_NUMBER")
    private Integer detailsNumber;/*物料序号*/

    @TableField("PRODUCT_ID")
    private String productId;/*物料编号*/

    @TableField("PRODUCT_NAME")
    private String productName;/*物料名称*/

    @TableField("TYPE")
    private String type;/*用途类型*/

    @TableField("PRODUCT_DESCRIBE")
    private String productDescribe;/*描述*/

    @TableField("AMOUNT_UNIT")
    private String amountUnit;/*单位*/

    @TableField("AMOUNT")
    private Integer amount;/*数量*/

    @TableField("RESIDUAL_AMOUNT")
    private Integer residualAmount;/*可用数量*/

    @TableField("COST_PRICE")
    private Double costPrice;/*单价*/

    @TableField("SUBTOTAL")
    private Double subtotal;/*小计*/



}
