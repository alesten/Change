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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alexandersteen
 */
public class Controller implements ControllerInterface {

    private final HighscoreRepository highscoreRepository;
    private final StockRepository stockRepository;

    private ArrayList<CountryInterface> countries;
    private CountryInterface startCountry;
    private Player player;
    private int days;
    private List<EventInterface> events;

    public Controller(String name) {
        this.highscoreRepository = new HighscoreRepository("highscores.csv");
        this.stockRepository = new StockRepository();
        this.countries = new ArrayList();

        // Get the possible stock prices
        List<Double> stockPrices = this.stockRepository.findAll();

        CountryInterface denmark = new Country("Denmark", getDrugs(stockPrices));
        CountryInterface columbia = new Country("Columbia", getDrugs(stockPrices));
        CountryInterface germany = new Country("Germany", getDrugs(stockPrices));
        CountryInterface usa = new Country("USA", getDrugs(stockPrices));
        CountryInterface france = new Country("France", getDrugs(stockPrices));
        CountryInterface afghanistan = new Country("Afghanistan", getDrugs(stockPrices));

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
        EventInterface mafia = new MafiaEvent();
        EventInterface minion = new MinionEvent();

        events.add(customs);
        events.add(pusher);
        events.add(mafia);
        events.add(minion);
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

    private DrugInterface[] getDrugs(List<Double> stockPrices) {
        AvailabilityStrategyInterface basicAvailabilityStrategy = new BaseAvailabilityStrategy(10);
        PriceStrategyInterface basicPriceStrategy = new BasePriceStrategy(1000);

        return new DrugInterface[]{
            new Drug("Cocaine", new OldMemoryPriceStrategy(), new OldMemoryAvailabilityStrategy(), 10),
            new Drug("Heroin", new BasePriceStrategy(1600), new BaseAvailabilityStrategy(15), 15),
            new Drug("Amphetamine", new StockPriceStrategy(stockPrices.subList(0, 20)), new StockAvailabilityStrategy(stockPrices.subList(21, 40)), 7),
            new Drug("Acid", new ExchangePriceStrategy(), new ExchangeAvailabilityStrategy(), 5),
            new Drug("Angel Dust", new TenPercentPriceStrategy(), new TenPercentAvailabilityStrategy(), 7),
            new Drug("Crystal Meth", new BasePriceStrategy(800), new BaseAvailabilityStrategy(38), 12),
            new Drug("Hash", new WhiteBlackPriceStrategy(new int[]{90, 300}), new WhiteBlackAvailabilityStrategy(new int[]{50, 180}), 4),
            new Drug("Weed", new PickOneOf10PriceStrategy(new int[]{150, 230, 180, 2350, 17, 360, 190, 440, 550}), new PickOneOf10AvailabilityStrategy(new int[]{100, 190, 200000, 2, 95, 30, 165, 185, 250}), 5),
            new Drug("Mushrooms", basicPriceStrategy, basicAvailabilityStrategy, 7),
            new Drug("Valium", new BasePriceStrategy(290), new BaseAvailabilityStrategy(80), 7)
        };
    }
}
