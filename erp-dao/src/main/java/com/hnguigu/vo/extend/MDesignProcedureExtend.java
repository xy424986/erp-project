package com.hnguigu.vo.extend;

import com.hnguigu.vo.MDesignProcedure;

import java.util.Date;

public class MDesignProcedureExtend extends MDesignProcedure {

    private Integer id;/*序号*/

    private Integer parentId;/*父级序号*/

    private Integer detailsNumber;/*工序序号*/

    private String procedureId;/*工序编号*/

    private String procedureName;/*工序名称*/

    private Double labourHourAmount;/*工时数*/

    private String procedureDescribe;/*工序描述*/

    private String amountUnit;/*单位*/

    private Double costPrice;/*单位工时成本*/

    private Double subtotal;/*工时成本小计*/

    private Double moduleSubtotal;/*物料成本小计*/

    private String register;/*登记人*/

    private Date registerTime;/*登记时间*/
}
