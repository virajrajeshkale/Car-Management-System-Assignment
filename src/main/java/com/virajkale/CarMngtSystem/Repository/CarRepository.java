package com.virajkale.CarMngtSystem.Repository;

import com.virajkale.CarMngtSystem.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> GlobalSearch(String name, String model, String color, String fuelType, Integer year);

}
