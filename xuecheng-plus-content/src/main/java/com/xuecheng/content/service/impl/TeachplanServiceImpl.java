package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.content.po.Teachplan;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.service.TeachplanService;
import org.springframework.stereotype.Service;

@Service
public class TeachplanServiceImpl extends ServiceImpl<TeachplanMapper, Teachplan> implements TeachplanService {
}
