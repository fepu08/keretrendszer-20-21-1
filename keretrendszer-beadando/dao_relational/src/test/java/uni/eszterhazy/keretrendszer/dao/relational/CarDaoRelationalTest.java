package uni.eszterhazy.keretrendszer.dao.relational;

import org.junit.Test;
import uni.eszterhazy.keretrendszer.dao.CarDAO;
import uni.eszterhazy.keretrendszer.exceptions.BadProductionDate;
import uni.eszterhazy.keretrendszer.exceptions.ColorCannotBeEmpty;
import uni.eszterhazy.keretrendszer.exceptions.ModelCannotBeEmpty;
import uni.eszterhazy.keretrendszer.exceptions.PriceNegative;
import uni.eszterhazy.keretrendszer.model.Car;
import uni.eszterhazy.keretrendszer.model.Extra;
import uni.eszterhazy.keretrendszer.model.FuelType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarDaoRelationalTest {
    @Test
    public void test() throws ColorCannotBeEmpty, PriceNegative, ModelCannotBeEmpty, BadProductionDate {
        CarDAO dao = new CarDaoRelational();
        Car car = new Car();
        car.setColor("green");
        car.setFuelType(FuelType.DIESEL);
        car.setModel("Opel");
        car.setPrice(200000);
        car.setProductionDate(LocalDate.of(2001, 5, 20));
        Extra extra1 = new Extra("Leather upholstery", 60000);
        Extra extra2 = new Extra("Heated seats", 40000);
        Extra extra3 = new Extra("Heated steering wheel", 20000);
        List extras = new ArrayList();
        extras.add(extra1);
        extras.add(extra2);
        extras.add(extra3);
        //car.setExtras(extras);
        //dao.createCar(car);

        //System.out.println(dao.readAllCar().toString());
        //System.out.println(dao.readAllCarByFuelType(FuelType.DIESEL));
        System.out.println(dao.readCar("1e6788c0-bca6-4d8a-9225-58dce27119c2"));
    }
}