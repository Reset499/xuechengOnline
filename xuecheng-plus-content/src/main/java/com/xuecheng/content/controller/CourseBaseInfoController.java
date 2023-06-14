package com.xuecheng.content.controller;

import com.xuecheng.PageParams;
import com.xuecheng.PageResult;
import com.xuecheng.content.dto.AddCourseDto;
import com.xuecheng.content.dto.CourseBaseInfoDto;
import com.xuecheng.content.dto.EditCourseDto;
import com.xuecheng.content.dto.QueryCourseParamDto;
import com.xuecheng.content.po.CourseBase;
import com.xuecheng.content.service.CourseBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "课程信息管理接口", tags = "课程信息管理接口")
@RestController
public class CourseBaseInfoController {

    @Autowired
    CourseBaseService courseBaseService;

    @ApiOperation("课程分页查询接口")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamDto queryCourseParamDto) {
        return courseBaseService.queryCourseBaseList(pageParams,queryCourseParamDto);
    }

    @ApiOperation("新增课程")
    @PostMapping("/course")
    //由页面输入的信息 添加到数据库中 返回一个添加成功的信息

    public CourseBaseInfoDto createCourseBase(@RequestBody AddCourseDto addCourseDto){
        Long companyId = 1232141425L;
        return courseBaseService.createCourseBase(companyId,addCourseDto);
    }

    @ApiOperation("根据id查询课程")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBase(@PathVariable Long courseId){
        return courseBaseService.getCourseBaseInfo(courseId);
    }

    @ApiOperation("修改课程")
    @PutMapping("/course")
    public CourseBaseInfoDto updateCourseBase(@RequestBody EditCourseDto editCourseDto){
        //获取当前机构id
        Long companyId = 1232141425L;
        return courseBaseService.updateCourseBase(companyId,editCourseDto);
    }
}
