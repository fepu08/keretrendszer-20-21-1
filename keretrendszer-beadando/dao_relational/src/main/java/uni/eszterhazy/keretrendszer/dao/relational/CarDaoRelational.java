package uni.eszterhazy.keretrendszer.dao.relational;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.hibernate.query.Query;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
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

    public void updateCar(Car car) {

    }

    public void deleteCar(Car car) {

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
