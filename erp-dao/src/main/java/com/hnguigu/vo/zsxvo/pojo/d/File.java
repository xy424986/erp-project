package com.hnguigu.vo.zsxvo.pojo.d;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品档案
 */
@Data
@TableName("d_file")
public class File {

    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 产品编号
     */
    @TableField(value = "PRODUCT_ID")
    private String productId;

    /**
     * 产品名称
     */
    @TableField(value = "PRODUCT_NAME")
    private String productName;

    /**
     * 制造商
     */
    @TableField(value = "FACTORY_NAME")
    private String factoryName;

    /**
     * 产品I级分类编号
     */
    @TableField(value = "FIRST_KIND_ID")
    private String firstKindId;

    /**
     * 产品I级分类名称
     */
    @TableField(value = "FIRST_KIND_NAME")
    private String firstKindName;

    /**
     * 产品II级分类编号
     */
    @TableField(value = "SECOND_KIND_ID")
    private String secondKindId;

    /**
     * 产品II级分类名称
     */
    @TableField(value = "SECOND_KIND_NAME")
    private String secondKindName;

    /**
     * 产品III级分类编号
     */
    @TableField(value = "THIRD_KIND_ID")
    private String thirdKindId;

    /**
     * 产品III级分类名称
     */
    @TableField(value = "THIRD_KIND_NAME")
    private String thirdKindName;

    /**
     * 产品简称
     */
    @TableField(value = "PRODUCT_NICK")
    private String productNick;

    /**
     * 用途类型
     * Y001-1: 商品
     * Y001-2: 物料
     */
    @TableField(value = "TYPE")
    private String type;

    /**
     * 档次级别
     * D001-1: 高档
     * D001-2: 中档
     * D001-3: 低档
     */
    @TableField(value = "PRODUCT_CLASS")
    private String productClass;

    /**
     * 计量单位
     */
    @TableField(value = "PERSONAL_UNIT")
    private String personalUnit;

    /**
     * 计量值
     */
    @TableField(value = "PERSONAL_VALUE")
    private String personalValue;

    /**
     * 供应商集合
     */
    @TableField(value = "PROVIDER_GROUP")
    private String providerGroup;

    /**
     * 保修期
     */
    @TableField(value = "WARRANTY")
    private String warranty;

    /**
     * 替代品名称
     */
    @TableField(value = "TWIN_NAME")
    private String twinName;

    /**
     * 替代品编号
     */
    @TableField(value = "TWIN_ID")
    private String twinId;

    /**
     * 生命周期
     */
    @TableField(value = "LIFECYCLE")
    private String lifecycle;

    /**
     * 市场单价
     */
    @TableField(value = "LIST_PRICE")
    private BigDecimal listPrice;

    /**
     * 计划成本单价
     */
    @TableField(value = "COST_PRICE")
    private BigDecimal costPrice;

    /**
     * 成本单价
     */
    @TableField(value = "REAL_COST_PRICE")
    private BigDecimal realCostPrice;

    /**
     * 单位
     */
    @TableField(value = "AMOUNT_UNIT")
    private String amountUnit;

    /**
     * 产品描述
     */
    @TableField(value = "PRODUCT_DESCRIBE")
    private String productDescribe;

    /**
     * 产品经理
     */
    @TableField(value = "RESPONSIBLE_PERSON")
    private String responsiblePerson;

    /**
     * 登记人
     */
    @TableField(value = "REGISTER")
    private String register;

    /**
     * 建档时间
     */
    @TableField(value = "REGISTER_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registerTime;

    /**
     * 复核人
     */
    @TableField(value = "CHECKER")
    private String checker;

    /**
     * 复核时间
     */
    @TableField(value = "CHECK_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date checkTime;

    /*
     * 审核标志
     *  S001-0: 等待审核
     *  S001-1: 审核通过
     *  S001-2: 审核不通过
     */
    @TableField(value = "CHECK_TAG")
    private String checkTag;

    /**
     * 变更人
     */
    @TableField(value = "CHANGER")
    private String changer;

    /**
     * 变更时间
     */
    @TableField(value = "CHANGE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date changeTime;

    /**
     * 档案变更标志
     *  D002-0: 未变更
     *  D002-1: 已变更
     */
    @TableField(value = "CHANGE_TAG")
    private String changeTag;

    /**
     *价格变更标志
     * J001-0：未变更
     * J001-1：已变更
     */
    @TableField(value = "PRICE_CHANGE_TAG")
    private String priceChangeTag;

    /**
     * 档案变更累计
     */
    @TableField(value = "FILE_CHANGE_AMOUNT")
    private Integer fileChangeAmount;

    /**
     *  产品删除标志
     *      C001-0: 未删除
     *      C001-1: 已删除
     */
    @TableField(value = "DELETE_TAG")
    private String deleteTag;

    /**
     * 物料组成标志
     *   W001-0: 未设计
     *   W001-1: 已设计
     */
    @TableField(value = "DESIGN_MODULE_TAG")
    private String designModuleTag;

    /**
     * 工序组成标志
     *  G001-0: 未设计
     *  G001-1: 已设计
     */
    @TableField(value = "DESIGN_PROCEDURE_TAG")
    private String designProcedureTag;

    /**
     *库存分配标志
     * K001-0: 未设计
     * K001-1: 已设计
     */
    @TableField(value = "DESIGN_CELL_TAG")
    private String designCellTag;

   }