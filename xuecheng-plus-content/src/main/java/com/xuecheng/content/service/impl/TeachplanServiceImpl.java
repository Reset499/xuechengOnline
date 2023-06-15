package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.content.dto.SaveTeachplanDto;
import com.xuecheng.content.dto.TeachplanDto;
import com.xuecheng.content.mapper.TeachplanMediaMapper;
import com.xuecheng.content.mapper.TeachplanWorkMapper;
import com.xuecheng.content.po.Teachplan;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.po.TeachplanMedia;
import com.xuecheng.content.po.TeachplanWork;
import com.xuecheng.content.service.TeachplanService;
import com.xuecheng.exception.XueChengPlusException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachplanServiceImpl extends ServiceImpl<TeachplanMapper, Teachplan> implements TeachplanService {

    @Autowired
    TeachplanMapper teachplanMapper;

    @Autowired
    TeachplanMediaMapper teachplanMediaMapper;

    @Autowired
    TeachplanWorkMapper teachplanWorkMapper;

    @Override
    public List<TeachplanDto> findTeachplanTree(Long courseId) {
        return teachplanMapper.selectTreeNodes(courseId);
    }

    @Override
    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto) {
        //根据课程计划id来判断本次操作是新增还是修改 若已存在 则是修改 若不存在则新增
        Long teachplanId = saveTeachplanDto.getId();
        if (teachplanId == null) {
            //新增
            Teachplan teachplan = new Teachplan();
            BeanUtils.copyProperties(saveTeachplanDto, teachplan);
            //确定排序字段,找到同节点个数,排序字段就是个数+1
            Long parentId = saveTeachplanDto.getParentid();
            Long courseId = saveTeachplanDto.getCourseId();
            LambdaQueryWrapper<Teachplan> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Teachplan::getCourseId, courseId);
            lambdaQueryWrapper.eq(Teachplan::getParentid, parentId);
            Integer count = teachplanMapper.selectCount(lambdaQueryWrapper);
            teachplan.setOrderby(count + 1);
            teachplanMapper.insert(teachplan);
        } else {
            //修改
            Teachplan teachplan = teachplanMapper.selectById(teachplanId);
            BeanUtils.copyProperties(saveTeachplanDto, teachplan);
            teachplanMapper.updateById(teachplan);
        }
    }

    @Override
    public void deleteTeachplan(Long id) {
        Teachplan teachplan = teachplanMapper.selectById(id);
        Long grade = teachplan.getGrade();
        LambdaQueryWrapper<Teachplan> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Teachplan::getParentid, id);
        int count = teachplanMapper.selectCount(lambdaQueryWrapper);
        //如果大章节没有子小节 就可以删掉
        if (grade == 1 && count == 0) {
            teachplanMapper.deleteById(id);
        } else if (grade == 1 && count != 0) {
            XueChengPlusException.cast("无法删除 请先删除子小节");
        } else if (grade == 2) {
            teachplanMapper.deleteById(id);
            //删除teachplanId是该id的 media和work
            LambdaQueryWrapper<TeachplanMedia> lambdaQueryWrapper1 = new LambdaQueryWrapper<>();
            lambdaQueryWrapper1.eq(TeachplanMedia::getTeachplanId, id);
            teachplanMediaMapper.delete(lambdaQueryWrapper1);

            LambdaQueryWrapper<TeachplanWork> lambdaQueryWrapper2 = new LambdaQueryWrapper<>();
            lambdaQueryWrapper2.eq(TeachplanWork::getTeachplanId, id);
            teachplanWorkMapper.delete(lambdaQueryWrapper2);
        }
    }
}
