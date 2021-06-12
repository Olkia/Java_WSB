package com.company;
import java.io.File;

public class Animal {
    String name;
    private Double weight;
    final public String species;
    File pic;

    static final public Double DEFAULT_ANIMAL_WEIGHT = 1.0;

    public Animal(String species){
        this.species = species;

        switch (this.species){
            case "canis familiaris" : this.weight = 10.0;
            case "feline" : this.weight = 2.0;
            default: this.weight = DEFAULT_ANIMAL_WEIGHT;
        }
    }
    void feed() {
        if(this.weight>0){
            this.weight += 1;
            System.out.println("thx for food :D");
        }
        else{
            System.out.println("Staph, I'm already dead");
        }
    }

    void takeForAWalk(){
        if(this.weight>0){
            this.weight -= 1;
            Sytem.out.println("Thanks for walk, very nice");
        }
        else{
            System.out.println("Walking with dead pet, nice");
        }
    }
    public String toString(){
        return species+" "+weight+" "+name;
    }
}
