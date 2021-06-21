package com.hnguigu.vo.extend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hnguigu.vo.SGather;
import lombok.Data;

@Data
/*@TableName("s_gather_details")*/
public class SGatherEx extends SGather {

        private Integer id;/*序号*/

        private Integer parentId;/*父级序号*/

        private String productId;/*产品编号*/

        private String productName;/*产品名称*/

        private String productDescribe;/*描述*/

        private Integer amount;/*数量*/

        private String amountUnit;/*单位*/

        private Double costPrice;/*单价*/

        private Double subtotal;/*小计*/

        private Integer gatheredAmount;/*确认入库件数*/

        private String gatherTag;/*入库标志
                                K002-1: 已登记
                                K002-2: 已调度*/

    private Integer maxCapacityAmount;/*最大存储量*/
    private String firstKindId;//产品I级分类编号

    private String firstKindName;//产品I级分类名称

    private String secondKindId;//产品II级分类编号

    private String secondKindName;//产品II级分类名称

    private String thirdKindId;//产品III级分类编号

    private String thirdKindName;//产品III级分类名称

    private String storageUnitAbbreviation;/*储存单元简称*/

    private String ass;

    private int scAmount;

    @Override
    public String toString() {
        return "SGatherEx{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescribe='" + productDescribe + '\'' +
                ", amount=" + amount +
                ", amountUnit='" + amountUnit + '\'' +
                ", costPrice=" + costPrice +
                ", subtotal=" + subtotal +
                ", gatheredAmount=" + gatheredAmount +
                ", gatherTag='" + gatherTag + '\'' +
                ", maxCapacityAmount=" + maxCapacityAmount +
                ", firstKindId='" + firstKindId + '\'' +
                ", firstKindName='" + firstKindName + '\'' +
                ", secondKindId='" + secondKindId + '\'' +
                ", secondKindName='" + secondKindName + '\'' +
                ", thirdKindId='" + thirdKindId + '\'' +
                ", thirdKindName='" + thirdKindName + '\'' +
                ", storageUnitAbbreviation='" + storageUnitAbbreviation + '\'' +
                ", ass='" + ass + '\'' +
                ", scAmount=" + scAmount +
                '}';
    }



    public SGatherEx() {
    }

    public SGatherEx(Integer id, Integer parentId, String productId, String productName, String productDescribe, Integer amount, String amountUnit, Double costPrice, Double subtotal, Integer gatheredAmount, String gatherTag, Integer maxCapacityAmount, String firstKindId, String firstKindName, String secondKindId, String secondKindName, String thirdKindId, String thirdKindName, String storageUnitAbbreviation, String ass, int scAmount) {
        this.id = id;
        this.parentId = parentId;
        this.productId = productId;
        this.productName = productName;
        this.productDescribe = productDescribe;
        this.amount = amount;
        this.amountUnit = amountUnit;
        this.costPrice = costPrice;
        this.subtotal = subtotal;
        this.gatheredAmount = gatheredAmount;
        this.gatherTag = gatherTag;
        this.maxCapacityAmount = maxCapacityAmount;
        this.firstKindId = firstKindId;
        this.firstKindName = firstKindName;
        this.secondKindId = secondKindId;
        this.secondKindName = secondKindName;
        this.thirdKindId = thirdKindId;
        this.thirdKindName = thirdKindName;
        this.storageUnitAbbreviation = storageUnitAbbreviation;
        this.ass = ass;
        this.scAmount = scAmount;
    }
}
