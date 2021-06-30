package com.company.creatures;

public class FarmAnimal extends Animal implements Edible, Feedable {

    public FarmAnimal(String species_) {
        super(species_);
    }

    final static Double DEFAULT_FOOD_WEIGHT = 1.5;

    public void feed()
    {
        if (this.weight <= 0)
        {
            System.out.println("Pet's dead");
        }
        else
        {
            this.weight += DEFAULT_FOOD_WEIGHT;
            System.out.println("I'm feed, my weight is " + this.weight);
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
            System.out.println("I'm feed, my weight is " + this.weight);
        }
    }

    public void beEaten()
    {
        System.out.println("Pet tasty, yummy");
    }
}