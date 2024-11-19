package com.flab.moduletrucker.truck.repository;

import com.flab.moduletrucker.truck.domain.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {

    private final CarJpaRepository carJpaRepository;

    @Override
    public Car save(Car car) {
        return carJpaRepository.save(car);
    }

    @Override
    public Optional<Car> findById(String carId) {
        return carJpaRepository.findById(carId);
    }
}
