/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author alexandersteen
 */
public interface DrugInterface {
    String getName();
    int getAvailability();
    void setAvailability(int amt);
    int getPrice();
    AvailabilityStrategyInterface getAvailabilityStrategy();
    PriceStrategyInterface getPriceStrategy();
    void shakeDrug();

    @Override
    public String toString();
    
    
}
