package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.content.po.CoursePublish;
import com.xuecheng.content.mapper.CoursePublishMapper;
import com.xuecheng.content.service.CoursePublishService;
import org.springframework.stereotype.Service;

@Service
public class CoursePublishServiceImpl extends ServiceImpl<CoursePublishMapper, CoursePublish> implements CoursePublishService {
}
