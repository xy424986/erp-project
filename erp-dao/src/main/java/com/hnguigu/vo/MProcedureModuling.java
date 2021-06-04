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
 * 1、PARENT_ID和M_PROCEDURING的ID相对应，为外键
 * 2,SUBTOTAL= AMOUNT* COST_PRICE
 */
@Data
@TableName("m_procedure_moduling")
public class MProcedureModuling  {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("PARENT_ID")
    private Integer parentId;/*父级序号*/

    @TableField("DETAILS_NUMBER")
    private Integer detailsNumber;/*本工序物料序号*/

    @TableField("PRODUCT_ID")
    private String productId;/*产品编号*/

    @TableField("PRODUCT_NAME")
    private String productName;/*产品名称*/

    @TableField("COST_PRICE")
    private Double costPrice;/*单位物料成本*/

    @TableField("AMOUNT")
    private Integer amount;/*本次使用数量*/

    @TableField("SUBTOTAL")
    private Double subtotal;/*物料成本小计*/



}
