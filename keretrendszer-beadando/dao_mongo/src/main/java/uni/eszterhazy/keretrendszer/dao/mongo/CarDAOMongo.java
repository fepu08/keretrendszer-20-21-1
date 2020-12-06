package uni.eszterhazy.keretrendszer.dao.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.util.JSON;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.exceptions.CarAlreadyAdded;
import uni.eszterhazy.keretrendszer.exceptions.CarNotFound;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;

public class CarDAOMongo implements CarDAO {
    private MongoClient client;
    private DB db;
    private DBCollection collection;

    public CarDAOMongo(String uri, String database, String collection) throws  UnknownHostException {
        this.client = new MongoClient(new MongoClientURI(uri));
        this.db = client.getDB(database);
        this.collection = db.getCollection(collection);
    }

    public void createCar(Car car) throws CarAlreadyAdded{
        try {
            readCar(car.getId());
        } catch (CarNotFound carNotFound) {
            collection.insert(CarAdapter.CarToDBObject(car));
            return;
        }
        throw new CarAlreadyAdded(car.getId());
    }

    public Collection<Car> readAllCar() {
        DBCursor cursor = collection.find(new BasicDBObject(), new BasicDBObject().append("_id", 0));
        Collection<Car> result = new ArrayList<>();
        cursor.forEach(o -> {
            result.add(CarAdapter.dbObjectToCar(o));
        });
        return result;
    }

    public Car readCar(String id) throws CarNotFound {
        DBCursor cursor = collection.find(new BasicDBObject().append("id", id), new BasicDBObject().append("_id", 0));
        if(cursor.length() == 0){
            throw new CarNotFound(id);
        }
        return CarAdapter.dbObjectToCar(cursor.one());
    }

    public void updateCar(Car car) {

    }

    public void deleteCar(Car car) {

    }

    public Collection<Car> readAllCarByFuelType(FuelType fuelType) {
        return null;
    }
}
