package com.hnguigu.vo.extend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hnguigu.vo.SGather;
import lombok.Data;

@Data
@TableName("s_gather_details")
public class SGatherEx extends SGather {

        @TableId(value = "ID", type = IdType.AUTO)
        private Integer id;/*序号*/

        @TableField("PARENT_ID")
        private Integer parentId;/*父级序号*/

        @TableField("PRODUCT_ID")
        private String productId;/*产品编号*/

        @TableField("PRODUCT_NAME")
        private String productName;/*产品名称*/

        @TableField("PRODUCT_DESCRIBE")
        private String productDescribe;/*描述*/

        @TableField("AMOUNT")
        private Integer amount;/*数量*/

        @TableField("AMOUNT_UNIT")
        private String amountUnit;/*单位*/

        @TableField("COST_PRICE")
        private Double costPrice;/*单价*/

        @TableField("SUBTOTAL")
        private Double subtotal;/*小计*/

        @TableField("GATHERED_AMOUNT")
        private Integer gatheredAmount;/*确认入库件数*/

        @TableField("GATHER_TAG")
        private String gatherTag;/*入库标志
                                K002-1: 已登记
                                K002-2: 已调度*/

    @TableField("MAX_CAPACITY_AMOUNT")
    private Integer maxCapacityAmount;/*最大存储量*/
    @TableField("FIRST_KIND_ID")
    private String firstKindId;//产品I级分类编号

    @TableField("FIRST_KIND_NAME")
    private String firstKindName;//产品I级分类名称

    @TableField("SECOND_KIND_ID")
    private String secondKindId;//产品II级分类编号

    @TableField("SECOND_KIND_NAME")
    private String secondKindName;//产品II级分类名称

    @TableField("THIRD_KIND_ID")
    private String thirdKindId;//产品III级分类编号

    @TableField("THIRD_KIND_NAME")
    private String thirdKindName;//产品III级分类名称

    @TableField("STORAGE_UNIT_ABBREVIATION")
    private String storageUnitAbbreviation;/*储存单元简称*/
}
