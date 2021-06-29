package com.hnguigu.vo.extend;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hnguigu.vo.SCell;
import lombok.Data;

import java.util.Date;

@Data
public class SCellEx extends SCell {
    private Integer id;//序号,
    private String productId;//产品编号
    private String productName;//产品名称
    private String factoryName;//制造商
    private String firstKindId;//产品I级分类编号
    private String firstKindName;//产品I级分类名称
    private String secondKindId;//产品II级分类编号
    private String secondKindName;//产品II级分类名称
    private String thirdKindId;//产品III级分类编号
    private String thirdKindName;//产品III级分类名称
    private String productNick;//产品简称
    private String type;//用途类型,Y001-1: 商品, Y001-2: 物料
    private String productClass;//档次级别,D001-1: 高档,D001-2: 中档,D001-3: 低档
    private String personalUnit;//计量单位
    private String personalValue;//计量值
    private String providerGroup;//供应商集合
    private String warranty;//保修期
    private String twinName;//替代品名称
    private String twinId;//替代品编号
    private String lifecycle;//生命周期
    private Double listPrice;//市场单价
    private Double costPrice;//计划成本单价
    private Double realCostPrice;//成本单价
    private String amountUnit;//单位
    private String productDescribe;//产品描述
    private String responsiblePerson;//产品经理
    private String register;//登记人
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date registerTime;//建档时间
    private String checker;//复核人
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date checkTime;//复核时间
    private String checkTag;//审核标志,S001-0: 等待审核,S001-1: 审核通过,S001-2: 审核不通过
    private String changer;//变更人
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date changeTime;//变更时间
    private String changeTag;/*档案变更标志,D002-0: 未变更,D002-1: 已变更*/
    private String priceChangeTag;/*价格变更标志,J001-0：未变更,J001-1：已变更*/
    private Integer fileChangeAmount;//档案变更累计
    private String deleteTag;/*产品删除标志,C001-0: 未删除,C001-1: 已删除*/
    private String designModuleTag;/*物料组成标志,W001-0: 未设计,W001-1: 已设计*/
    private String designProcedureTag;/*工序组成标志,G001-0: 未设计,G001-1: 已设计*/
    private String designCellTag;/*库存分配标志,K001-0: 未设计,K001-1: 已设计*/
    @TableField(exist = false)
    private String designer;//设计人
    @TableField(exist = false)
    private String moduleDescribe;//设计要求
    @TableField(exist = false)
    private Double costPriceSum;//物料总成本
    private Integer amount;//数量
    private Double subtotal;//小计
}
