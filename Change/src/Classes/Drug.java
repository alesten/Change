/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.AvailabilityStrategyInterface;
import Interfaces.DrugInterface;
import Interfaces.PriceStrategyInterface;

/**
 *
 * @author alexandersteen
 */
public class Drug implements DrugInterface {

    private String name;
    private int availability;
    private int price;
    private int goldenNumber;

    PriceStrategyInterface priceStrategy;
    AvailabilityStrategyInterface availabilityStrategy;

    public Drug(String name, PriceStrategyInterface priceStrategy,
            AvailabilityStrategyInterface availabilityStrategy,
            int goldenNumber) {
        this.name = name;

        this.availabilityStrategy = availabilityStrategy;
        this.priceStrategy = priceStrategy;

        this.shakeDrug();

        this.goldenNumber = goldenNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAvailability() {
        return availability;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public AvailabilityStrategyInterface getAvailabilityStrategy() {
        return availabilityStrategy;
    }

    @Override
    public PriceStrategyInterface getPriceStrategy() {
        return priceStrategy;
    }

    @Override
    public void shakeDrug() {
        price = priceStrategy.calculatePrice(goldenNumber);
        availability = availabilityStrategy.calculateAvailability();
    }

    @Override
    public String toString() {
        return "Name: " + name + " - Current Price: " + price + " - Current Availability: " + availability;
    }

    @Override
    public void setAvailability(int amt) {
        this.availability = amt;
    }

}
