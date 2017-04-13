package com.unionx.sys.module.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 模块
 *
 * @author song junjie
 */
@Data
public class Module implements Serializable{
    /**
     * 功能模块代码.  规则:上级代码_本级代码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 访问地址
     */
    private String url;
    /**
     * 上级模块 如果是顶级为0
     */
    private String parentCode;
    /**
     * 排序号
     */
    private Integer orderNo;
    /**
     * 类型 1模块 2功能按钮
     */
    private String type;
    /**
     * 权限地址,多个用","分割. 一个功能可能对应多个地址
     */
    private String permitUrl;
    /**
     * 所属系统
     */
    private Short sysCode;
    /**
     * 是否启用 1 启用 0停用
     */
    private Integer enable;
    /**
     * 模块图标
     */
    private String icon;

    /**
     * 系统类型  1：运维系统  2：客服系统  3：店家系统
     */
    private Integer sysType;

    List<Module> children;

    //==== 下面方法只是显示树的时候使用

    public String getId() {
        return this.code;
    }

    public String getText() {
        return this.name;
    }

    /**
     * 如果下级是按钮那么此节点为关闭状态
     * @return
     */
    public String getState() {
        if (children != null && children.size() > 0) {
            if (children.get(0).getType().equals("2")) {
                return "closed";
            }
            if (children.get(0).getType().equals("1")) {
                return "closed";
            }
        }
        return "open";
    }
}