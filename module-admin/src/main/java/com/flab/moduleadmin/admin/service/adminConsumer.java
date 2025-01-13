package com.flab.moduleadmin.admin.service;

import com.flab.shipment.kafka.Shipment.ShipmentMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class adminConsumer {

    @KafkaListener(topics = "shipmentMessage", groupId = "group_1")
    public void listen(byte[] data) {
        try {
            ShipmentMessage shipmentMessage = ShipmentMessage.parseFrom(data);
            String memberId = shipmentMessage.getMemberId();
            System.out.println("memberId = " + memberId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
