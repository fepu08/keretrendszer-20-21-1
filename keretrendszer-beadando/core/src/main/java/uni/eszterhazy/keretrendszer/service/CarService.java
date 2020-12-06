package uni.eszterhazy.keretrendszer.service;

import uni.eszterhazy.keretrendszer.exceptions.*;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public interface CarService {
    void addCar(Car car) throws CarAlreadyAdded;
    Collection<Car> getAllCar();
    Car getCarById(String id) throws CarNotFound;
    void updateCar(Car car) throws ModelCannotBeEmpty, PriceNegative, BadProductionDate, CarNotFound, ColorCannotBeEmpty;
    void removeCar(String id) throws CarNotFound;

    Collection<Car> getAllCarByFuelType(FuelType fuelType);
    double averagePrice();
    Map<FuelType, Double> averagePriceByFuelType(FuelType fuelType);
}
