package com.hnguigu.vo.zsxvo.pojo.m;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *  	生产工序过程记录
 */
@Data
@TableName("m_proceduring")
public class Proceduring {
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
     * 工序序号
     */
    @TableField(value = "details_number")
    private Integer detailsNumber;

    /**
     * 工序编号
     */
    @TableField(value = "procedure_id")
    private String procedureId;

    /**
     * 工序名称
     */
    @TableField(value = "procedure_name")
    private String procedureName;

    /**
     * 本次工时数
     */
    @TableField(value = "labour_hour_amount")
    private BigDecimal labourHourAmount;

    /**
     * 单位工时成本
     */
    @TableField(value = "cost_price")
    private BigDecimal costPrice;

    /**
     * 工时成本小计
     */
    @TableField(value = "subtotal")
    private BigDecimal subtotal;

    /**
     * 工序描述
     */
    @TableField(value = "procedure_describe")
    private String procedureDescribe;

    /**
     * 登记次数
     */
    @TableField(value = "reg_count")
    private BigDecimal regCount;

    /**
     * 负责人
     */
    @TableField(value = "procedure_responsible_person")
    private String procedureResponsiblePerson;

    /**
     * 登记
     */
    @TableField(value = "register")
    private String register;

    /**
     * 登记时间
     */
    @TableField(value = "register_time")
    private Date registerTime;

    /**
     * 审核人
     */
    @TableField(value = "checker")
    private String checker;

    /**
     * 审核时间
     */
    @TableField(value = "check_time")
    private Date checkTime;
}