package com.flab.moduletrucker.truck.service;

import com.flab.moduletrucker.truck.domain.Car;
import com.flab.moduletrucker.truck.dto.TruckerDTO;
import com.flab.moduletrucker.truck.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Async(value = "taskExecutor")
    public String createCar(TruckerDTO.CarRequest req) {
        Car car = req.dtoToDomain(req);
        Car save = carRepository.save(car);
        return save.getCarId();
    }

    @Async(value = "taskExecutor")
    public TruckerDTO.CarInfo getCar(String carId) {
        Optional<Car> byId = carRepository.findById(carId);
        if (byId.isPresent()) {
            Car car = byId.get();
            return new TruckerDTO.CarInfo(car);
        } else {
            throw new RuntimeException("car not found");
        }
    }
}
