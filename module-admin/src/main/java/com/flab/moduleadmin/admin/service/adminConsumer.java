package com.flab.moduleadmin.admin.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class adminConsumer {

    @KafkaListener(topics = "shipment", groupId = "group_1")
    public void listen(String data) {
        System.out.println("data = " + data);
    }
}
