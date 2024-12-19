package com.virajkale.CarMngtSystem.Service;

import com.virajkale.CarMngtSystem.Entity.Car;
import com.virajkale.CarMngtSystem.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Car updateCar(Long id, Car carDetails) {
        Car car = findCarById(id).orElseThrow(() -> new RuntimeException("No car found for the given ID."));
        car.setName(carDetails.getName());
        car.setModel(carDetails.getModel());
        car.setYear(carDetails.getYear());
        car.setPrice(carDetails.getPrice());
        car.setColor(carDetails.getColor());
        car.setFuelType(carDetails.getFuelType());
        return carRepository.save(car);
    }

    public List<Car> searchCars(String keyword) {
//        return carRepository.GlobalSearch(keyword, keyword, keyword, keyword, parseIntOrNull(keyword));

            return carRepository.findByNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrColorContainingIgnoreCaseOrFuelTypeContainingIgnoreCaseOrYear(
                    keyword, keyword, keyword, keyword, parseIntOrNull(keyword));

    }

    private Integer parseIntOrNull(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Page<Car> getCarsWithPaginationAndSorting(int page, int size, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(page, size, sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
        return carRepository.findAll(pageable);
    }
}
