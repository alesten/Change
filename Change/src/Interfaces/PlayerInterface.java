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
public interface PlayerInterface {
    String getName();
    int getBalance();
    int getLife();
    boolean withdraw(int amt);
    boolean deposit(int amt);
    CountryInterface getCurrentCountry();
    boolean setCurrentCountry(CountryInterface county);
    Map<DrugInterface, Integer> getDrugs();
    boolean setDrugs(Map<DrugInterface, Integer> drugs);
}
