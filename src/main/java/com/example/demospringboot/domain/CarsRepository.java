package com.example.demospringboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars, Long> {
//List<Cars> findCarsByIdAndOAndOriginalColorIsTrue();
List<Cars> findCarsByIdAndOAndOriginalColor();
}
