/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.AvailabilityStrategyInterface;
import Interfaces.ControllerInterface;
import Interfaces.CountryInterface;
import Interfaces.DrugInterface;
import Interfaces.EventInterface;
import Interfaces.HighscoreItemInterface;
import Interfaces.PlayerInterface;
import Interfaces.PriceStrategyInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alexandersteen
 */
public class Controller implements ControllerInterface {

    private final HighscoreRepository highscoreRepository;
    private ArrayList<CountryInterface> countries;
    private CountryInterface startCountry;
    private Player player;
    private int days;
    private List<EventInterface> events;

    public Controller(String name) {
        this.highscoreRepository = new HighscoreRepository("highscores.csv");
        this.countries = new ArrayList();

        CountryInterface denmark = new Country("Denmark", getDrugs());
        CountryInterface columbia = new Country("Columbia", getDrugs());
        CountryInterface germany = new Country("Germany", getDrugs());
        CountryInterface usa = new Country("USA", getDrugs());
        CountryInterface france = new Country("France", getDrugs());
        CountryInterface afghanistan = new Country("Afghanistan", getDrugs());

        countries.add(denmark);
        countries.add(columbia);
        countries.add(germany);
        countries.add(usa);
        countries.add(france);
        countries.add(afghanistan);

        startCountry = denmark;

        this.player = new Player(name, 5000, 100, startCountry);
        this.days = 0;

        events = new ArrayList<>();

        EventInterface customs = new CustomsEvent();
        EventInterface pusher = new PusherEvent();

        events.add(customs);
        events.add(pusher);
    }

    @Override
    public int getElapsedDays() {
        return days;
    }

    @Override
    public List<EventInterface> fly(CountryInterface country) {
        List<EventInterface> encounteredEvents = new ArrayList<>();
        HashMap<String, Boolean> playerServices = (HashMap<String, Boolean>) player.getServices();
        player.setCurrentCountry(country);
        shakeContries();
        days++;

        for (EventInterface event : events) {
            if (event.doesEventHappen(playerServices)) {
                encounteredEvents.add(event);

                // Invoke the event
                event.eventAction(player);
            }
        }

        return encounteredEvents;
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

    @Override
    public List<HighscoreItemInterface> getHighscores() {
        return this.highscoreRepository.fetch();
    }

    @Override
    public void resetGame() {

    }

    @Override
    public void endGame() {
        // Sell the players drugs
        Map<String, Integer> drugs = player.getDrugs();
        for (Map.Entry<String, Integer> drug : drugs.entrySet()) {
            player.getCurrentCountry().getMarketplace().sell(drug.getKey(), drug.getValue(), player);
        }

        // Save the score to the highscore
        this.highscoreRepository.insert(new HighscoreItem(player.getName(), player.getBalance()));
    }

    private DrugInterface[] getDrugs() {
        AvailabilityStrategyInterface basicAvailabilityStrategy = new AvailabilityStrategy(10);
        PriceStrategyInterface basicPriceStrategy = new PriceStrategy(1000);

        return new DrugInterface[]{
            new Drug("Cocaine", 30, 1200, basicPriceStrategy, basicAvailabilityStrategy, 10),
            new Drug("Heroin", 15, 1600, new PriceStrategy(1600), new AvailabilityStrategy(15), 15),
            new Drug("Amphetamine", 50, 200, basicPriceStrategy, basicAvailabilityStrategy, 7),
            new Drug("Acid", 33, 550, basicPriceStrategy, basicAvailabilityStrategy, 5),
            new Drug("Angel Dust", 60, 400, new TenPercentPriceStrategy(), new TenPercentAvailabilityStrategy(), 7),
            new Drug("Crystal Meth", 38, 800,  new PriceStrategy(800), new AvailabilityStrategy(38), 12),
            new Drug("Hash", 100, 180, basicPriceStrategy, basicAvailabilityStrategy, 4),
            new Drug("Weed", 115, 150, basicPriceStrategy, basicAvailabilityStrategy, 5),
            new Drug("Mushrooms", 95, 120, basicPriceStrategy, basicAvailabilityStrategy, 7),
            new Drug("Valium", 80, 290,  new PriceStrategy(290), new AvailabilityStrategy(80), 7)
        };
    }
}
