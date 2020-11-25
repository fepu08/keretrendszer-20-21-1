import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.dao.json.CarDAOJSON;
import uni.eszterhazy.keretrendszer.exceptions.*;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;
import uni.eszterhazy.keretrendszer.service.CarService;
import uni.eszterhazy.keretrendszer.service.impl.CarServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class Console {
    public static void main(String[] args) throws PriceNegative, ModelCannotBeEmpty, ColorCannotBeEmpty, BadProductionDate, IOException {
        CarDAO dao = new CarDAOJSON("data.json");
        CarService service = new CarServiceImpl(dao);

        Car car = new Car();
        car.setPrice(100000);
        car.setModel("Fepu gx1000");
        car.setColor("green");
        car.setFuelType(FuelType.DIESEL);
        car.setProductionDate(LocalDate.of(2000, 12, 12));
        try {
            service.addCar(car);
        } catch (CarAlreadyAdded carAlreadyAdded) {
            carAlreadyAdded.printStackTrace();
        }
        car.setId(UUID.randomUUID().toString());
        car.setPrice(100000);
        car.setModel("Fepu gx2000");
        car.setColor("green");
        car.setFuelType(FuelType.DIESEL);
        car.setProductionDate(LocalDate.of(2000, 12, 12));
        try {
            service.addCar(car);
        } catch (CarAlreadyAdded carAlreadyAdded) {
            carAlreadyAdded.printStackTrace();
        }

        System.out.println(service.getAllCar());
        System.out.println(service.averagePrice());
    }
}