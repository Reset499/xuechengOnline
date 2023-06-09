package com.xuecheng.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuecheng.content.dto.CourseCategoryTreeDto;
import com.xuecheng.content.po.CourseCategory;

import java.util.List;

public interface CourseCategoryMapper extends BaseMapper<CourseCategory> {
    //使用递归查询分类
    public List<CourseCategoryTreeDto> selectTreeNodes(String id);
}
