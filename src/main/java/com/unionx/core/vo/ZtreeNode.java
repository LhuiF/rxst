package com.unionx.core.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ZTree 的节点数据封装
 * @author songjunjie
 */
@Data
public class ZtreeNode {
    private String id;
    private String name;
    private boolean checked;
    /**
     * 是否为打开状态
     */
    private boolean open;
    private List<ZtreeNode> children;
    private String parentId;

}
