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
public class Drug implements DrugInterface{

    private String name;
    private int baseAvailability;
    private int basePrice;
    private int availability;
    private int price;
    
    PriceStrategyInterface priceStrategy;
    AvailabilityStrategyInterface availabilityStrategy;

    public Drug(String name, int baseAvailability, int basePrice, 
                PriceStrategyInterface priceStrategy,
                AvailabilityStrategyInterface availabilityStrategy) {
        this.name = name;
        this.baseAvailability = baseAvailability;
        this.basePrice = basePrice;
        
        this.availabilityStrategy = availabilityStrategy;
        this.priceStrategy = priceStrategy;
        
        this.price = this.basePrice;
        this.availability = this.baseAvailability;
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
        price = priceStrategy.calculatePrice(price);
        availability = availabilityStrategy.calculateAvailability(availability);
    }

    @Override
    public String toString() {
        return "Name: " + name + " - Current Price: " + price + " - Current Availability: " + availability;
    }
    
    
}
