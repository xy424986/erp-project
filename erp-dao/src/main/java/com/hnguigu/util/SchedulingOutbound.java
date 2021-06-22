package com.hnguigu.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SchedulingOutbound {
    private String productId;/*产品编号*/
    private String payId;/*出库编号*/
    private String attemper;/*调度人*/
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date attemperTime;/*调度时间*/
    private Integer amount;/*要出库的数量*/
    private String ass;/*储存地址集合*/
    private String scellformId;/*明细表的parentId*/
    private String reason;/*出库理由
                        C002-1: 生产领料
                        C002-2: 赠送
                        C002-3: 内部借领
                        C002-4: 其他借领*/

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAss() {
        return ass;
    }

    public void setAss(String ass) {
        this.ass = ass;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getAttemper() {
        return attemper;
    }

    public void setAttemper(String attemper) {
        this.attemper = attemper;
    }

    public Date getAttemperTime() {
        return attemperTime;
    }

    public void setAttemperTime(Date attemperTime) {
        this.attemperTime = attemperTime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;

    }

    public SchedulingOutbound() {
    }

    public String getScellformId() {
        return scellformId;
    }

    public void setScellformId(String scellformId) {
        this.scellformId = scellformId;
    }

    @Override
    public String toString() {
        return "SchedulingOutbound{" +
                "productId='" + productId + '\'' +
                ", payId='" + payId + '\'' +
                ", attemper='" + attemper + '\'' +
                ", attemperTime=" + attemperTime +
                ", amount=" + amount +
                ", ass='" + ass + '\'' +
                ", scellformId='" + scellformId + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    public SchedulingOutbound(String productId, String payId, String attemper, Date attemperTime, Integer amount, String ass, String scellformId, String reason) {
        this.productId = productId;
        this.payId = payId;
        this.attemper = attemper;
        this.attemperTime = attemperTime;
        this.amount = amount;
        this.ass = ass;
        this.scellformId = scellformId;
        this.reason = reason;
    }
}
