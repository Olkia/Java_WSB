package com.company.devices;

public class DieselCar extends Car{

    private static final Integer chassisNumber = 1;
    private Boolean hasDieselParticulateFilter;

    public DieselCar(String producer, String model, Boolean hasDieselParticulateFilter) {
        super(producer, model, chassisNumber);
        this.hasDieselParticulateFilter = hasDieselParticulateFilter;
    }

    public DieselCar(String producer, String model, Integer chassisNumber, Boolean hasDieselParticulateFilter) {
        super(producer, model, chassisNumber);
        this.hasDieselParticulateFilter = hasDieselParticulateFilter;
    }

    @Override
    public String toString()
    {
        return super.toString()+ "\nHave DPF?" + hasDieselParticulateFilter;
    }

    public void refuel() {
        System.out.println("Car full of fuel");
    }
}