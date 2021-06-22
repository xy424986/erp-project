package com.hnguigu.util;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Scheduling {
    private String productId;/*产品编号*/
    private String gatherId;/*入库编号*/
    private String attemper;/*调度人*/
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date attemperTime;/*调度时间*/
    private Integer amount;/*当前存储量*/
    private String ass;/*储存地址集合*/
    private String scellformId;/*明细表的parentId*/

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

    public String getGatherId() {
        return gatherId;
    }

    public void setGatherId(String gatherId) {
        this.gatherId = gatherId;
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

    public Scheduling() {
    }

    public String getScellformId() {
        return scellformId;
    }

    public void setScellformId(String scellformId) {
        this.scellformId = scellformId;
    }

    @Override
    public String toString() {
        return "Scheduling{" +
                "productId='" + productId + '\'' +
                ", gatherId='" + gatherId + '\'' +
                ", attemper='" + attemper + '\'' +
                ", attemperTime=" + attemperTime +
                ", amount=" + amount +
                ", ass='" + ass + '\'' +
                ", scellformId='" + scellformId + '\'' +
                '}';
    }

    public Scheduling(String productId, String gatherId, String attemper, Date attemperTime, Integer amount, String ass, String scellformId) {
        this.productId = productId;
        this.gatherId = gatherId;
        this.attemper = attemper;
        this.attemperTime = attemperTime;
        this.amount = amount;
        this.ass = ass;
        this.scellformId = scellformId;
    }
}
