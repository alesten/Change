/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Map;

/**
 *
 * @author alexandersteen
 */
public interface MarketplaceInterface {
    boolean buy(DrugInterface drug, int amt, PlayerInterface player);    
    boolean sell(DrugInterface drug, int amt, PlayerInterface player);
    Map<DrugInterface, Integer> getDrugs();
}
