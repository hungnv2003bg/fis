package com.example.democrud1.design_patter.singletonpatter;

public class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Helo Singleton_pattern");
    }
}
