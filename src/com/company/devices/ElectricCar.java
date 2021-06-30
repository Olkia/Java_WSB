package com.company.devices;

public class ElectricCar extends Car {

    private static final Integer chassisNumber = 1;
    private final Double batteryCapacity;
    private final Boolean hasCharger;

    //Constructors
    public ElectricCar(String producer, String model, Double batteryCapacity, Boolean hasCharger) {
        super(producer, model, chassisNumber);
        this.batteryCapacity = batteryCapacity;
        this.hasCharger = hasCharger;
    }

    public ElectricCar(String producer, String model, Integer chassisNumber, Double batteryCapacity, Boolean hasCharger) {
        super(producer, model, chassisNumber);
        this.batteryCapacity = batteryCapacity;
        this.hasCharger = hasCharger;
    }

    public String toString()
    {
        return super.toString()+ "\nBattery capacity: " + batteryCapacity + "\nHave it recharger? "+ hasCharger;
    }

    public void refuel() {
        System.out.println("Battery full.");
    }
}