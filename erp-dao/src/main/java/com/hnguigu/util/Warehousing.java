package com.hnguigu.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Warehousing {
    private String storer;/*入库人*/
    private String productId;/*产品编号*/
    private String productName;/*产品名称*/
    private String productDescribe;/*描述*/
    private String reason;/*入库理由*/
    private Integer amountSum;/*总件数*/
    private Double costPriceSum;/*总金额*/
    private String remark;/*备注*/
    private String register;/*登记人*/
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date registerTime;/*登记时间*/
    private Integer amount;/*数量*/
    private String amountUnit;/*单位*/
    private Double costPrice;/*单价*/
    private Double subtotal;/*小计*/

    public String getStorer() {
        return storer;
    }

    public void setStorer(String storer) {
        this.storer = storer;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAmountSum() {
        return amountSum;
    }

    public void setAmountSum(Integer amountSum) {
        this.amountSum = amountSum;
    }

    public Double getCostPriceSum() {
        return costPriceSum;
    }

    public void setCostPriceSum(Double costPriceSum) {
        this.costPriceSum = costPriceSum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
