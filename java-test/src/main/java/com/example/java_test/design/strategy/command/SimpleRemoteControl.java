package com.example.java_test.design.strategy.command;


/**
 * 遥控器
 */
public class SimpleRemoteControl {

    Command command;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}
