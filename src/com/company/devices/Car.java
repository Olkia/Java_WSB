package com.company.devices;
import com.company.Human;
import com.company.selleable;

public class Car extends Device implements selleable {

    final String producer;
    final String model;
    public Double valueCar;


    public Car(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return producer == car.producer &&
                model == car.model;
    }

    public String toString() {
        return producer + " " + model + " " + valueCar;
    }

    @Override
    public void turnOn() {
        System.out.println("The engine of " + producer + " " + model + " is on!");
    }

    public void sell(Human seller, Human buyer, Double price) {
        boolean isBuyerHasMoney;
        boolean isSellerHasCar;
        if (seller.getCar() == null) {
            System.out.println("Seller don't have a car, he can't sell it");
            isSellerHasCar = false;
        } else {
            isSellerHasCar = true;
        }
        if (buyer.getCash() < price) {
            System.out.println("The buyer don't have cash!");
            isBuyerHasMoney = false;
        } else {
            isBuyerHasMoney = true;
        }
        if (isBuyerHasMoney && isSellerHasCar) {
            buyer.subtractCash(price);
            seller.addCash(price);
            buyer.setCar(seller.getCar());
            System.out.println("Buyer get a car " + buyer.getCar().toString());
            seller.setCar(null);
            System.out.println("We removed sellers car");
        }
    }
}