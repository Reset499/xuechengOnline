package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.PageParams;
import com.xuecheng.PageResult;
import com.xuecheng.content.dto.AddCourseDto;
import com.xuecheng.content.dto.CourseBaseInfoDto;
import com.xuecheng.content.dto.EditCourseDto;
import com.xuecheng.content.dto.QueryCourseParamDto;
import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.mapper.CourseMarketMapper;
import com.xuecheng.content.po.CourseBase;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.po.CourseCategory;
import com.xuecheng.content.po.CourseMarket;
import com.xuecheng.content.service.CourseBaseService;
import com.xuecheng.exception.XueChengPlusException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CourseBaseServiceImpl extends ServiceImpl<CourseBaseMapper, CourseBase> implements CourseBaseService {

    @Autowired
    CourseBaseMapper courseBaseMapper;

    @Autowired
    CourseMarketMapper courseMarketMapper;

    @Autowired
    CourseCategoryMapper courseCategoryMapper;

    //1.分页查询
    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamDto queryCourseParamDto) {
        //根据条件查询 加上isNotEmpty以后 若传的东西为null 则去除了这个条件
        LambdaQueryWrapper<CourseBase> lambdaQueryWrapper = new LambdaQueryWrapper<CourseBase>();
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(queryCourseParamDto.getCourseName()), CourseBase::getName, queryCourseParamDto.getCourseName());
        lambdaQueryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamDto.getAuditStatus()), CourseBase::getAuditStatus, queryCourseParamDto.getAuditStatus());
        lambdaQueryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamDto.getPublishStatus()), CourseBase::getStatus, queryCourseParamDto.getPublishStatus());

        //分页
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());

        //执行分页查询,获取查询结果
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page, lambdaQueryWrapper);
        List<CourseBase> list = pageResult.getRecords();
        long total = page.getTotal();

        //返回查询结果
        PageResult<CourseBase> courseBasePageResult = new PageResult<CourseBase>(list, total, pageParams.getPageNo(), pageParams.getPageSize());
        return courseBasePageResult;
    }


    //2.新增课程
    @Override
    public CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto) {
        //参数校验是否合法

        //向CourseBase表写入数据,一个一个往里面放
        CourseBase courseBase = new CourseBase();
        BeanUtils.copyProperties(addCourseDto, courseBase);
        courseBase.setCompanyId(companyId);
        courseBase.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        //审核状态默认为未提交
        courseBase.setAuditStatus("202002");
        //发布状态默认为未发布
        courseBase.setStatus("203001");
        //插入数据库可
        int insert = courseBaseMapper.insert(courseBase);
        if (insert <= 0) throw new RuntimeException("添加课程失败");
        //向CourseMarket表写入数据
        CourseMarket courseMarket = new CourseMarket();
        BeanUtils.copyProperties(addCourseDto, courseMarket);
        //加入课程的id
        Long courseId = courseBase.getId();
        courseMarket.setId(companyId);
        //保存营销信息
        saveCourseMarket(courseMarket);
        //从数据库查出课程相关信息
        return getCourseBaseInfo(courseId);
    }

    //2.1单独写一个方法,若已经有这个营销信息 存在则更新 不存在则添加
    private int saveCourseMarket(CourseMarket courseMarket) {
        //参数的合法性校验
        String charge = courseMarket.getCharge();
        if (charge.isEmpty()) throw new RuntimeException("收费规则为空");
        //若为收费 但收费没有价格或者小于等于
        if (charge.equals("201001")) {
            if (courseMarket.getPrice() <= 0)
                throw new RuntimeException("课程价格设置不合理");
        }
        //从数据库查询营销信息,存在则更新,不存在则添加
        Long id = courseMarket.getId();
        CourseMarket courseMarketTemp = courseMarketMapper.selectById(id);
        if (courseMarketTemp == null) {
            int insert = courseMarketMapper.insert(courseMarket);
            return insert;
        } else {
            int update = courseMarketMapper.updateById(courseMarket);
            return update;
        }
    }

    //2.2查询课程信息
    @Override
    public CourseBaseInfoDto getCourseBaseInfo(Long courseId) {
        //查询课程基本信息
        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if (courseBase == null) return null;
        //查询课程营销信息
        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);
        //将其组装起来
        CourseBaseInfoDto courseBaseInfoDto = new CourseBaseInfoDto();
        BeanUtils.copyProperties(courseBase, courseBaseInfoDto);
        BeanUtils.copyProperties(courseMarket, courseBaseInfoDto);
        //通过categoryMapper查询代码对应的名称
        CourseCategory courseCategoryMt = courseCategoryMapper.selectById(courseBase.getMt());
        courseBaseInfoDto.setMtName(courseCategoryMt.getName());
        CourseCategory courseCategorySt = courseCategoryMapper.selectById(courseBase.getSt());
        courseBaseInfoDto.setStName(courseCategorySt.getName());
        return courseBaseInfoDto;
    }

    //3.修改课程
    @Override
    public CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto editCourseDto) {
        //3.1更新课程基础信息
        CourseBase courseBase = courseBaseMapper.selectById(editCourseDto.getId());
        if(courseBase==null){
            XueChengPlusException.cast("课程不存在");
        }
        if(!companyId.equals(courseBase.getCompanyId())){
            XueChengPlusException.cast("无权修改该课程");
        }
        BeanUtils.copyProperties(editCourseDto,courseBase);
        courseBase.setChangeDate(Timestamp.valueOf(LocalDateTime.now()));
        int i = courseBaseMapper.updateById(courseBase);
        if(i<=0){
            XueChengPlusException.cast("修改课程失败");
        }
        //3.2更新课程营销信息
        CourseMarket courseMarket = courseMarketMapper.selectById(editCourseDto.getId());
        BeanUtils.copyProperties(editCourseDto,courseMarket);
        int j = courseMarketMapper.updateById(courseMarket);
        if(j<=0){
            XueChengPlusException.cast("修改课程信息失败");
        }
        //查询课程信息 并返回
        return this.getCourseBaseInfo(editCourseDto.getId());
    }
}
