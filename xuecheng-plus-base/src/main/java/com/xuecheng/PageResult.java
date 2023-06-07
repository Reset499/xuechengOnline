package com.xuecheng;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

//将分页查询的返回结果统一包装成一个result类
@Data
public class PageResult<T> implements Serializable {
    private List<T> items;
    private long counts;
    private long page;
    private long pageSize;

    public PageResult() {
    }

    public PageResult(List<T> items, long counts, long page, long pageSize) {
        this.items = items;
        this.counts = counts;
        this.page = page;
        this.pageSize = pageSize;
    }
}
