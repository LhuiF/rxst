package com.unionx.core.vo;

import java.util.List;

/**
 * easyui Datagrid 控件数据格式封装
 * @author song junjie
 */
public class DataGridData<T> extends CommonResponse {
    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
