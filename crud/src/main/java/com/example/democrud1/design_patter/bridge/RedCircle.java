package com.example.democrud1.design_patter.bridge;

public class RedCircle implements Draw {
    @Override
    public void drawCircle(int x, int y) {
        System.out.println("Drawing[ color: red, x: " + x + ", " + y + "]");
    }
}
