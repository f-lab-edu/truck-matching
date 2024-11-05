package com.flab.moduleshipper.shipment.repository;

import com.flab.moduleshipper.shipment.domain.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, String> {

}
