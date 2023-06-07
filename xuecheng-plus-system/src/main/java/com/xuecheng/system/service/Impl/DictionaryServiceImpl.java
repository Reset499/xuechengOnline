package com.xuecheng.system.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.system.mapper.DictionaryMapper;
import com.xuecheng.system.pojo.Dictionary;
import com.xuecheng.system.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public List<Dictionary> queryAll() {
        return this.list();
    }

    @Override
    public Dictionary getByCode(String code) {
        LambdaQueryWrapper<Dictionary> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Dictionary::getCode,code);
        Dictionary dictionary = this.getOne(lambdaQueryWrapper);
        return dictionary;
    }
}
