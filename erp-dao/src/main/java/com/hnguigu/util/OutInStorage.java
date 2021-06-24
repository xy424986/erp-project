package com.hnguigu.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class OutInStorage {
    private Integer id;/*入库id*/
    private Integer gatheredAmount;/*确认入库件数*/
    private String gatherId;/*入库编号*/
    private String register;/*登记人*/
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date registerTime;/*登记时间*/

}
