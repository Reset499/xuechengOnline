package com.xuecheng.content.controller;

import com.xuecheng.PageParams;
import com.xuecheng.PageResult;
import com.xuecheng.content.dto.QueryCourseParamDto;
import com.xuecheng.content.po.CourseBase;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseBaseInfoController {

    @RequestMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamDto queryCourseParamDto){
        return null;
    }
}
