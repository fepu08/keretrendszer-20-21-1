package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;
import uni.eszterhazy.keretrendszer.exceptions.CarAlreadyAdded;
import uni.eszterhazy.keretrendszer.exceptions.CarNotFound;

import java.io.IOException;
import java.util.Collection;

public interface CarDAO {
    void createCar(Car car) throws IOException, CarAlreadyAdded;
    Collection<Car> readAllCar();
    Car readCar(String id) throws CarNotFound;
    void updateCar(Car car);
    void deleteCar(Car car);
    Collection<Car> readAllCarByFuelType(FuelType fuelType);
}
