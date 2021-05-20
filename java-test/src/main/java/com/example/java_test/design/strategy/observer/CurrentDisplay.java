package com.example.java_test.design.strategy.observer;

public class CurrentDisplay implements Observer {

    private float temperature;
    private float humidity;
    private Subject weatherData;

   public CurrentDisplay(Subject weatherData){
       this.weatherData=weatherData;
       weatherData.registerObserver(this);

    }
    @Override
    public void update(float temp, float humidity, float pressure) {
       this.temperature=temp;
       this.humidity=humidity;
       display();

    }

    public void display(){
        System.out.println("这是测试的输出 "+temperature+"这是另一个输出"+humidity);
    }
}
