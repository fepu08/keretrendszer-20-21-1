package uni.eszterhazy.keretrendszer.dao;

import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;

import java.util.Collection;

public interface carDAO {
    void createCar(Car car);
    Collection<Car> readAllCar();
    Car readCar();
    void updateCar(Car car);
    void deleteCar(Car car);
    Collection<Car> readAllCarByFuelType(FuelType fuelType);
}
