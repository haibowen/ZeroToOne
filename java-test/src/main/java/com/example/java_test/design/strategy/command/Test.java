package com.example.java_test.design.strategy.command;


/**
 * 遥控器的测试
 */
public class Test {

    public static void main(String[] args) {

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonPressed();
    }


}
