package com.zl.base;

import java.io.Serializable;
import java.util.List;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/2
 * @description:
 **/
public class Page<T> implements Serializable {

    private List<T> list;

    private int totalCount;

    private int totalPage;

    private int currentPage;

    private int pageSize;

    public Page() {
    }

    public Page(List<T> list, int totalCount, int totalPage, int currentPage, int pageSize) {
        this.list = list;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
