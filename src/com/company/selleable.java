package com.company;

public interface selleable {
    boolean sell(Human seller, Human buyer, Double price) throws Exception;
}