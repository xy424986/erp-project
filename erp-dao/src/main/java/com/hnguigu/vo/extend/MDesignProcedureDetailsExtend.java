package com.hnguigu.vo.extend;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MDesignProcedureDetailsExtend {

    private String procedureId;/*工序编号*/

    private String procedureName;/*工序名称*/

    private String register;/*登记人*/

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date registerTime;/*登记时间*/

    private String productName;/*物料名称*/

    private String productId;/*物料编号*/

    private String productDescribe;/*描述*/

    private String amountUnit;/*单位*/

    private Double costPrice;/*单价*/

    private Integer amount;/*数量*/

    private Integer amount1;/*自定义数量*/

    private Integer mDPId;/*序号*/

    private Integer mDPDId;/*序号*/

    private Integer residualAmount;/*可用数量*/

    public MDesignProcedureDetailsExtend() {
    }

    public MDesignProcedureDetailsExtend(String procedureId, String procedureName, String register, Date registerTime, String productName, String productId, String productDescribe, String amountUnit, Double costPrice, Integer amount, Integer amount1, Integer mDPId, Integer mDPDId, Integer residualAmount) {
        this.procedureId = procedureId;
        this.procedureName = procedureName;
        this.register = register;
        this.registerTime = registerTime;
        this.productName = productName;
        this.productId = productId;
        this.productDescribe = productDescribe;
        this.amountUnit = amountUnit;
        this.costPrice = costPrice;
        this.amount = amount;
        this.amount1 = amount1;
        this.mDPId = mDPId;
        this.mDPDId = mDPDId;
        this.residualAmount = residualAmount;
    }

    @Override
    public String toString() {
        return "MDesignProcedureDetailsExtend{" +
                "procedureId='" + procedureId + '\'' +
                ", procedureName='" + procedureName + '\'' +
                ", register='" + register + '\'' +
                ", registerTime=" + registerTime +
                ", productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", productDescribe='" + productDescribe + '\'' +
                ", amountUnit='" + amountUnit + '\'' +
                ", costPrice=" + costPrice +
                ", amount=" + amount +
                ", amount1=" + amount1 +
                ", mDPId=" + mDPId +
                ", mDPDId=" + mDPDId +
                ", residualAmount=" + residualAmount +
                '}';
    }

    public Integer getResidualAmount() {
        return residualAmount;
    }

    public void setResidualAmount(Integer residualAmount) {
        this.residualAmount = residualAmount;
    }

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getmDPId() {
        return mDPId;
    }

    public void setmDPId(Integer mDPId) {
        this.mDPId = mDPId;
    }

    public Integer getmDPDId() {
        return mDPDId;
    }

    public void setmDPDId(Integer mDPDId) {
        this.mDPDId = mDPDId;
    }

    public Integer getAmount1() {
        return amount1;
    }

    public void setAmount1(Integer amount1) {
        this.amount1 = amount1;
    }
}
