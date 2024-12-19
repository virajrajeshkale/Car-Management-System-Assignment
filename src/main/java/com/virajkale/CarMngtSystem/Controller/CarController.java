package com.virajkale.CarMngtSystem.Controller;

import com.virajkale.CarMngtSystem.Entity.Car;


import com.virajkale.CarMngtSystem.Service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
class CarController {

    @Autowired
    private CarService carService;


    @PostMapping
    public ResponseEntity<?> createCar(@Valid @RequestBody Car car) {
        if (car.getName() == null || car.getModel() == null || car.getYear() == 0 || car.getPrice() == 0.0 || car.getColor() == null || car.getFuelType() == null) {
            return new ResponseEntity<>("All parameters are required to create a new car.", HttpStatus.BAD_REQUEST);
        }
        Car savedCar = carService.saveCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<?> getAllCars(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "id") String sortBy,
                                        @RequestParam(defaultValue = "asc") String sortDir) {
        Page<Car> carsPage = carService.getCarsWithPaginationAndSorting(page, size, sortBy, sortDir);
        if (carsPage.isEmpty()) {
            return new ResponseEntity<>("There are no car details available.", HttpStatus.OK);
        }
        return new ResponseEntity<>(carsPage, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.findCarById(id);
        if (car.isEmpty()) {
            return new ResponseEntity<>("There is no car for the given ID.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car.get(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @Valid @RequestBody Car carDetails) {
        try {
            Car updatedCar = carService.updateCar(id, carDetails);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        Optional<Car> car = carService.findCarById(id);
        if (car.isEmpty()) {
            return new ResponseEntity<>("No car found for the given ID.", HttpStatus.NOT_FOUND);
        }
        carService.deleteCar(id);
        return new ResponseEntity<>("Car deleted successfully.", HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search")
    public ResponseEntity<?> searchCars(@RequestParam String keyword) {
        List<Car> results = carService.searchCars(keyword);
        if (results.isEmpty()) {
            return new ResponseEntity<>("No cars match the search criteria.", HttpStatus.OK);
        }
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
