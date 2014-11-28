/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.AvailabilityStrategyInterface;
import Interfaces.ControllerInterface;
import Interfaces.CountryInterface;
import Interfaces.PlayerInterface;
import Interfaces.PriceStrategyInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexandersteen
 */
public class Controller implements ControllerInterface {

    private ArrayList<CountryInterface> countries;
    private CountryInterface startCountry;
    private Player player;
    private int days;

    public Controller(String name) {
        this.countries = new ArrayList();

        AvailabilityStrategyInterface basicAvailabilityStrategy = new AvailabilityStrategy();
        PriceStrategyInterface basicPriceStrategy = new PriceStrategy();

        CountryInterface denmark = new Country("Denmark", basicPriceStrategy, basicAvailabilityStrategy);
        CountryInterface columbia = new Country("Columbia", basicPriceStrategy, basicAvailabilityStrategy);
        CountryInterface germany = new Country("Germany", basicPriceStrategy, basicAvailabilityStrategy);
        CountryInterface usa = new Country("USA", basicPriceStrategy, basicAvailabilityStrategy);
        CountryInterface france = new Country("France", basicPriceStrategy, basicAvailabilityStrategy);
        CountryInterface afghanistan = new Country("Afghanistan", basicPriceStrategy, basicAvailabilityStrategy);

        countries.add(denmark);
        countries.add(columbia);
        countries.add(germany);
        countries.add(usa);
        countries.add(france);
        countries.add(afghanistan);

        startCountry = denmark;

        this.player = new Player(name, 5000, 100, startCountry);
        this.days = 0;
    }

    @Override
    public int getElapsedDays(){
        return days;
    }
    
    @Override
    public boolean fly(CountryInterface country) {
        boolean haveFlown = player.setCurrentCountry(country);
        if (haveFlown) {
            shakeContries();
            days++;
        } 
        return haveFlown;
    }

    @Override
    public List<CountryInterface> getCountries() {
        return countries;
    }

    @Override
    public PlayerInterface getPlayer() {
        return player;
    }

    @Override
    public boolean vistHospital(PlayerInterface player) {
        if (player.getLife() >= 100) {
            return false;
        }

        player.withdraw(player.getBalance() / 4);
        player.grainLife(100 - player.getLife());
        return true;

    }

    private void shakeContries() {
        for (CountryInterface country : countries) {
            country.getMarketplace().shakeMarket();
        }
    }

}
