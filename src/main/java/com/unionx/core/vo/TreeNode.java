package com.unionx.core.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * easyui tree 控件的数据结构
 * @author songjunjie
 */
@Data
public class TreeNode {
    private String id;
    /**
     * 显示节点文本。
     */
    private String text;
    /**
     * 节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
     */
    private String state;
    /**
     * 表示该节点是否被选中
     */
    private boolean checked;
    /**
     *  一个节点数组声明了若干节点。
     */
    private List<TreeNode> children;
    private String parentId;

}
