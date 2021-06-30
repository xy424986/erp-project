package com.hnguigu.vo.zsxvo.pojo.d;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("d_module")
public class Module {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String designId;

    private String productId;

    private String productName;

    private String firstKindId;

    private String firstKindName;

    private String secondKindId;

    private String secondKindName;

    private String thirdKindId;

    private String thirdKindName;

    private String designer;

    private String moduleDescribe;

    private BigDecimal costPriceSum;

    private String register;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registerTime;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(exist = false)
    private Date registerTime2;

    private String checker;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date checkTime;

    private String changer;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date changeTime;

    private String checkTag;

    private String changeTag;


}
