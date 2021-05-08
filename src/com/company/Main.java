package com.company;

public class Main {

    public static void main(String[] args) {
        Animal dog = new Animal("Canis familiaris");
        dog.name = "Szarik";

        Animal cat = new Animal("Feline");
        cat.name = "Puszek";

        System.out.println("dog name = " + dog.name);

        Phone iphone = new Phone();
        iphone.producer = "apple";
        iphone.model = "6S";

        Phone s11 = new Phone();
        s11.producer = "samsung";
        s11.model = "S11";

        Human me = new Human();
        me.firstName = "Ola";
        me.lastName = "Dolecka";
        me.age = 26;
        me.sex = "Kobieta";


        dog.feed();
        String version = iphone.getOSVersion();

        System.out.println(iphone.getOSVersion());

        dog.takeForAWalk();
        me.mobilePhone = iphone;
    }
}
