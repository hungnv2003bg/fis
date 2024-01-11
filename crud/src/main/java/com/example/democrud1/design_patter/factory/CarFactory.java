package com.example.democrud1.design_patter.factory;

public class CarFactory {
    public void viewCar(String carType) {
        Car car;
        if (carType.equalsIgnoreCase("BMW")) {
            car = new BMW();
            car.view();
        } else if (carType.equalsIgnoreCase("PORSCHE")) {
            car = new Porsche();
            car.view();
        }
    }
}
