package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.PageParams;
import com.xuecheng.PageResult;
import com.xuecheng.content.dto.QueryCourseParamDto;
import com.xuecheng.content.po.CourseBase;

public interface CourseBaseService extends IService<CourseBase> {
    public PageResult<CourseBase>  queryCourseBaseList(PageParams pageParams, QueryCourseParamDto queryCourseParamDto);
}
