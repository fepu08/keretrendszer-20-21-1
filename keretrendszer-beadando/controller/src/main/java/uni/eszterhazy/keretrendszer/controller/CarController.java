package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import uni.eszterhazy.keretrendszer.service.CarService;

@Component("carCont")
public class CarController {

    @Autowired
    @Qualifier("carService")
    CarService service;

    public void printAll() {
        System.out.println(service.getAllCar());
    }

    void sayHi(){

    }
}
