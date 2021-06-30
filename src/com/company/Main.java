package com.company;
import com.company.creatures.*;
import com.company.devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Animal dog = new Animal("Canis familiaris");
        dog.name = "Szarik";
        dog.feed();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.feed();

        Animal cat = new Animal("Feline");
        cat.name = "Puszek";

        System.out.println("dog name = " + dog.name);

        Human humanselling = new Human();
        humanselling.addCash(10000.0);
        Human humanbuying = new Human();
        humanbuying.addCash(10000.0);
        Device car7 = new DieselCar("Mazda", "323F", false);
        car7.turnOn();
        System.out.println(car7);
        Car car4 = new DieselCar("Łada", "Samara", 12345, false);
        Car car5 = new DieselCar("Łada", "Samara", 12345, false);
        Car car6 = new DieselCar("Łada", "Samara", 12347, false);
        System.out.println(car4.hashCode() == car5.hashCode());
        System.out.println(car4.hashCode() == car6.hashCode());

        Animal dog2 = new Pet("pies");
        humanselling.pet = dog2;

        Phone iphone = new Phone("apple", "6s", 2018);

        Human me = new Human();
        me.firstName = "Ola";
        me.lastName = "Dolecka";
        me.age = 26;
        me.sex = "Kobieta";

        Integer chassisNumber = 1;
        Car car = new Car("Volvo", "V50", chassisNumber);
        Car car2 = new Car("Volvo", "V50", chassisNumber);
        Car car3 = new Car("Audi", "TT", chassisNumber);
        car.valueCar = 1000.0;
        car2.valueCar = 3000.0;

        me.setSalary(4000.0);
        me.getCar();
        me.buyCar(car);

        System.out.println(car.equals(car2));
        System.out.println(car.equals(car3));
        System.out.println(car);
        System.out.println(car2);
        System.out.println(me);
        System.out.println(dog);

        Double salary2 = me.checkSalary();
        System.out.println();
        me.setSalary(25000.0);
        System.out.println();
        Double salary3 = me.checkSalary();
        System.out.println();
        Double salary4 = me.checkSalary();
        System.out.println();

        Phone phone = new Phone("Xiaomi", "Mi8",2020);
        System.out.println(phone);
        phone.turnOn();
        car.turnOn();

        System.out.println("Before selling pet:\n");
        System.out.println("About seller:\n");
        System.out.println(humanselling);
        System.out.println("About buyer:\n");
        System.out.println(humanbuying);
        System.out.println();

        dog2.sell(humanselling, humanbuying, 5000.0);

        System.out.println("After selling pet:\n");
        System.out.println("About seller:\n");
        System.out.println(humanselling);
        System.out.println("About buyer:\n");
        System.out.println(humanbuying);
        System.out.println();

        Car car9 = new DieselCar("Skoda", "Octavia", false);
        car9.value = 6000.0;
        humanselling.setCar(car9,1);
        car9.addTransaction(new Transaction(humanbuying, humanselling, 4000.0));
        System.out.println("Before selling car\n");

        System.out.println("About seller:\n");
        System.out.println(humanselling);
        System.out.println("About buyer:\n");
        System.out.println(humanbuying);
        System.out.println();

        try {
            car9.sell(humanselling, humanbuying, 4000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println("After selling car:\n");
        System.out.println("About seller:\n");
        System.out.println(humanselling);
        System.out.println("About buyer:\n");
        System.out.println(humanbuying);
        System.out.println();

        Animal swine1 = new Pet("swinka");
        Animal swine2 = new FarmAnimal("swinka morska");
        FarmAnimal swine3 = new FarmAnimal("kawia swinka");

        ((FarmAnimal) swine2).beEaten();
        swine3.beEaten();

        System.out.println();

        swine1.feed();
        swine2.feed();

        System.out.println();

        swine1.feed(2.0);
        swine2.feed(2.0);

        System.out.println();

        Phone phone3 = new Phone();

        phone3.installAnApp("Animal Crossing");
        phone3.installAnApp("Animal Crossing", "10.0");
        phone3.installAnApp("Animal Crossing", "10.0", "https://google.com/AnimalCrossing.jar");
        ArrayList<String> applicationList = new ArrayList<String>();
        applicationList.add("Animal Crossing");
        applicationList.add("Rickroll everyday");
        applicationList.add("The Sims");
        applicationList.add("WhatsApp");
        phone3.installAnApp(applicationList);
        try {
            URL url1 = new URL("https", "www.onet.pl", "onet.exe");
            phone3.installAnApp(url1);
        } catch (MalformedURLException e) {
        }
        try {
            URL url2 = null;
            phone3.installAnApp(url2);
        } catch (MalformedURLException e) {
        }
        try {
            URL url3 = new URL(Phone.DEFAULT_PROTOCOL, Phone.DEFAULT_SERVER_ADDRESS, Phone.DEFAULT_FILENAME);
            phone3.installAnApp(url3);
        }
        catch (MalformedURLException e)
        {
        }

        System.out.println();

        Car car10 = new ElectricCar("Tesla", "Model 1", 32.0,true);
        Car car11 = new DieselCar("Toyota", "Auris", true);
        Car car12 = new LPGCar("Fiat", "Linea", 23.0);
        car10.refuel();
        car11.refuel();
        car12.refuel();


        System.out.println("Test garażu");

        Human human4 = new Human(8);
        human4.addCash(10000.0);
        me.addCash(30000.0);

        ElectricCar car13 = new ElectricCar("Toyota","Prius",55.0,true);
        car13.fuelConsumption = 9.0;
        car13.value = 45000.0;
        car13.yearOfProduction = 2020;
        car13.addTransaction(new Transaction(me, human4, 4000.0));

        ElectricCar car14 = new ElectricCar("Toyota","Auris",32.0,true);
        car14.fuelConsumption = 15.0;
        car14.value = 19000.0;
        car14.yearOfProduction = 2018;
        car14.addTransaction(new Transaction(me, human4, 4000.0));

        ElectricCar car15 = new ElectricCar("Fiat","500",77.0,false);
        car15.fuelConsumption = 13.0;
        car15.value = 34000.0;
        car15.yearOfProduction = 2021;
        car15.addTransaction(new Transaction(me, human4, 4000.0));

        ElectricCar car16 = new ElectricCar("Fiat","500+",77.0,false);
        car16.fuelConsumption = 13.0;
        car16.value = 34000.0;
        car16.yearOfProduction = 2019;
        car16.addTransaction(new Transaction(me, human4, 4000.0));

        ElectricCar car17 = new ElectricCar("Fiat","500-",77.0,false);
        car17.fuelConsumption = 17.0;
        car17.value = 36000.0;
        car17.yearOfProduction = 2020;
        car17.addTransaction(new Transaction(me, human4, 4000.0));

        ElectricCar car18 = new ElectricCar("Fiat","+/-500",70.0,false);
        car18.fuelConsumption = 12.0;
        car18.value = 43000.0;
        car18.yearOfProduction = 2017;
        car18.addTransaction(new Transaction(me, human4, 4000.0));

        ElectricCar car19 = new ElectricCar("Fiat","~500",70.0,false);
        car19.fuelConsumption = 16.0;
        car19.value = 33000.0;
        car19.yearOfProduction = 2014;
        car19.addTransaction(new Transaction(me, human4, 4000.0));

        //Testing if possible is putting two cars on the same garage space
        human4.setCar(car13,0);
        human4.setCar(car13,0);

        human4.setCar(car14,1);
        human4.setCar(car15,2);
        human4.setCar(car16,3);
        human4.setCar(car17,4);
        human4.setCar(car18,5);
        human4.setCar(car19,6);

        human4.setCar(car19,9);

        System.out.println();

        human4.sumCarValue();
        me.sumCarValue();

        System.out.println();

        System.out.println("About seller:");
        System.out.println(human4);
        System.out.println("About buyer:");
        System.out.println(me);
        System.out.println();

        try {
            car12.sell(human4, me, 30000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car13.sell(human4, me, 50000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car13.sell(me, human4, 5000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car13.sell(human4, me, 2000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car14.sell(human4, me, 1500.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car15.sell(human4, me, 1000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car16.sell(human4, me, 7000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car17.sell(human4, me, 3000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car18.sell(human4, me, 500.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car19.sell(human4, me, 1000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println();
        System.out.println("After selling cars:\n");
        System.out.println("About seller:");
        System.out.println(human4);
        System.out.println("About buyer");
        System.out.println(me);
        System.out.println();

        me.sortCarByYearOfProduction();
        human4.sortCarByYearOfProduction();

        System.out.println("Sort cars:\n");
        System.out.println("About seller");
        System.out.println(human4);
        System.out.println("About buyer");
        System.out.println(me);
        System.out.println();

        System.out.println("If me ever was owner of car15\n");
        System.out.println(car15.wasCarOwner(me));

        System.out.println("If humanselling ever was owner of car15\n");
        System.out.println(car15.wasCarOwner(humanselling));

        System.out.println("Sold me ever car15 to human4?\n");
        System.out.println(car15.wasCarSold(me, human4));

        System.out.println("Sold human4 ever car15 to humanbuying?\n");
        System.out.println(car15.wasCarSold(human4, humanbuying));

        System.out.println("How many times car15 was sell?\n");
        System.out.println(car15.numberOfTransactions());

        System.out.println("How many times car7 was sell?\n");
        System.out.println( ((Car) car7).numberOfTransactions());

        System.out.println("How many times car6 was sell?\n");
        System.out.println( ((Car) car6).numberOfTransactions());

        System.out.println("\nTesting\n");

        Application app1 = new Application("Wiśnie", "1.01", 10.0);
        Application app2 = new Application("Mango", "1.01", 1.5);
        Application app3 = new Application("Porzeczki", "1.01", 3.0);
        Application app4 = new Application("Truskawki", "1.01", 2.0);
        Application app5 = new Application("Jagody", "1.01", 0.0);
        Application app6 = new Application("Kokosy", "1.01", 2000.0);

        me.setPhone(phone3);

        System.out.println("Money befor buying in app: " + me.cashAvailable());

        try {
            phone3.installAnnApp(app1, human4);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            phone3.installAnnApp(app6, me);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            phone3.installAnnApp(app1, me);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            phone3.installAnnApp(app2, me);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            phone3.installAnnApp(app3, me);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        try {
            phone3.installAnnApp(app4, me);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        try {
            phone3.installAnnApp(app5, me);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        System.out.println("Money after buying in app: " + me.cashAvailable());

        System.out.println("Is app1 installed on the phone?");
        System.out.println(phone3.isInstalledApp(app1));
        System.out.println("Is app6 installed on the phone?");
        System.out.println(phone3.isInstalledApp(app6));
        System.out.println("Is app Truskawki installed on the phone?");
        System.out.println(phone3.isInstalledApp("Truskawki"));
        System.out.println("Is app Porzeczki installed on the phone?");
        System.out.println(phone3.isInstalledApp("Porzeczki"));

        phone3.valueOfInstalledApplications();
        phone3.listFreeApp();
        phone3.listInstalledApplicationAlphabetically();
        phone3.listInstalledApplicationByAscendingPrices();

        Phone phone5 = new Phone();
        Human human5 = new Human();
        Human human6 = new Human();
        human5.setPhone(phone5);
        human6.addCash(10000.0);

        System.out.println("Tests");
        System.out.println(human5+"\n");
        System.out.println(human6+"\n");

        try {
            phone5.sell(human5, human6, 9000.0);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            phone5.sell(human6, human5, 2000.0);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        try {
            phone5.sell(human5, human6, 7000.0);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        System.out.println("After buying:\n");
        System.out.println(human5+"\n");
        System.out.println(human6+"\n");

        System.out.println(me);
    }
}
