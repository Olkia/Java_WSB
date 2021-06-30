package com.company.devices;

import com.company.Human;

import java.net.URL;

public abstract class Device {
    String producer;
    String model;
    Integer yearOfProduction;
    public Double value;

    public String toString(){

        return producer+" "+model+" "+yearOfProduction;
    }

    public abstract void turnOn();

    public abstract void installAnnApp(Application app1, Human human4);

    public abstract void installAnApp(URL url1);
}