package com.xuecheng;


import lombok.Data;

//将通用的分页参数包装成一个类
@Data
public class PageParams {
    //当前页码 默认为1
    private Long pageNo = 1L;

    //每页显示的记录数 默认为30
    private Long pageSize = 30L;

    public PageParams(Long pageNo, Long pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageParams() {
    }
}
