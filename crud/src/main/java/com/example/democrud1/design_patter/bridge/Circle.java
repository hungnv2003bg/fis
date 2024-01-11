package com.example.democrud1.design_patter.bridge;

public class Circle extends Shape {
    private int x, y;

    public Circle(int x, int y, Draw draw) {
        super(draw);
        this.x = x;
        this.y = y;
    }

    public void draw() {
        draw.drawCircle(x, y);
    }
}
