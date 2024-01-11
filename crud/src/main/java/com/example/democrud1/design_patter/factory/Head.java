package com.example.democrud1.design_patter.factory;

public class Head {
    public void viewCar() {
        CarFactory carFactory = new CarFactory();
        carFactory.viewCar("BMW");
        carFactory.viewCar("Porsche");
    }
}
