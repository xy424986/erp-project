package com.hnguigu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("sys_menus")
public class SysMenus  {


    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;/*序号*/

    @TableField("PARENT_ID")
    private Integer parentId;/*父级序号*/

    @TableField("SEQ")
    private Integer seq;/*排序*/

    @TableField("NAME")
    private String name;/*菜单名称*/

    @TableField("TIP")
    private String tip;/*提示信息*/

    @TableField("DESCN")
    private String descn;/*菜单说明*/

    @TableField("IMAGE_URL")
    private String imageUrl;/*图片地址*/

    @TableField("LINK_URL")
    private String linkUrl;/*链接地址*/

    @TableField("TARGET")
    private String target;/*目标窗口*/

    @TableField("STATUS")
    private String status;/*是否可用*/



}
