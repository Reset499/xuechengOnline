package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.content.entity.CourseAudit;
import com.xuecheng.content.mapper.CourseAuditMapper;
import com.xuecheng.content.service.CourseAuditService;
import org.springframework.stereotype.Service;

@Service
public class CourseAuditServiceImpl extends ServiceImpl<CourseAuditMapper, CourseAudit> implements CourseAuditService {
}
