package com.math12.log_generate_service.business.service;

import com.math12.log_generate_service.business.topics.kafka.producer.SendLogProducer;
import generatelogs.GenerateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SendLogService {

    @Autowired
    private SendLogProducer producer;

    @Scheduled(fixedRate = 5000)
    public void sendLogForTopic(){
        producer.sendEventLog(GenerateLog.getLog());
    }
}