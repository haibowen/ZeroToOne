package com.example.java_test.design.strategy.observer;

public class Test {

    public static void main(String[] args) {
        //主题
        WeatherData weatherData=new WeatherData();
        //订阅者
        CurrentDisplay currentDisplay=new CurrentDisplay(weatherData);
        weatherData.setMeasurements(20,30,40);
    }
}
