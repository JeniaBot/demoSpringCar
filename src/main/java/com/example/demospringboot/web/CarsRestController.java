package com.example.demospringboot.web;

import com.example.demospringboot.domain.Cars;
import com.example.demospringboot.domain.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarsRestController {


    private final CarsRepository repository;

    public CarsRestController(CarsRepository repository) {
        this.repository = repository;
    }

    //Операция сохранения юзера в базу данных
    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public Cars saveBook(@RequestBody Cars cars) {
        cars.setOriginalColor(true);
        return repository.save(cars);
    }

    //Получение списка юзеров
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Cars> getAllBooks() {

        return (Collection<Cars>) repository.findAll();
    }

    @GetMapping("/cars/origColor")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Cars> getAll() {

        return (Collection<Cars>) repository.findCarsByIdAndColorIsTrue();
    }

    //Получения юзера по id
    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cars getBookById(@PathVariable long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cars with id = Not found"));
    }

    //Обновление юзера
    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cars refreshEmployee(@PathVariable("id") long id, @RequestBody Cars cars) {

        return repository.findById(id)
                .map(entity -> {
                    entity.setColor(cars.getColor());
                    entity.setModel(cars.getModel());
                    entity.setVin(cars.getVin());
                    entity.setColor(cars.getColor());
                    entity.setOriginalColor(false);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Car with id = Not found"));
    }

    //Удаление по id
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBookById(@PathVariable long id) {
        repository.deleteById(id);
    }

    //Удаление всех юзеров
    @DeleteMapping("/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllBooks() {
        repository.deleteAll();
    }
}
