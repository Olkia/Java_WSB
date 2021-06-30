package com.company.devices;
import com.company.Human;
import com.company.selleable;

import java.util.ArrayList;

public abstract class Car extends Device implements selleable {
    public Double fuelConsumption;
    public int yearOfProduction;
    private Integer chassisNumber;
    private final ArrayList<Transaction> ownerList;
    final String producer;
    final String model;
    public Double valueCar;


    public Car(String producer, String model, Integer chassisNumber) {
        this.producer = producer;
        this.model = model;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || this.getClass() != o.getClass())
        {
            return false;
        }
        return (producer.equals(((Car) o).producer) && model.equals(((Car) o).model) && fuelConsumption == ((Car) o).fuelConsumption) && value == ((Car) o).value && yearOfProduction == ((Car) o).yearOfProduction && ownerList == ((Car) o).ownerList;
    }
    @Override
    public String toString()
    {
        String string = super.toString() + "\nFuel consumption: " + fuelConsumption;
        if (!ownerList.isEmpty()) {
            string += "\nOwners list:\n"+ownerList;
        }
        else
        {
            string += "\nNo transaction.";
        }

        return  string;
    }
    @Override
    public void turnOn() {
        System.out.println("The engine of " + producer + " " + model + " is on!");
    }
    @Override
    public int hashCode()
    {
        return chassisNumber;
    }
    public boolean sell(Human seller, Human buyer, Double price) throws Exception {
        {
            boolean isOwner = false;
            Integer carPositionInGarage = null;
            for (int i = 0; i < seller.ownedCars().length; i++) {
                Car transactionItem = seller.ownedCars()[i];
                int lastIndexOfTransaction;
                if (transactionItem != null) {
                    if (transactionItem.ownerList.size() == 0) {
                        throw new Exception("This car has no owner.");
                    } else {
                        lastIndexOfTransaction = transactionItem.ownerList.size() - 1;
                    }
                    Human carLastOwner = transactionItem.ownerList.get(lastIndexOfTransaction).deviceOwner();
                    if (transactionItem == this && carLastOwner == seller) {
                        isOwner = true;
                        carPositionInGarage = i;
                        break;
                    }
                }
            }

            if (!isOwner) throw new Exception("Seller doesn't have a car.");
            int freeGarageSpaces = buyer.ownedCars().length;
            if (buyer.ownedCars().length > 0) {
                for (int i = 0; i < buyer.ownedCars().length; i++) {
                    if (buyer.ownedCars()[i] != null) {
                        freeGarageSpaces--;
                    }
                }
            }
            if (freeGarageSpaces == 0) throw new Exception("Buyer doesn't have space in garage.");

            if (buyer.cashAvailable() < price) throw new Exception("Buyer doen't have enough money.");

            Integer newCarPositionInGarage = null;
            if (buyer.ownedCars().length > 0) {
                for (int i = 0; i < buyer.ownedCars().length; i++) {
                    if (buyer.ownedCars()[i] == null) {
                        newCarPositionInGarage = i;
                        break;
                    }
                }
            }

            seller.incomeCash(price);
            buyer.incomeCash(-price);
            Car soldCar = seller.getCar(carPositionInGarage);
            buyer.setCar(soldCar, newCarPositionInGarage);
            seller.setCar(null, carPositionInGarage);
            Transaction transaction = new Transaction(seller, buyer, price);
            ownerList.add(transaction);
            System.out.println("Samochód sprzedany.");
        }
        return false;
    }

    public abstract void refuel();
    public boolean wasCarOwner(Human human)
    {
        boolean wasCarOwner = false;
        for (Transaction checkedTransaction : this.ownerList) {
            if (checkedTransaction.deviceOwner() == human || checkedTransaction.devicePreviousOwner() == human) {
                wasCarOwner = true;
                break;
            }
        }

        return wasCarOwner;
    }

    public boolean wasCarSold(Human humanA, Human humanB)
    {
        boolean wasCarSold = false;
        for (Transaction checkedTransaction : this.ownerList) {
            if (checkedTransaction.deviceOwner() == humanB && checkedTransaction.devicePreviousOwner() == humanA) {
                wasCarSold = true;
                break;
            }
        }
        return wasCarSold;
    }
    public Integer numberOfTransactions()
    {
        return this.ownerList.size();
    }

    public void addTransaction(Transaction transaction)
    {
        this.ownerList.add(transaction);
    }
}