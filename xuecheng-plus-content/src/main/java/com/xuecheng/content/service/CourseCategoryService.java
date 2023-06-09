package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.content.dto.CourseCategoryTreeDto;
import com.xuecheng.content.po.CourseCategory;

import java.util.List;

public interface CourseCategoryService extends IService<CourseCategory> {
    public List<CourseCategoryTreeDto> queryTreeNodes(String id);
}
