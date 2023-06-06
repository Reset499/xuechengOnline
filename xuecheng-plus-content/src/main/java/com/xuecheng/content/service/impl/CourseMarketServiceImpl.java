package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.content.po.CourseMarket;
import com.xuecheng.content.mapper.CourseMarketMapper;
import com.xuecheng.content.service.CourseMarketService;
import org.springframework.stereotype.Service;

@Service
public class CourseMarketServiceImpl extends ServiceImpl<CourseMarketMapper, CourseMarket> implements CourseMarketService {
}
