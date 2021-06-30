package com.company.devices;

public class Application {
    public final String nameOfApplication;
    public final String versionOfApplication;
    public final Double priceOfApplication;

    public Application(String nameOfApplication, String versionOfApplication, double priceOfApplication)
    {
        this.nameOfApplication = nameOfApplication;
        this.versionOfApplication = versionOfApplication;
        this.priceOfApplication = priceOfApplication;
    }

    @Override
    public String toString()
    {
        return "\nName of app:\n"+ nameOfApplication + "\nVersion:\n" + versionOfApplication +"\nCost:\n" +this.priceOfApplication+"\n";
    }
}