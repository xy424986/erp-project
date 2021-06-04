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
 * 1，AMOUNT_SUM为所有出库商品的件数合计，COST_PRICE_SUM为所有出库商品的金额合计
 */
@Data
@TableName("s_pay")
public class SPay {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("PAY_ID")
    private String payId;/*出库单编号*/

    @TableField("STORER")
    private String storer;/*出库人*/

    @TableField("REASON")
    private String reason;/*出库理由
                        C002-1: 生产领料
                        C002-2: 赠送
                        C002-3: 内部借领
                        C002-4: 其他借领*/

    @TableField("REASONEXACT")
    private String reasonexact;/*出库详细理由*/

    @TableField("AMOUNT_SUM")
    private Integer amountSum;/*总件数*/

    @TableField("COST_PRICE_SUM")
    private Double costPriceSum;/*总金额*/

    @TableField("PAID_AMOUNT_SUM")
    private Integer paidAmountSum;/*确认出库总件数*/

    @TableField("REMARK")
    private String remark;/*备注*/

    @TableField("REGISTER")
    private String register;/*登记人*/

    @TableField("REGISTER_TIME")
    private Date registerTime;/*登记时间*/

    @TableField("CHECKER")
    private String checker;/*复核人*/

    @TableField("CHECK_TIME")
    private Date checkTime;/*复核时间*/

    @TableField("CHECK_TAG")
    private String checkTag;/*审核标志
                            S001-0: 等待审核
                            S001-1: 审核通过
                            S001-2: 审核不通过*/

    @TableField("ATTEMPER")
    private String attemper;/*调度人*/

    @TableField("ATTEMPER_TIME")
    private Date attemperTime;/*调度时间*/

    @TableField("PAY_TAG")
    private String payTag;/*库存标志
                            K002-1: 已登记
                            K002-2: 已调度*/



}
