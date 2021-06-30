package com.company.devices;

public class LPGCar extends Car {

    private static final Integer chassisNumber = 1;
    private final Double capacityLPGTank;

    //Constructors
    public LPGCar(String producer, String model, Double capacityLPGTank) {
        super(producer, model, chassisNumber);
        this.capacityLPGTank = capacityLPGTank;
    }

    public LPGCar(String producer, String model, Integer chassisNumber, Double capacityLPGTank) {
        super(producer, model, chassisNumber);
        this.capacityLPGTank = capacityLPGTank;
    }

    public String toString()
    {
        return super.toString() + "\nCapacity LPG tank: "+capacityLPGTank;
    }

    public void refuel() {
        System.out.println("Car full of LPG.");
    }
}