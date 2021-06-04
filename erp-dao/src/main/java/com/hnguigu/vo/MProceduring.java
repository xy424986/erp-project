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
 * 1、PARENT_ID和M_MANUFACTURE的ID相对应，为外键
 * 2，REG_COUNT为工序的生产登记次数，如果是第一次生产则REG_COUNT为1，如果是第二次生产则REG_COUNT为2，以此类推
 */
@Data
@TableName("m_proceduring")
public class MProceduring  {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("PARENT_ID")
    private Integer parentId;/*父级序号*/

    @TableField("DETAILS_NUMBER")
    private Integer detailsNumber;/*工序序号*/

    @TableField("PROCEDURE_ID")
    private String procedureId;/*工序编号*/

    @TableField("PROCEDURE_NAME")
    private String procedureName;/*工序名称*/

    @TableField("LABOUR_HOUR_AMOUNT")
    private Double labourHourAmount;/*本次工时数*/

    @TableField("COST_PRICE")
    private Double costPrice;/*单位工时成本*/

    @TableField("SUBTOTAL")
    private Double subtotal;/*工时成本小计*/

    @TableField("PROCEDURE_DESCRIBE")
    private String procedureDescribe;/*工序描述*/

    @TableField("REG_COUNT")
    private Integer regCount;/*登记次数*/

    @TableField("PROCEDURE_RESPONSIBLE_PERSON")
    private String procedureResponsiblePerson;/*负责人*/

    @TableField("REGISTER")
    private String register;/*登记人*/

    @TableField("REGISTER_TIME")
    private Date registerTime;/*登记时间*/

    @TableField("CHECKER")
    private String checker;/*审核人*/

    @TableField("CHECK_TIME")
    private Date checkTime;/*审核时间*/



}
