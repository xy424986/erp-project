package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 注：
 * 1、COST_PRICE_SUM等于本产品所有构成物料成本之和
 */
@Data
@TableName("d_module")
public class DModule  {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("DESIGN_ID")
    private String designId;/*设计编号*/

    @TableField("PRODUCT_ID")
    private String productId;/*产品编号*/

    @TableField("PRODUCT_NAME")
    private String productName;/*产品名称*/

    @TableField("FIRST_KIND_ID")
    private String firstKindId;/*产品I级分类编号*/

    @TableField("FIRST_KIND_NAME")
    private String firstKindName;/*产品I级分类名称*/

    @TableField("SECOND_KIND_ID")
    private String secondKindId;/*产品II级分类编号*/

    @TableField("SECOND_KIND_NAME")
    private String secondKindName;/*产品II级分类名称*/

    @TableField("THIRD_KIND_ID")
    private String thirdKindId;/*产品III级分类编号*/

    @TableField("THIRD_KIND_NAME")
    private String thirdKindName;/*产品III级分类名称*/

    @TableField("DESIGNER")
    private String designer;/*设计人*/

    @TableField("MODULE_DESCRIBE")
    private String moduleDescribe;/*设计要求*/

    @TableField("COST_PRICE_SUM")
    private Double costPriceSum;/*物料总成本*/

    @TableField("REGISTER")
    private String register;/*登记人*/

    @TableField("REGISTER_TIME")
    private Date registerTime;/*登记时间*/

    @TableField("CHECKER")
    private String checker;/*复核人*/

    @TableField("CHECK_TIME")
    private Date checkTime;/*复核时间*/

    @TableField("CHANGER")
    private String changer;/*变更人*/

    @TableField("CHANGE_TIME")
    private Date changeTime;/*变更时间*/

    @TableField("CHECK_TAG")
    private String checkTag;/*审核标志
                            S001-0: 等待审核
                            S001-1: 审核通过
                            S001-2: 审核不通过*/

    @TableField("CHANGE_TAG")
    private String changeTag;/*变更标志
                                B002-0: 未变更
                                B002-1: 已变更*/

    @TableField(exist = false)
    private String designModuleTag;/*物料组成标志,W001-0: 未设计,W001-1: 已设计*/

}
