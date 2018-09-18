package com.wayming.codeland.pojo.vo;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-20 下午8:51
 */
public class PageVO<T> {

    private Integer pageNo = 1;

    private Integer pageSize = 10;

    private Integer totalPage;

    private Long totalCount;

    private List<T> data;

    public PageVO(){

    }

    public PageVO(Integer pageNo, Integer pageSize, Integer totalPage, Long totalCount, List<T> data) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.data = data;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        if (this.totalPage != null) {
            return this.totalPage;
        }
        return (int)(Math.ceil(this.totalCount * 1.0 / this.pageSize));
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isFirstNo() {
        return this.pageNo.equals(1);
    }

    public boolean hasNextPage() {
        return !this.pageNo.equals(this.totalPage);
    }

    public Integer nextPage() {
        if (hasNextPage()) {
            return this.pageNo + 1;
        } else {
            return this.totalPage;
        }
    }

    public Integer prePage() {
        if (isFirstNo()) {
            return 1;
        } else {
            return this.pageNo - 1;
        }
    }


    @Override
    public String toString() {
        return "PageVO{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", data=" + data +
                '}';
    }
}
