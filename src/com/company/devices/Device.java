package com.company.devices;

public abstract class Device {
    String producer;
    String model;
    Integer yearOfProduction;

    public String toString(){

        return producer+" "+model+" "+yearOfProduction;
    }

    public abstract void turnOn();
}