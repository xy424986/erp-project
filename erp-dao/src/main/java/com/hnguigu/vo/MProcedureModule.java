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
 * 1、PARENT_ID和M_PROCEDURE的ID相对应，为外键
 * 2、DETAILS_NUMBER从1开始，每增加一个物料DETAILS_NUMBER递增1
 * 3,RENEW_AMOUNT是相关出库单中对应本工序的实际领料数量
 */
@Data
@TableName("m_procedure_module")
public class MProcedureModule  {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("PARENT_ID")
    private Integer parentId;/*父级序号*/

    @TableField("DETAILS_NUMBER")
    private Integer detailsNumber;/*工序物料序号*/

    @TableField("PRODUCT_ID")
    private String productId;/*产品编号*/

    @TableField("PRODUCT_NAME")
    private String productName;/*产品名称*/

    @TableField("COST_PRICE")
    private Double costPrice;/*物料单价*/

    @TableField("AMOUNT")
    private Integer amount;/*设计数量*/

    @TableField("RENEW_AMOUNT")
    private Integer renewAmount;/*已从库存领料数量*/

    @TableField("REAL_AMOUNT")
    private Integer realAmount;/*实际使用数量*/

    @TableField("SUBTOTAL")
    private Double subtotal;/*设计物料成本小计*/

    @TableField("REAL_SUBTOTAL")
    private Double realSubtotal;/*实际物料成本小计*/

    @TableField(exist = false)
    private Integer rowamount;//本次数量
}
