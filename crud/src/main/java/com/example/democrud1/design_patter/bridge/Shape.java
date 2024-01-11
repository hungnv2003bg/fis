package com.example.democrud1.design_patter.bridge;

public abstract class Shape {
    protected Draw draw;

    protected Shape(Draw draw) {
        this.draw = draw;
    }

    public abstract void draw();
}