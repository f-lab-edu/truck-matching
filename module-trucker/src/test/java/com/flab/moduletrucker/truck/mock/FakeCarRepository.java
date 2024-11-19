package com.flab.moduletrucker.truck.mock;

import com.flab.moduletrucker.truck.domain.Car;
import com.flab.moduletrucker.truck.repository.CarRepository;

import java.util.Optional;

public class FakeCarRepository implements CarRepository {

    @Override
    public Car save(Car car) {
        return null;
    }

    @Override
    public Optional<Car> findById(String carId) {
        return Optional.empty();
    }
}
