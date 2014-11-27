/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.AvailabilityStrategyInterface;
import Interfaces.CountryInterface;
import Interfaces.MarketplaceInterface;
import Interfaces.PriceStrategyInterface;

/**
 *
 * @author alexandersteen
 */
public class Country implements CountryInterface{

    String name;
    MarketplaceInterface marketplace;

    public Country(String name, PriceStrategyInterface priceStrategy, AvailabilityStrategyInterface availabilityStrategy) {
        this.name = name;
        this.marketplace = new Marketplace(priceStrategy, availabilityStrategy);
    }
    
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public MarketplaceInterface getMarketplace() {
        return marketplace;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
    
}
