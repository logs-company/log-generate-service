package com.math12.log_generate_service.business.topics.kafka.producer;

import com.math12.log_generate_service.business.converter.ConverterJson;
import dtolog.LogDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendLogProducer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ConverterJson converter;

    @Value("${spring.kafka.producer.send.log.topic}")
    private String sendLog;

    public void sendEventLog(LogDTO logDTO){
        try {
            String json = converter.convertToJson(logDTO);
            kafkaTemplate.send(sendLog, json);
            log.info("sendEventLog: tópico enviado!");
        }catch (Exception e){
            log.error("sendEventLog: erro ao enviar o topico {}", sendLog);
        }
    }
}