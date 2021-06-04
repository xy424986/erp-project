package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("sys_codes")
public class SysCodes{


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("PARENT_ID")
    private Integer parentId;/*父级序号*/

    @TableField("CODE_ID")
    private String codeId;/*代码编号*/

    @TableField("NAME")
    private String name;/*代码名称*/

    @TableField("STATUS")
    private String status;/*状态*/

    @TableField("DEF_VALUE")
    private String defValue;/*默认值*/

    @TableField("DESCN")
    private String descn;/*说明*/



}
