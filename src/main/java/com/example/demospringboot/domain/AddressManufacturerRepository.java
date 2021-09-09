package com.example.demospringboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressManufacturerRepository extends JpaRepository<AddressManufacturer, Long> {

    List<AddressManufacturer> findAddressByZipCode(String zip);
}