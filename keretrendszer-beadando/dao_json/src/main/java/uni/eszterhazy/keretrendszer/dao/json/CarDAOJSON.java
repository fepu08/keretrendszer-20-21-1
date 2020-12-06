package uni.eszterhazy.keretrendszer.dao.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;
import uni.eszterhazy.keretrendszer.exceptions.CarAlreadyAdded;
import uni.eszterhazy.keretrendszer.exceptions.CarNotFound;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CarDAOJSON implements CarDAO {
    //This will save into a file
    File jsonFile;
    ObjectMapper mapper; // for mapping
    public CarDAOJSON(String jsonFilePath) throws IOException {
        jsonFile = new File(jsonFilePath);
        if(!jsonFile.exists()){
            jsonFile.createNewFile();
            FileWriter writer = new FileWriter(jsonFile);
            writer.write("[]");
            writer.flush();
            writer.close();
        }
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // for local date
    }

    public void createCar(Car car) throws CarAlreadyAdded {
        Collection<Car> cars = readAllCar();
        Car result = null;
        try{
            result = readCar(car.getId());
        } catch(CarNotFound carNotFound){
            cars.add(car);
            try {
                mapper.writeValue(jsonFile, cars);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new CarAlreadyAdded(car.getId());
    }

    public Collection<Car> readAllCar() {
        Collection<Car> cars = new ArrayList<Car>();
        TypeReference type = new TypeReference<ArrayList<Car>>() {};
        try {
            cars = mapper.readValue(jsonFile, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public Car readCar(String id) throws CarNotFound {
        Collection<Car> cars = readAllCar();
        for (Car car : cars){
            if(car.getId().equalsIgnoreCase(id)){
                return car;
            }
        }
        throw new CarNotFound(id);
    }

    public void updateCar(Car car) {
        //TODO
    }

    @Override
    public void deleteCar(String id) throws CarNotFound {
        //TODO
    }

    public Collection<Car> readAllCarByFuelType(FuelType fuelType) {
        //TODO
        return null;
    }
}
