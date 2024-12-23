package com.flab.moduleshipper.shipment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.moduleshipper.shipment.domain.Shipment;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShipmentProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendShipment(final Shipment shipment) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(shipment);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        kafkaTemplate.send("shipment", jsonString);
    }
}
