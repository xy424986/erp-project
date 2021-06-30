package com.hnguigu.vo.zsxvo.pojo.m;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 产品生产工序
 */
@Data
@TableName("m_design_procedure")
public class DesignProcedure {

    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 设计编号
     */
    @TableField(value = "design_id")
    private String designId;

    /**
     * 产品I级分类编号
     */
    @TableField(value = "first_kind_id")
    private String firstKindId;

    /**
     * 产品I级分类名称
     */
    @TableField(value = "first_kind_name")
    private String firstKindName;

    /**
     * 产品II级分类编号
     */
    @TableField(value = "second_kind_id")
    private String secondKindId;

    /**
     * 产品II级分类名称
     */
    @TableField(value = "second_kind_name")
    private String secondKindName;

    /**
     * 产品III级分类编号
     */
    @TableField(value = "third_kind_id")
    private String thirdKindId;

    /**
     * 产品III级分类名称
     */
    @TableField(value = "third_kind_name")
    private String thirdKindName;

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
     * 设计要求
     */
    @TableField(value = "procedure_describe")
    private String procedureDescribe;

    /**
     * 工时总成本
     */
    @TableField(value = "cost_price_sum")
    private BigDecimal costPriceSum;

    /**
     * 物料总成本
     */
    @TableField(value = "module_cost_price_sum")
    private BigDecimal moduleCostPriceSum;

    /**
     * 设计人
     */
    @TableField(value = "designer")
    private String designer;

    /**
     * 登记人
     */
    @TableField(value = "register")
    private String register;

    /**
     * 登记时间
     */
    @TableField(value = "register_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registerTime;

    /**
     * 复核人
     */
    @TableField(value = "checker")
    private String checker;

    /**
     * 审核时间
     */
    @TableField(value = "check_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date checkTime;

    /**
     * 审核意见
     */
    @TableField(value = "check_suggestion")
    private String checkSuggestion;

    /**
     * 审核标志
     * s001-0: 等待审核
     * s001-1: 审核通过
     * s001-2: 审核不通过
     */
    @TableField(value = "check_tag")
    private String checkTag;

    /**
     * 变更人
     */
    @TableField(value = "changer")
    private String changer;

    /**
     * 变更时间
     */
    @TableField(value = "change_time")
    private Date changeTime;

    /**
     * 变更标志
     * b002-0: 未变更
     * b002-1: 已变更
     */
    @TableField(value = "change_tag")
    private String changeTag;

    /**
     * 工序物料设计标志
     * g002-0: 未设计
     * g002-1: 已提交
     * g002-2: 已审核
     */
    @TableField(value = "design_module_tag")
    private String designModuleTag;

    /**
     * 工序物料变更标志
     * g003-0: 未变更
     * g003-1: 已变更
     */
    @TableField(value = "design_module_change_tag")
    private String designModuleChangeTag;


    /**
     * 子菜单集合
     */
    @TableField(exist = false)
    List<DesignProcedureDetails> detailsList;


}