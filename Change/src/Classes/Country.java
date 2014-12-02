/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.CountryInterface;
import Interfaces.DrugInterface;
import Interfaces.MarketplaceInterface;

/**
 *
 * @author alexandersteen
 */
public class Country implements CountryInterface{

    String name;
    MarketplaceInterface marketplace;

    public Country(String name, DrugInterface[] drugs) {
        this.name = name;
        this.marketplace = new Marketplace(drugs);
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
