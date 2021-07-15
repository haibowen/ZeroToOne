package com.example.annotation;


@Factory(id="Rectangle",type = IShape.class)
public class Rectangle implements IShape {
    @Override
    public void draw() {
        System.out.println("Draw a  Rectangle");
    }
}
