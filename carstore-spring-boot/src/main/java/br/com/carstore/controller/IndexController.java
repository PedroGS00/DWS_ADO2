package br.com.carstore.controller;

import br.com.carstore.model.Car;
import br.com.carstore.model.CarDTO;
import br.com.carstore.model.CarResponseEntity;
import br.com.carstore.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    private CarService carService;

    public IndexController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/cars")
    public ResponseEntity<CarResponseEntity> home() {

        List<CarDTO> cars = carService.findAll();

        CarResponseEntity carResponseEntity = new CarResponseEntity(cars);

        return ResponseEntity.ok(carResponseEntity);

    }

    @PostMapping("/api/create-car")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {

        System.out.printf("Car name: " + car.getName());
        System.out.println("Car color: " + car.getColor());

        return ResponseEntity.ok(car);

    }

}
