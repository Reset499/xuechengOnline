package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.PageParams;
import com.xuecheng.PageResult;
import com.xuecheng.content.dto.AddCourseDto;
import com.xuecheng.content.dto.CourseBaseInfoDto;
import com.xuecheng.content.dto.QueryCourseParamDto;
import com.xuecheng.content.po.CourseBase;
import org.springframework.web.bind.annotation.RequestBody;

public interface CourseBaseService extends IService<CourseBase> {
    public PageResult<CourseBase>  queryCourseBaseList(PageParams pageParams, QueryCourseParamDto queryCourseParamDto);

    public CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto);
}
