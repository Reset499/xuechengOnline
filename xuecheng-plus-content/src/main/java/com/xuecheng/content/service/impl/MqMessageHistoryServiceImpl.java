package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.content.po.MqMessageHistory;
import com.xuecheng.content.mapper.MqMessageHistoryMapper;
import com.xuecheng.content.service.MqMessageHistoryService;
import org.springframework.stereotype.Service;

@Service
public class MqMessageHistoryServiceImpl extends ServiceImpl<MqMessageHistoryMapper, MqMessageHistory> implements MqMessageHistoryService {
}
