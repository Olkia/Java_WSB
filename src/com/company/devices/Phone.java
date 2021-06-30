package com.company.devices;
import com.company.Human;
import com.company.selleable;

public class Phone extends Device implements selleable {
    Double memory;
    Double screenSize;


    public Phone(String producer, String model, Integer yearOfProduction){
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }
    @Override
    public void turnOn(){
        System.out.println("This phone "+producer+" "+model+" is now turned on.");
    }
    @Override
    public void sell(Human seller, Human buyer, Double price) {
        boolean isBuyerHasMoney;
        boolean isSellerHasPhone;
        if (seller.getPhone() == null ){
            System.out.println("Seller don't have a phone...");
            isSellerHasPhone = false;
        }else{
            isSellerHasPhone = true;
        }
        if (buyer.getCash() < price){
            System.out.println("Buyer don't have money!");
            isBuyerHasMoney = false;
        }else{
            isBuyerHasMoney = true;
        }
        if (isBuyerHasMoney && isSellerHasPhone){
            buyer.subtractCash(price);
            seller.addCash(price);
            buyer.setPhone(seller.getPhone());
            System.out.println("Buyer got a phone " + buyer.getPhone().toString());
            seller.setCar(null);
            System.out.println("We removed sellers phone");
        }
    }
}