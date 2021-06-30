package com.company.creatures;

public class Pet extends Animal implements Feedable {

    public Pet(String species_) {
        super(species_);
    }

    static final Double DEFAULT_FOOD_WEIGHT = 0.5;

    public void feed()
    {
        if (this.weight <= 0)
        {
            System.out.println("Pet's dead");
        }
        else
        {
            this.weight += DEFAULT_FOOD_WEIGHT;
            System.out.println("I'm feed, my weight is: " + this.weight);
        }
    }

    public void feed(Double foodWeight)
    {
        if (this.weight <= 0)
        {
            System.out.println("Pet's dead");
        }
        else
        {
            this.weight += foodWeight;
            System.out.println("I'm feed, my weight is: " + this.weight);
        }
    }
}