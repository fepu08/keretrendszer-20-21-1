package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uni.eszterhazy.keretrendszer.exceptions.CarAlreadyAdded;
import uni.eszterhazy.keretrendszer.exceptions.CarNotFound;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;
import uni.eszterhazy.keretrendszer.service.CarService;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/rest")
public class RESTCarController {
    @Autowired
    CarService carService;

    /*@GetMapping(value = "cars")
    public Collection<Car> getAllCar(){
            return carService.getAllCar();
    }*/

    @GetMapping(value = "car/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public Car getCarById(@PathVariable(name="id") String id) throws CarNotFound {
        return carService.getCarById(id);
    }

    /*@GetMapping(value = "cars/{fuelType}")
    public Collection<Car> getAllCarOfFuelType(@PathVariable FuelType fuelType){
        return carService.getAllCarByFuelType(fuelType);
    }*/

    @GetMapping(value = "cars")
    public Collection<Car> getAllCarOfFuelType(@RequestParam(value = "fuelType", required = false) FuelType fuelType,
                                               @RequestParam(value = "minPrice", required = false) Double minPrice){
        if(fuelType != null && minPrice == null){
            return carService.getAllCarByFuelType(fuelType);
        }
        if(fuelType == null && minPrice == null){
            return carService.getAllCar();
        }
        //TODO: also kettot servicebe atvinni
        if(fuelType != null && minPrice != null){
            return carService.getAllCarByFuelType(fuelType).stream().filter(d -> d.getPrice() > minPrice).collect(Collectors.toList());
        }
        if(fuelType == null && minPrice != null){
            return carService.getAllCar().stream().filter(d -> d.getPrice() > minPrice).collect(Collectors.toList());
        }
        return carService.getAllCar();
    }

    @PostMapping(value = "cars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addCar(@RequestBody Car car) throws CarAlreadyAdded {
        System.out.println("add: " + car);
        carService.addCar(car);
        return "New car added with ID: " + car.getId();
    }

}
