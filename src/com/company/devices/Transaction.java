package com.company.devices;

import com.company.Human;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private final Human peopleSelling;
    private final Human peopleBuying;
    private final double price;
    private final Date dateTransaction;

    public Transaction(Human peopleSelling, Human peopleBuying, double price)
    {
        this.peopleSelling = peopleSelling;
        this.peopleBuying = peopleBuying;
        this.price = price;
        this.dateTransaction = new Date();
    }

    public Human deviceOwner()
    {
        return this.peopleBuying;
    }

    public Human devicePreviousOwner()
    {
        return this.peopleSelling;
    }

    @Override
    public String toString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        String simpleDate = dateFormat.format(this.dateTransaction);
        return "\nSeller: "+ this.peopleSelling.firstName + " " + this.peopleSelling.lastName  + "\nBuyer: "+ this.peopleBuying.firstName + " " + this.peopleBuying.lastName + "\nCost: "+ this.price + "\nDate: " + simpleDate +"\n";
    }

}