package com.example.java_test.design.strategy.command;

public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;

    }

    @Override
    public void execute() {
        light.open();

    }
}
