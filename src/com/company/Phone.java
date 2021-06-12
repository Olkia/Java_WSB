package com.company;

public class Phone {
    final String producer;
    final String model;
    String os;
    final Double screenSize;

    public Phone(String producent, String model, Double screenSize){
        this.producent = producent;
        this.model = model;
        this.screenSize = screenSize;
    }
    String getOSVersion (){
        return "5.32.1";
    }
}
