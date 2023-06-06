package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.content.entity.MqMessage;
import com.xuecheng.content.mapper.MqMessageMapper;
import com.xuecheng.content.service.MqMessageService;
import org.springframework.stereotype.Service;

@Service
public class MqMessageServiceImpl extends ServiceImpl<MqMessageMapper, MqMessage> implements MqMessageService {
}
