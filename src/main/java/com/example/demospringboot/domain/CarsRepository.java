package com.example.demospringboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars, Long> {

    List<Cars> findByVin(String vin);


}
