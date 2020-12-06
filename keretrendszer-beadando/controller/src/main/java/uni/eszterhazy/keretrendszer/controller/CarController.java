package uni.eszterhazy.keretrendszer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uni.eszterhazy.keretrendszer.exceptions.CarAlreadyAdded;
import uni.eszterhazy.keretrendszer.exceptions.CarNotFound;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;
import uni.eszterhazy.keretrendszer.service.CarService;

import java.io.IOException;

@Controller
public class CarController {

    @Autowired
    @Qualifier("carService")
    CarService service;

    @ModelAttribute(value = "car")
    public Car create(){
        return new Car();
    }

    // Régebbi típusú megoldás
    //@GetMapping(value = "/cars")
    // ModelAndView -> mert szeretnénk a View-nek átadni az adatot
    /*public ModelAndView getCars() {
        ModelAndView mav = new ModelAndView("carslist.jsp");
        System.out.println(service.getAllCar());
        mav.addObject("cars", service.getAllCar());
        return mav;
    }*/

    // Ez az ajánlott megoldás
    @GetMapping(value = "/cars")
    public String getCars(Model model){
        model.addAttribute("cars", service.getAllCar());
        return "carslist.jsp";
    }

    @GetMapping(value = "/car/{id}")
    public String getCarById(@PathVariable String id, Model model) throws CarNotFound {
        //FIXME: LEHET HIBÁS LESZ!!!
        model.addAttribute("car", service.getCarById(id));
        return "cardetails.jsp";
    }

    @GetMapping(value = "addCar")
    public String addCarForm(Model model){
        model.addAttribute("fuelTypes", FuelType.values());
        return "carForm.jsp";
    }

    @PostMapping(value = "addCar")
    public String addCar(@ModelAttribute("cars") Car car, Model model){
        System.out.println(car);
        try {
            service.addCar(car);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CarAlreadyAdded carAlreadyAdded) {
            carAlreadyAdded.printStackTrace();
        }
        return "redirect:car/"+ car.getId();
    }

}
