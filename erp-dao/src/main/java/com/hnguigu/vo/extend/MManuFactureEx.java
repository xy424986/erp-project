package com.hnguigu.vo.extend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hnguigu.vo.MManuFacture;
import lombok.Data;

@Data
public class MManuFactureEx extends MManuFacture {
    private Integer id;/*序号*/
    private Integer parentId;/*父级序号*/
    private Integer detailsNumber;/*工序序号*/
    private String procedureId;/*工序编号*/
    private String procedureName;/*工序名称*/
    private Double labourHourAmount;/*设计工时数*/
    private Double realLabourHourAmount;/*实际工时数*/
    private Double subtotal;/*设计工时成本*/
    private Double realSubtotal;/*实际工时成本*/
    private Double moduleSubtotal;/*设计物料成本*/
    private Double realModuleSubtotal;/*实际物料成本*/
    private Double costPrice;/*单位工时成本*/
    private Integer demandAmount;/*工序投产数量*/
    private Integer realAmount;/*工序合格数量*/
    private String procedureFinishTag;/*工序完成标志
                                        G004-0: 未开始
                                        G004-1: 已完成
                                        G004-2: 未完成
                                        G004-3: 已审核*/
    private String procedureTransferTag;/*工序交接标志
                                            G005-0: 未交接
                                            G005-1: 已交接
                                            G005-2: 已审核*/
}
