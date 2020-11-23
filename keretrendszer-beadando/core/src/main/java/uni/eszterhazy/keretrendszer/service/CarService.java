package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;

import java.util.Collection;
import java.util.Map;

public interface CarService {
    void addCar(Car car);
    Collection<Car> getAllCar();
    void getCarById(String id);
    void updateCar(Car car);
    void removeCar(Car car);
    Collection<Car> getAllCarByFuelType(FuelType fuelType);
    double averagePrice();
    Map<FuelType, Double> averagePriceByFuelType(FuelType fuelType);
}
