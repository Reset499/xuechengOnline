package com.xuecheng.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuecheng.content.dto.TeachplanDto;
import com.xuecheng.content.po.Teachplan;

import java.util.List;

public interface TeachplanMapper extends BaseMapper<Teachplan> {
    public List<TeachplanDto> selectTreeNodes(Long courseId);
}
