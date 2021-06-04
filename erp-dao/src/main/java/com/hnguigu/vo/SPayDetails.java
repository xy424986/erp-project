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
 * 1,PARENT_ID与STORE_PAY的ID相对应，为外键
 */
@Data
@TableName("s_pay_details")
public class SPayDetails {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("PARENT_ID")
    private Integer parentId;/*父级序号*/

    @TableField("PRODUCT_ID")
    private String productId;/*产品编号*/

    @TableField("PRODUCT_NAME")
    private String productName;/*产品名称*/

    @TableField("PRODUCT_DESCRIBE")
    private String productDescribe;/*描述*/

    @TableField("AMOUNT")
    private Integer amount;/*数量*/

    @TableField("AMOUNT_UNIT")
    private String amountUnit;/*单位*/

    @TableField("COST_PRICE")
    private Double costPrice;/*单价*/

    @TableField("SUBTOTAL")
    private Double subtotal;/*小计*/

    @TableField("PAID_AMOUNT")
    private Integer paidAmount;/*确认出库件数*/

    @TableField("PAY_TAG")
    private String payTag;/*出库标志
                            K002-1: 已登记
                            K002-2: 已调度*/



}
