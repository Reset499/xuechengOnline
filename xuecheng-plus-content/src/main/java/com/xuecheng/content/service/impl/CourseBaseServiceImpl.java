package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.PageParams;
import com.xuecheng.PageResult;
import com.xuecheng.content.dto.QueryCourseParamDto;
import com.xuecheng.content.po.CourseBase;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.service.CourseBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseBaseServiceImpl extends ServiceImpl<CourseBaseMapper, CourseBase> implements CourseBaseService {

    @Autowired CourseBaseMapper courseBaseMapper;
    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamDto queryCourseParamDto) {
        //根据条件查询
        LambdaQueryWrapper<CourseBase> lambdaQueryWrapper = new LambdaQueryWrapper<CourseBase>();
        lambdaQueryWrapper.like(CourseBase::getName,queryCourseParamDto.getCourseName());
        lambdaQueryWrapper.eq(CourseBase::getAuditStatus,queryCourseParamDto.getAuditStatus());
        lambdaQueryWrapper.eq(CourseBase::getStatus,queryCourseParamDto.getPublishStatus());

        //分页
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(),pageParams.getPageSize());

        //执行分页查询,获取查询结果
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page,lambdaQueryWrapper);
        List<CourseBase> list = pageResult.getRecords();
        long total = page.getTotal();

        //返回查询结果
        PageResult<CourseBase> courseBasePageResult = new PageResult<CourseBase>(list,total, pageParams.getPageNo(), pageParams.getPageSize());
        return courseBasePageResult;
    }
}
