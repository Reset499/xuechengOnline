package com.xuecheng.content.controller;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.xuecheng.content.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import com.xuecheng.content.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableSwagger2Doc
@RestController
public class CourseCategoryController {
    @Autowired
    CourseCategoryService courseCategoryService;

    @GetMapping("/course-category/tree-nodes")
    public List<CourseCategoryTreeDto> queryTreeNodes() {
        return courseCategoryService.queryTreeNodes("1");
    }
}
