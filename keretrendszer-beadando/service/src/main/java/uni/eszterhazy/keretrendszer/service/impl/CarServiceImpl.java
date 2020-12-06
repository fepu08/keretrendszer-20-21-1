package uni.eszterhazy.keretrendszer.service.impl;

import org.apache.log4j.Logger;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;
import uni.eszterhazy.keretrendszer.service.CarService;
import uni.eszterhazy.keretrendszer.exceptions.CarAlreadyAdded;
import uni.eszterhazy.keretrendszer.exceptions.CarNotFound;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {
    Logger logger = Logger.getLogger(this.getClass());
    private CarDAO dao;

    public CarServiceImpl(CarDAO dao){
        this.dao = dao;
    }

    @Override
    public void addCar(Car car) throws CarAlreadyAdded {
        dao.createCar(car);
    }

    @Override
    public Collection<Car> getAllCar() {
        Collection<Car> result = dao.readAllCar();
        logger.info("There are " + result.size() + " car(s) in the database");
        return result;
    }

    @Override
    public Car getCarById(String id) throws CarNotFound {
        return dao.readCar(id);
    }

    @Override
    public void updateCar(Car car) {
        dao.updateCar(car);
    }

    @Override
    public void removeCar(Car car) {
        dao.deleteCar(car);
    }

    @Override
    public Collection<Car> getAllCarByFuelType(FuelType fuelType) {
        Collection<Car> cars = getAllCar();
        Collection<Car> result = cars.stream().filter(c -> c.getFuelType() == fuelType).collect(Collectors.toList());
        return result;
    }

    @Override
    public double averagePrice() {
        Collection<Car> cars = getAllCar();
        /*double sum = 0;
        for(Car c : cars){
            sum += c.getPrice();
        }
        return sum / cars.size();*/
        return cars.stream().mapToDouble(c -> c.getPrice()).average().getAsDouble();
    }

    @Override
    public Map<FuelType, Double> averagePriceByFuelType(FuelType fuelType) {
        return null;
    }
}
