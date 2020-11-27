import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.dao.json.CarDAOJSON;
import uni.eszterhazy.keretrendszer.dao.mongo.CarDAOMongo;
import uni.eszterhazy.keretrendszer.dao.relational.CarDaoRelational;
import uni.eszterhazy.keretrendszer.service.CarService;
import uni.eszterhazy.keretrendszer.service.impl.CarServiceImpl;

import java.io.IOException;
import java.net.UnknownHostException;

@Configuration
@ComponentScan("uni.eszterhazy.keretrendszer.controller")
public class MyConfig {
    @Bean(name= "mongoDbDAO")
    public CarDAO carMongoDB(){
        try{
            return new CarDAOMongo("mongodb://localhost:27017", "car_shop", "cars");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Qualifier("jsonDbDAO")
    @Bean
    public CarDAO jsondb(){
        try{
            return new CarDAOJSON("Car.json");
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public CarService carService( CarDAO mongoDbDAO){
        return new CarServiceImpl(mongoDbDAO);
    }

    /*RELATIONAL STUFFS
    @Bean(name="relationalDbDAO")
    public CarDAO carRelationalDB() {
        return new CarDaoRelational();
    }

    @Bean
    public CarService carService(CarDAO relationalDbDAO){
        return new CarServiceImpl(relationalDbDAO);
    }

    @Qualifier("jsonDbDAO")
    @Bean
    public CarDAO jsondb(){
        try{
            return new CarDAOJSON("Car.json");
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }*/
}
