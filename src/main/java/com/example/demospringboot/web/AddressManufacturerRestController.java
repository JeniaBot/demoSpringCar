package com.example.demospringboot.web;

import com.example.demospringboot.domain.AddressManufacturer;
import com.example.demospringboot.domain.AddressManufacturerRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressManufacturerRestController {

    private final AddressManufacturerRepository repository;

    public AddressManufacturerRestController(AddressManufacturerRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressManufacturer saveAddress(@RequestBody AddressManufacturer cars) {

        return repository.save(cars);
    }


    @GetMapping("/addresses")
    @ResponseStatus(HttpStatus.OK)
    public List<AddressManufacturer> getAllAddresses() {

        return repository.findAll();
    }

    @GetMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressManufacturer getAddressById(@PathVariable long id) {

        AddressManufacturer address = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + id));

        return address;
    }

    //Обновление адреса по id
    @PutMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressManufacturer updateAddress(@PathVariable("id") long id, @RequestBody AddressManufacturer address) {

        return repository.findById(id)
                .map(entity -> {
                    entity.setCity(address.getCity());
                    entity.setCountry(address.getCountry());
                    entity.setZipCode(address.getZipCode());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + id));
    }



    @PatchMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAddressById(@PathVariable long id) {
        repository.findById(id)
                .map(address -> {
                    return repository.save(address);
                })
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + id));
    }


    @DeleteMapping("/addresses")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllAddress() {
        repository.deleteAll();
    }
}