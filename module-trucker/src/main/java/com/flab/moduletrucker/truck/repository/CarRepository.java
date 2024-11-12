package com.flab.moduletrucker.truck.repository;

import com.flab.moduletrucker.truck.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
