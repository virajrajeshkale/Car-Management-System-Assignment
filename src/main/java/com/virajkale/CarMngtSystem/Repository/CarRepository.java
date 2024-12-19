package com.virajkale.CarMngtSystem.Repository;

import com.virajkale.CarMngtSystem.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
