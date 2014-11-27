/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.CountryInterface;
import Interfaces.DrugInterface;
import Interfaces.PlayerInterface;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexandersteen
 */
public class Player implements PlayerInterface {

    private String name;
    private int balance;
    private int life;
    private CountryInterface currentCountry;
    private Map<String, Integer> drugs;

    public Player(String name, int balance, int life, CountryInterface currentCountry) {
        this.name = name;
        this.balance = balance;
        this.life = life;
        this.currentCountry = currentCountry;
        drugs = new HashMap();
        drugs.put("Cocaine", 0);
        drugs.put("Heroin", 0);
        drugs.put("Amphetamine", 0);
        drugs.put("Acid", 0);
        drugs.put("Angel Dust", 0);
        drugs.put("Crystal Meth", 0);
        drugs.put("Hash", 0);
        drugs.put("Weed", 0);
        drugs.put("Mushrooms", 0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void withdraw(int amt) {
        balance -= amt;
    }

    @Override
    public void deposit(int amt) {
        balance += amt;
    }

    @Override
    public CountryInterface getCurrentCountry() {
        return currentCountry;
    }

    @Override
    public boolean setCurrentCountry(CountryInterface country) {
        if (currentCountry == country) {
            return false;
        }
        currentCountry = country;
        return true;
    }

    @Override
    public Map<String, Integer> getDrugs() {
        return drugs;
    }

    @Override
    public void setDrugs(String name, int amt) {
        drugs.put(name, amt);
    }

    @Override
    public boolean grainLife(int amt) {
        life += amt;

        return true;
    }

    @Override
    public boolean loseLife(int amt) {
        life -= amt;
        return life > 0;
    }

    @Override
    public String toString() {
        return "Name: " + name + " - Balance: " + balance + " - Life: " + life;
    }
}
