package com.heiyu.platform.device.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 分页实体类
 * @author WangYi
 * @date 13:53 2019/8/9
 * @version 1.0
 **/

public class Pagination<T>{

    //序列化ID
    private static final long serialVersionUID = 1L;
    //页码
    private int pageNo = 1;
    //页面容量
    private int pageSize = 20;
    //总页码数
    private long total = 1000L;
    //排序列名称
    private String sortName;
    //排序顺序（DESC,ASC)
    private String sortOrder;
    //排序行数
    private List<T> rows;

    public Pagination() {
    }

    public Pagination(int pageNo, int pageSize, String sortName, String sortOrder) {
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
        this.setSortName(sortName);
        this.setSortOrder(sortOrder);
    }

    public Pagination(Collection<? extends T> c, long total, int pageNo, int pageSize) {
        this.setTotal(total);
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            boolean pageNo1 = true;
        } else {
            this.pageNo = pageNo;
        }

    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = 20;
        } else {
            this.pageSize = pageSize;
        }

    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTotal() {
        return this.total;
    }

    public int getTotalPage() {
        if (this.total <= 0L) {
            return 0;
        } else {
            int n = (int)(this.total / (long)this.pageSize);
            return this.total % (long)this.pageSize == 0L ? n : n + 1;
        }
    }

    public boolean hasPrevPage() {
        return this.pageNo > 1;
    }

    public boolean hasNextPage() {
        return this.pageNo < this.getTotalPage();
    }

    public int getFirstPage() {
        return 1;
    }

    public int getLastPage() {
        return this.getTotalPage();
    }

    public int getPrevPage() {
        return this.hasPrevPage() ? this.pageNo - 1 : 1;
    }

    public int getNextPage() {
        return this.hasNextPage() ? this.pageNo + 1 : this.getTotalPage();
    }

    public int getOffset() {
        return (this.pageNo - 1) * this.pageSize;
    }

    public int getOffsetEnd() {
        return this.getOffset() + this.getPageSize();
    }

    public String getPageOrder() {
        return this.getSortName() + " " + this.getSortOrder();
    }

    public String getSortName() {
        return this.sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

