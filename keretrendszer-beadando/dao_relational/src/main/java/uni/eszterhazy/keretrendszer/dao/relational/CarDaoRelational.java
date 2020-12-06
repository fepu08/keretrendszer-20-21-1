package uni.eszterhazy.keretrendszer.dao.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.exceptions.*;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.FuelType;

import java.util.Collection;

public class CarDaoRelational implements CarDAO {
    private static SessionFactory factory;

    public CarDaoRelational() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void createCar(Car car) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(car);
        tx.commit();
        session.close();
    }

    public Collection<Car> readAllCar() {
        Session session = factory.openSession();
        Collection<Car> result = session.createQuery("FROM Car").list();
        return result;
    }

    public Car readCar(String id) {
        Session session = factory.openSession();
        Car result = session.get(Car.class, id);
        return result;
    }

    public void updateCar(Car car) throws CarNotFound, ModelCannotBeEmpty, ColorCannotBeEmpty, BadProductionDate, PriceNegative {
        Session session = factory.openSession();
        if(session.get(Car.class, car.getId()) == null){
            throw new CarNotFound(car.getId());
        }
        Transaction tx=session.beginTransaction();
        Car object = session.get(Car.class,car.getId());
        object.setId(car.getId());
        object.setModel(car.getModel());
        object.setColor(car.getColor());
        object.setProductionDate(car.getProductionDate());
        object.setFuelType(car.getFuelType());
        object.setExtras(car.getExtras());
        object.setPrice(car.getPrice());
        session.update(object);
        tx.commit();
        session.close();
    }

    public void deleteCar(String id) throws CarNotFound {
        Session session = factory.openSession();
        if(session.get(Car.class, id) == null){
            throw new CarNotFound(id);
        }
        Transaction tx = session.beginTransaction();
        Car obj = session.get( Car.class, id);
        session.delete(obj);
        tx.commit();
        session.close();
    }

    public Collection<Car> readAllCarByFuelType(FuelType fuelType) {
        Session session = factory.openSession();
        String hql = "From Car Where fuelType = :fuelType";
        Query q = session.createQuery(hql);
        q.setParameter("fuelType", fuelType);
        Collection result = q.list();
        return result;
    }
}
