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
 * 1、PARENT_ID与M_DESIGN_PROCEDURE的ID相对应，为外键
 * 2、对每一个产品的工序组成而言，第一个工序的DETAILS_NUMBER从1开始，每增加一个工序DETAILS_NUMBER递增1
 * 3、SUBTOTAL= LABOUR_HOUR_AMOUNT*COST_PRICE
 * 4、MODULE_SUBTOTAL等于该工序所有使用的物料成本小计
 * DESIGN_MODULE_TAG、DESIGN_MODULE_CHANGE_TAG控制当前工序的物料设计状态和物料设计变更状态
 */
@Data
@TableName("m_design_procedure_details")
public class MDesignProcedureDetails  {

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
    private Double labourHourAmount;/*工时数*/

    @TableField("PROCEDURE_DESCRIBE")
    private String procedureDescribe;/*工序描述*/

    @TableField("AMOUNT_UNIT")
    private String amountUnit;/*单位*/

    @TableField("COST_PRICE")
    private Double costPrice;/*单位工时成本*/

    @TableField("SUBTOTAL")
    private Double subtotal;/*工时成本小计*/

    @TableField("MODULE_SUBTOTAL")
    private Double moduleSubtotal;/*物料成本小计*/

    @TableField("REGISTER")
    private String register;/*登记人*/

    @TableField("REGISTER_TIME")
    private Date registerTime;/*登记时间*/

    @TableField("DESIGN_MODULE_TAG")
    private String designModuleTag;/*当前工序物料标志
                                    D002-0: 未设计
                                    D002-1: 已设计*/

    @TableField("DESIGN_MODULE_CHANGE_TAG")
    private String designModuleChangeTag;/*当前工序物料变更标志
                                            D003-0: 未变更
                                            D003-0: 已变更*/



}
