package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.content.dto.SaveTeachplanDto;
import com.xuecheng.content.dto.TeachplanDto;
import com.xuecheng.content.po.Teachplan;

import java.util.List;

public interface TeachplanService extends IService<Teachplan> {
    public List<TeachplanDto> findTeachplanTree(Long courseId);

    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto);
}
