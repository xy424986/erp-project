package com.hnguigu.vo.extend;

import com.baomidou.mybatisplus.annotation.TableField;
import com.hnguigu.vo.SPay;

public class SPayEX extends SPay {
    private Integer id;/*序号*/
    private Integer parentId;/*父级序号*/
    private String productId;/*产品编号*/
    private String productName;/*产品名称*/
    private String productDescribe;/*描述*/
    private Integer amount;/*数量*/
    private String amountUnit;/*单位*/
    private Double costPrice;/*单价*/
    private Double subtotal;/*小计*/
    private Integer paidAmount;/*确认出库件数*/
    private String payTag;/*出库标志
                            K002-1: 已登记
                            K002-2: 已调度*/
    private String payAss;/*储存地址集合*/
    private String firstKindId;//产品I级分类编号
    private String firstKindName;//产品I级分类名称
    private String secondKindId;//产品II级分类编号
    private String secondKindName;//产品II级分类名称
    private String thirdKindId;//产品III级分类编号
    private String thirdKindName;//产品III级分类名称
    private String storageUnitAbbreviation;/*储存单元简称*/
    private int scAmoupayAssnt;/*已存数量*/

    @Override
    public String toString() {
        return "SPayEX{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescribe='" + productDescribe + '\'' +
                ", amount=" + amount +
                ", amountUnit='" + amountUnit + '\'' +
                ", costPrice=" + costPrice +
                ", subtotal=" + subtotal +
                ", paidAmount=" + paidAmount +
                ", payTag='" + payTag + '\'' +
                ", payAss='" + payAss + '\'' +
                ", firstKindId='" + firstKindId + '\'' +
                ", firstKindName='" + firstKindName + '\'' +
                ", secondKindId='" + secondKindId + '\'' +
                ", secondKindName='" + secondKindName + '\'' +
                ", thirdKindId='" + thirdKindId + '\'' +
                ", thirdKindName='" + thirdKindName + '\'' +
                ", storageUnitAbbreviation='" + storageUnitAbbreviation + '\'' +
                ", scAmoupayAssnt=" + scAmoupayAssnt +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    @Override
    public String getPayTag() {
        return payTag;
    }

    @Override
    public void setPayTag(String payTag) {
        this.payTag = payTag;
    }

    public String getPayAss() {
        return payAss;
    }

    public void setPayAss(String payAss) {
        this.payAss = payAss;
    }

    public String getFirstKindId() {
        return firstKindId;
    }

    public void setFirstKindId(String firstKindId) {
        this.firstKindId = firstKindId;
    }

    public String getFirstKindName() {
        return firstKindName;
    }

    public void setFirstKindName(String firstKindName) {
        this.firstKindName = firstKindName;
    }

    public String getSecondKindId() {
        return secondKindId;
    }

    public void setSecondKindId(String secondKindId) {
        this.secondKindId = secondKindId;
    }

    public String getSecondKindName() {
        return secondKindName;
    }

    public void setSecondKindName(String secondKindName) {
        this.secondKindName = secondKindName;
    }

    public String getThirdKindId() {
        return thirdKindId;
    }

    public void setThirdKindId(String thirdKindId) {
        this.thirdKindId = thirdKindId;
    }

    public String getThirdKindName() {
        return thirdKindName;
    }

    public void setThirdKindName(String thirdKindName) {
        this.thirdKindName = thirdKindName;
    }

    public String getStorageUnitAbbreviation() {
        return storageUnitAbbreviation;
    }

    public void setStorageUnitAbbreviation(String storageUnitAbbreviation) {
        this.storageUnitAbbreviation = storageUnitAbbreviation;
    }

    public int getScAmoupayAssnt() {
        return scAmoupayAssnt;
    }

    public void setScAmoupayAssnt(int scAmoupayAssnt) {
        this.scAmoupayAssnt = scAmoupayAssnt;
    }

    public SPayEX() {
    }

    public SPayEX(Integer id, Integer parentId, String productId, String productName, String productDescribe, Integer amount, String amountUnit, Double costPrice, Double subtotal, Integer paidAmount, String payTag, String payAss, String firstKindId, String firstKindName, String secondKindId, String secondKindName, String thirdKindId, String thirdKindName, String storageUnitAbbreviation, int scAmoupayAssnt) {
        this.id = id;
        this.parentId = parentId;
        this.productId = productId;
        this.productName = productName;
        this.productDescribe = productDescribe;
        this.amount = amount;
        this.amountUnit = amountUnit;
        this.costPrice = costPrice;
        this.subtotal = subtotal;
        this.paidAmount = paidAmount;
        this.payTag = payTag;
        this.payAss = payAss;
        this.firstKindId = firstKindId;
        this.firstKindName = firstKindName;
        this.secondKindId = secondKindId;
        this.secondKindName = secondKindName;
        this.thirdKindId = thirdKindId;
        this.thirdKindName = thirdKindName;
        this.storageUnitAbbreviation = storageUnitAbbreviation;
        this.scAmoupayAssnt = scAmoupayAssnt;
    }
}
