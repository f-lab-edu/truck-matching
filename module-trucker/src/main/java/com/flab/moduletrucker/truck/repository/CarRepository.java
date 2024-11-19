package com.flab.moduletrucker.truck.repository;

import com.flab.moduletrucker.truck.domain.Car;

import java.util.Optional;

public interface CarRepository {
    
    Car save(Car car);

    Optional<Car> findById(String carId);
}
