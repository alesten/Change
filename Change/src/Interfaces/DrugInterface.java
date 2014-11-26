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
    int getBaseAvailability();
    int getBasePrice();
    AvailabilityStrategyInterface getAvailabilityStrategy();
    PriceStrategyInterface getPriceStrategy();
}
