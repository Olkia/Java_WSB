package com.company;
import com.company.devices.Car;
import com.company.devices.Phone;

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

        Phone iphone = new Phone(producent: "apple", model: "6s", screenSize: 4.5);

        Human me = new Human();
        me.firstName = "Ola";
        me.lastName = "Dolecka";
        me.age = 26;
        me.sex = "Kobieta";

        Car car = new Car("Volvo", "V50");
        Car car2 = new Car("Volvo", "V50");
        Car car3 = new Car("Audi", "TT");
        car.valueCar = 1000.0;
        car2.valueCar = 3000.0;

        me.setSalary(4000.0);
            me.getCar();
            me.buyCar(car);

            System.out.println(car.equals(car2));
            System.out.printl(car.equals(car3));
            System.out.println(car);
            System.out.println(car2);
            System.out.println(me);
            System.out.println(dog);

            Phone phone = new Phone("Xiaomi", "Mi8",5.0);
            Sytem.out.println(phone);
            phone.turnOn();
            car.turnOn();
    }
}
