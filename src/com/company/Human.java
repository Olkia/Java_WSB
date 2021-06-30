package com.company;
import com.company.creatures.Animal;
import com.company.devices.Car;
import com.company.devices.Phone;

import java.util.ArrayList;
import java.util.Date;

public class Human {
    public String firstName;
    public String lastName;
    public String sex;
    public Integer age;
    private Double salary;
    private Phone phone;
    private Double cash;
    private final ArrayList<Phone> ownedPhone;
    private final Car[] garage;

    public Double getSalary(){
        System.out.println("Date when you checked about your salary: " + new Date());
        System.out.println("Your salary current level: " + this.salary);
        return salary;
    }

    public void setPhone(Phone phone){
        this.phone = phone;
    }
    public Double getCash(){
        return this.cash;
    }
    public void addCash(Double cash){
        this.cash += cash;
    }
    public void subtractCash(Double cash){
        this.cash -= cash;
    }
    public void setSalary(Double salary){
        if (salary < 0.0){
            System.out.println("Nobody will work for free!");
        }
        else{
            System.out.println("Accountant already known");
            System.out.println("Do not forget to pick up the annex to the contract from Mrs. Hanna");
            System.out.println("A message from ZUS and US: We already know how much you earn, do not hide it because you will lose everything");
            this.salary = salary;
        }
    }
    public Double cashAvailable()
    {
        return this.cash;
    }
    public void incomeCash(Double cash_)
    {
        this.cash += cash_;
    }
    public Car[] ownedCars()
    {
        return this.garage;
    }
    public void sumCarValue()
    {
        Double sum = 0.0;
        for (Car car : garage) {

            if (car != null) {
                sum += car.value;
            }
        }
        System.out.println("Value cars of "+this.firstName + " "+ this.lastName+ " is: "+sum);
    }
    public void sortCarByYearOfProduction()
    {
        for (int i = 0; i < garage.length; i++)
        {
            for (int j = i+1; j < garage.length; j++)
            {
                if (garage[i] != null &&garage[j] != null && garage[i].yearOfProduction > garage[j].yearOfProduction)
                {
                    Car car = garage[j];
                    garage[j] = garage[i];
                    garage[i] = car;
                }
            }
        }
    }
    public Human()
    {
        //Default garage capacity = 5
        this.garage = new Car[5];
        this.cash = 0.0;
        this.ownedPhone = new ArrayList<Phone>();
    }

    private Date dateSalaryCheck;
    private Double previousSalary;
    public Double checkSalary()
    {
        if (dateSalaryCheck == null){
            System.out.println("You've never checked your salary");
        }
        else{
            System.out.println("When salary was: " + this.dateSalaryCheck);
            System.out.println("Previous salary: " + this.previousSalary);
        }
        this.dateSalaryCheck = new Date();
        this.previousSalary = this.salary;
        return this.salary;
    }

    Animal pet;
    private Car car;
    public void setCar(Car car, int i){
        this.car = car;
    }
    public Car getCar(){
        return this.car;
    }
    public void buyCar(Car car){
        if(this.salary > car.valueCar){
            System.out.println("You can afford that car. It's now yours!");
            this.car = car;
        }
        else if (this.salary > car.valueCar/12){
            System.out.println("You bought a car on credit (no trudno :P)");
            this.car = car;
        }
        else{
            System.out.println("Yours salary is too low. You can buy a car when you raise your salary :)");
        }
    }
    public String toString(){
        return firstName+" "+lastName;
    }
    public Phone getPhone(int number)
    {
        Phone returnedPhone = null;
        if (number <= this.ownedPhone.size()) {
            returnedPhone =  this.ownedPhone.get(number);
        }
        else
        {
            System.out.println("There's no space.");
        }
        return returnedPhone;
    }

    public void removePhone(int number)
    {
        this.ownedPhone.remove(number);
    }

    public ArrayList<Phone> ownedPhones()
    {
        return this.ownedPhone;
    }
}
