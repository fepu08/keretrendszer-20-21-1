package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;
import uni.eszterhazy.keretrendszer.exceptions.CarAlreadyAdded;
import uni.eszterhazy.keretrendszer.exceptions.CarNotFound;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public interface CarService {
    void addCar(Car car) throws IOException, CarAlreadyAdded;
    Collection<Car> getAllCar();
    void getCarById(String id) throws CarNotFound;
    void updateCar(Car car);
    void removeCar(Car car);
    Collection<Car> getAllCarByFuelType(FuelType fuelType);
    double averagePrice();
    Map<FuelType, Double> averagePriceByFuelType(FuelType fuelType);
}
