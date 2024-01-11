package com.example.democrud1.design_patter.bridge;

public class GreenCircle implements Draw {
    @Override
    public void drawCircle(int x, int y) {
        System.out.println("Drawing[ color: green, x: " + x + ", " + y + "]");
    }
}
