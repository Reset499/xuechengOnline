package com.xuecheng.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.PageParams;
import com.xuecheng.PageResult;
import com.xuecheng.system.pojo.Dictionary;

import java.util.List;

public interface DictionaryService extends IService<Dictionary> {
    public List<Dictionary> queryAll();
    public Dictionary getByCode(String code);
}
