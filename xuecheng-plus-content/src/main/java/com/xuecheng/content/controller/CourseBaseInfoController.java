package com.xuecheng.content.controller;

import com.xuecheng.PageParams;
import com.xuecheng.PageResult;
import com.xuecheng.content.dto.QueryCourseParamDto;
import com.xuecheng.content.po.CourseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "课程信息管理接口",tags = "课程信息管理接口")
@RestController
public class CourseBaseInfoController {
    @ApiOperation("课程查询接口")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamDto queryCourseParamDto){
        return null;
    }
}
