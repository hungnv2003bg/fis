package com.example.democrud1.design_patter.singletonpatter;

public class SingleMain {
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}
