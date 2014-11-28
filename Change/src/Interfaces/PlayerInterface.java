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
    void withdraw(int amt);
    void deposit(int amt);
    CountryInterface getCurrentCountry();
    boolean setCurrentCountry(CountryInterface country);
    Map<String, Integer> getDrugs();
    void setDrugs(String name, int amt);
    boolean grainLife(int amt);
    boolean loseLife(int amt);
    Map<String, Boolean> getServices();

    @Override
    public String toString();

    public void setName(String test);
    
    
}
