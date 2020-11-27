package uni.eszterhazy.keretrendszer.dao.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import uni.eszterhazy.keretrendszer.model.Car;

import java.io.IOException;

public class CarAdapter {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public static Car dbObjectToCar(DBObject Car){
        try {
            Car obj = mapper.readValue(Car.toString(),Car.class);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static DBObject CarToDBObject(Car Car){
        String CarString= "";
        try {
            CarString = mapper.writeValueAsString(Car);
            BasicDBObject obj = mapper.readValue(CarString, BasicDBObject.class);
            return obj;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BasicDBObject();
    }
}
