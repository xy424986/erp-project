package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 注：
 * 1,AMOUNT_SUM为所有入库商品的件数合计，COST_PRICE_SUM为所有入库商品的金额合计
 */
@Data
@TableName("s_gather")
public class SGather{


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("GATHER_ID")
    private String gatherId;/*入库单编号*/

    @TableField("STORER")
    private String storer;/*入库人*/

    @TableField("REASON")
    private String reason;/*入库理由
                            R001-1: 生产入库
                            R001-2: 库存初始
                            R001-3: 赠送
                            R001-4: 内部归还
                            R001-5: 其他归还*/

    @TableField("REASONEXACT")
    private String reasonexact;/*入库详细理由*/

    @TableField("AMOUNT_SUM")
    private Integer amountSum;/*总件数*/

    @TableField("COST_PRICE_SUM")
    private Double costPriceSum;/*总金额*/

    @TableField("GATHERED_AMOUNT_SUM")
    private Integer gatheredAmountSum;/*确认入库总件数*/

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
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date attemperTime;/*调度时间*/

    @TableField("GATHER_TAG")
    private String gatherTag;/*库存标志
                                K002-1: 已登记
                                K002-2: 已调度*/



}
