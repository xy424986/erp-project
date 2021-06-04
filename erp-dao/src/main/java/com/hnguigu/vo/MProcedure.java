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
 * 1、PARENT_ID和M_MANUFACTURE的ID相对应，为外键
 * 2、DETAILS_NUMBER从1开始，每增加一个工序DETAILS_NUMBER递增1
 * DEMAND_AMOUNT指的是工序投产时的数量，REAL_AMOUNT指的是工序在交接时的实际数量
 */
@Data
@TableName("m_procedure")
public class MProcedure  {



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
    private Double labourHourAmount;/*设计工时数*/

    @TableField("REAL_LABOUR_HOUR_AMOUNT")
    private Double realLabourHourAmount;/*实际工时数*/

    @TableField("SUBTOTAL")
    private Double subtotal;/*设计工时成本*/

    @TableField("REAL_SUBTOTAL")
    private Double realSubtotal;/*实际工时成本*/

    @TableField("MODULE_SUBTOTAL")
    private Double moduleSubtotal;/*设计物料成本*/

    @TableField("REAL_MODULE_SUBTOTAL")
    private Double realModuleSubtotal;/*实际物料成本*/

    @TableField("COST_PRICE")
    private Double costPrice;/*单位工时成本*/

    @TableField("DEMAND_AMOUNT")
    private Integer demandAmount;/*工序投产数量*/

    @TableField("REAL_AMOUNT")
    private Integer realAmount;/*工序合格数量*/

    @TableField("PROCEDURE_FINISH_TAG")
    private String procedureFinishTag;/*工序完成标志
                                        G004-0: 未开始
                                        G004-1: 已完成
                                        G004-2: 未完成
                                        G004-3: 已审核*/

    @TableField("PROCEDURE_TRANSFER_TAG")
    private String procedureTransferTag;/*工序交接标志
                                            G005-0: 未交接
                                            G005-1: 已交接
                                            G005-2: 已审核*/



}
