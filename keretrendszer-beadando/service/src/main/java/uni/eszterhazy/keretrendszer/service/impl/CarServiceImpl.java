package uni.eszterhazy.keretrendszer.service.impl;

import org.apache.log4j.Logger;
import org.graalvm.compiler.lir.CompositeValue;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;
import uni.eszterhazy.keretrendszer.service.CarService;
import uni.eszterhazy.keretrendszer.exceptions.CarAlreadyAdded;
import uni.eszterhazy.keretrendszer.exceptions.CarNotFound;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class CarServiceImpl implements CarService {
    Logger logger = Logger.getLogger(this.getClass());
    private CarDAO dao;

    public CarServiceImpl(CarDAO dao){
        this.dao = dao;
    }

    public void addCar(Car car) throws IOException, CarAlreadyAdded {
        dao.createCar(car);
    }

    public Collection<Car> getAllCar() {
        Collection<Car> result = dao.readAllCar();
        logger.info("There are " + result.size() + " car(s) in the database");
        return result;
    }

    public void getCarById(String id) throws CarNotFound {
        dao.readCar(id);
    }

    public void updateCar(Car car) {
        dao.updateCar(car);
    }

    public void removeCar(Car car) {
        dao.deleteCar(car);
    }

    public Collection<Car> getAllCarByFuelType(FuelType fuelType) {
        return dao.readAllCar();
    }

    public double averagePrice() {
        Collection<Car> cars = getAllCar();
        /*double sum = 0;
        for(Car c : cars){
            sum += c.getPrice();
        }
        return sum / cars.size();*/
        return cars.stream().mapToDouble(c -> c.getPrice()).average().getAsDouble();
    }

    public Map<FuelType, Double> averagePriceByFuelType(FuelType fuelType) {
        return null;
    }
}
