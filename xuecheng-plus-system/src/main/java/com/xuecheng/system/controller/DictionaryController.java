package com.xuecheng.system.controller;

import com.xuecheng.PageResult;
import com.xuecheng.system.pojo.Dictionary;
import com.xuecheng.system.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/dictionary/all")
    public List<Dictionary> queryAll(){
           return dictionaryService.queryAll();
    }

    @GetMapping("/dictionary/code/{code}")
    public Dictionary getByCode(@PathVariable String code){
        return dictionaryService.getByCode(code);
    }
}
