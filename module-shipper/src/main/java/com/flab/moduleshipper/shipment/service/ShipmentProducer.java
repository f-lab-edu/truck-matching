package com.flab.moduleshipper.shipment.service;

import com.flab.moduleshipper.shipment.domain.Shipment;
import com.flab.shipment.kafka.Shipment.ShipmentMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShipmentProducer {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public void sendShipment(final Shipment shipment) {
        ShipmentMessage build = ShipmentMessage.newBuilder()
                .setShipmentId(shipment.getShipmentId())
                .setMemberId(shipment.getMemberId())
                .build();
        kafkaTemplate.send("shipmentMessage", build.toByteArray());
    }
}
