package com.math12.log_generate_service.controller;

import com.math12.log_generate_service.business.service.SendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/send/log")
@RestController
public class SendLogController {

    @Autowired
    private SendLogService service;

    @GetMapping
    public ResponseEntity<String> sendLog(){
        service.sendLogForTopic();
        return ResponseEntity.ok("Topic Submitted");
    }
}
