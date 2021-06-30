package com.company.creatures;
import java.io.File;

public class Animal implements Soldable, Feedable{
    public String name;
    protected Double weight;
    final public String species;
    File pic;

    static final public Double DEFAULT_ANIMAL_WEIGHT = 1.0;
    static final public Double DEFAULT_FOOD_WEIGHT = 0.3;

    public Animal(String species_){
        this.species = species_;

        switch (this.species){
            case "canis familiaris" : this.weight = 10.0;
            case "feline" : this.weight = 2.0;
            default: this.weight = DEFAULT_ANIMAL_WEIGHT;
        }
    }
    public void feed() {
        if(this.weight>0){
            this.weight += 1;
            System.out.println("thx for food :D");
        }
        else{
            this.weight += DEFAULT_FOOD_WEIGHT;
            System.out.println("I'm feed, my weight is: " + this.weight);
        }
    }
    public void feed(Double foodWeight)
    {
        if (this.weight <= 0)
        {
            System.out.println("I'm dead already");
        }
        else
        {
            this.weight += foodWeight;
            System.out.println("I'm feed, my weight is: " + this.weight);
        }
    }

    public void takeForAWalk(){
        if(this.weight>0){
            this.weight -= 1;
            System.out.println("Thanks for walk, very nice");
        }
        else{
            System.out.println("Walking with dead pet, nice");
        }
    }
    public String toString(){
        return species+" "+weight+" "+name+" "pic;
    }
    public void sell(Human seller, Human buyer, Double price)
    {
        if(seller.pet == this && buyer.cashAvailable() > price) {
            seller.incomeCash(price);
            buyer.incomeCash(-price);
            buyer.pet = seller.pet;
            seller.pet = null;
            System.out.println("Zwierze sprzedane.");

        }
        else if (seller.pet != this)
        {
            System.out.println("Sprzedający nie ma sprzedawanego zwierzaka.");
        }
        else
        {
            System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }
    }
}
