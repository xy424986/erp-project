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
 * 1,ID为自增长序列，主键
 */
@Data
@TableName("m_apply")
public class MApply{


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("APPLY_ID")
    private String applyId;/*生产计划编号*/

    @TableField("PRODUCT_ID")
    private String productId;/*产品编号*/

    @TableField("PRODUCT_NAME")
    private String productName;/*产品名称*/

    @TableField("PRODUCT_DESCRIBE")
    private String productDescribe;/*产品描述*/

    @TableField("TYPE")
    private String type;/*用途类型*/

    @TableField("AMOUNT")
    private Integer amount;/*数量*/

    @TableField("DESIGNER")
    private String designer;/*设计人*/

    @TableField("REMARK")
    private String remark;/*备注*/

    @TableField("REGISTER")
    private String register;/*登记人*/

    @TableField("REGISTER_TIME")
    private Date registerTime;/*登记时间*/

    @TableField("CHECKER")
    private String checker;/*复核人*/

    @TableField("CHECK_SUGGESTION")
    private String checkSuggestion;/*审核意见*/

    @TableField("CHECK_TIME")
    private Date checkTime;/*审核时间*/

    @TableField("CHECK_TAG")
    private String checkTag;/*审核标志
                                S001-0: 等待审核
                                S001-1: 审核通过
                                S001-2: 审核不通过*/

    @TableField("MANUFACTURE_TAG")
    private String manufactureTag;/*派工标志
                                    P001-0: 未派工
                                    P001-1: 已派工*/



}
