package com.xuecheng.content.dto;

import com.xuecheng.content.po.CourseCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CourseCategoryTreeDto extends CourseCategory implements Serializable {
    //子节点
    List<CourseCategoryTreeDto> childrenTreeNodes;
}
