package com.hnguigu.vo.extend;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

public class MDesignProcedureExtend {

    private String productName;/*产品名称*/

    private String productId;/*产品编号*/

    private String designer;/*设计人*/

    private String procedureName;/*工序名称*/

    private String procedureId;/*工序编号*/

    private String procedureDescribe;/*描述*/

    private Double labourHourAmount;/*工时数*/

    private String amountUnit;/*单位*/

    private Double costPrice;/*单位工时成本*/

    private String register;/*登记人*/

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date registerTime;/*登记时间*/

    private String procedureDescribe1;/*设计要求*/

    private Integer dFileId;//产品id

    private Integer mDPId;/*序号*/

    private Integer mDPDId;/*序号*/

    private Double moduleCostPriceSum;/*物料总成本*/

    private Integer amount;/*本工序数量*/

    private Double moduleSubtotal;/*物料成本小计*/

    public MDesignProcedureExtend() {
    }

    public Double getModuleSubtotal() {
        return moduleSubtotal;
    }

    public void setModuleSubtotal(Double moduleSubtotal) {
        this.moduleSubtotal = moduleSubtotal;
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

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureDescribe() {
        return procedureDescribe;
    }

    public void setProcedureDescribe(String procedureDescribe) {
        this.procedureDescribe = procedureDescribe;
    }

    public Double getLabourHourAmount() {
        return labourHourAmount;
    }

    public void setLabourHourAmount(Double labourHourAmount) {
        this.labourHourAmount = labourHourAmount;
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

    public String getProcedureDescribe1() {
        return procedureDescribe1;
    }

    public void setProcedureDescribe1(String procedureDescribe1) {
        this.procedureDescribe1 = procedureDescribe1;
    }

    public Integer getdFileId() {
        return dFileId;
    }

    public void setdFileId(Integer dFileId) {
        this.dFileId = dFileId;
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

    public Double getModuleCostPriceSum() {
        return moduleCostPriceSum;
    }

    public void setModuleCostPriceSum(Double moduleCostPriceSum) {
        this.moduleCostPriceSum = moduleCostPriceSum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public MDesignProcedureExtend(String productName, String productId, String designer, String procedureName, String procedureId, String procedureDescribe, Double labourHourAmount, String amountUnit, Double costPrice, String register, Date registerTime, String procedureDescribe1, Integer dFileId, Integer mDPId, Integer mDPDId, Double moduleCostPriceSum, Integer amount, Double moduleSubtotal) {
        this.productName = productName;
        this.productId = productId;
        this.designer = designer;
        this.procedureName = procedureName;
        this.procedureId = procedureId;
        this.procedureDescribe = procedureDescribe;
        this.labourHourAmount = labourHourAmount;
        this.amountUnit = amountUnit;
        this.costPrice = costPrice;
        this.register = register;
        this.registerTime = registerTime;
        this.procedureDescribe1 = procedureDescribe1;
        this.dFileId = dFileId;
        this.mDPId = mDPId;
        this.mDPDId = mDPDId;
        this.moduleCostPriceSum = moduleCostPriceSum;
        this.amount = amount;
        this.moduleSubtotal = moduleSubtotal;
    }

    @Override
    public String toString() {
        return "MDesignProcedureExtend{" +
                "productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", designer='" + designer + '\'' +
                ", procedureName='" + procedureName + '\'' +
                ", procedureId='" + procedureId + '\'' +
                ", procedureDescribe='" + procedureDescribe + '\'' +
                ", labourHourAmount=" + labourHourAmount +
                ", amountUnit='" + amountUnit + '\'' +
                ", costPrice=" + costPrice +
                ", register='" + register + '\'' +
                ", registerTime=" + registerTime +
                ", procedureDescribe1='" + procedureDescribe1 + '\'' +
                ", dFileId=" + dFileId +
                ", mDPId=" + mDPId +
                ", mDPDId=" + mDPDId +
                ", moduleCostPriceSum=" + moduleCostPriceSum +
                ", amount=" + amount +
                ", moduleSubtotal=" + moduleSubtotal +
                '}';
    }
}
