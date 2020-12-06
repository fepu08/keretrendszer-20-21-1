package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.exceptions.*;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;

import java.io.IOException;
import java.util.Collection;

public interface CarDAO {
    void createCar(Car car) throws CarAlreadyAdded;
    Collection<Car> readAllCar();
    Car readCar(String id) throws CarNotFound;
    void updateCar(Car car) throws CarNotFound, ModelCannotBeEmpty, ColorCannotBeEmpty, BadProductionDate, PriceNegative;
    void deleteCar(String id) throws CarNotFound;
    Collection<Car> readAllCarByFuelType(FuelType fuelType);
}
