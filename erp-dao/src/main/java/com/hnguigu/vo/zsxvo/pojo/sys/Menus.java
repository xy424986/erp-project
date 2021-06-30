package com.hnguigu.vo.zsxvo.pojo.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("sys_menus")
/**
 * 菜单
 */
public class Menus {

    /**
     * 序号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 父级序号
     */
    @TableField("PARENT_ID")
    private Integer parentId;

    /**
     * 排序
     */
    @TableField("SEQ")
    private Integer seq;

    /**
     * 菜单名称
     */
    @TableField("name")
    private String name;

    /**
     * 提示信息
     */
    @TableField("tip")
    private String tip;

    /**
     * 菜单说明
     */
    @TableField("descn")
    private String descn;

    /**
     * 图片地址
     */
    @TableField("image_url")
    private String imageUrl;

    /**
     * 链接地址
     */
    @TableField("link_url")
    private String linkUrl;

    /**
     * 目标窗口
     */
    @TableField("target")
    private String target;

    /**
     * 是否可用
     */
    @TableField("status")
    private String status;


    /**
     * 子菜单集合
     */
    @TableField(exist = false)
    List<Menus> childMenu;


}